package com.janakivivrekar.shoesyourownadventure;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.Set;

public class ConnectShoesActivity extends AppCompatActivity {
    private int REQUEST_ENABLE_BT = 1;
    private String targetDevice = "Sarah's Feather";
    private boolean connected = false;

    // Create a BroadcastReceiver for ACTION_FOUND.
    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            System.out.println("!!!!!!!!!!!!!!!!!!IN BROADCASTRECEIVER.ONRECIEVE!!!!!!!!!!!!!!!!!!!!");
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Discovery has found a device. Get the BluetoothDevice
                // object and its info from the Intent.
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                checkAndConnectIfTarget(device);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connect_shoes_screen);

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            // Device doesn't support Bluetooth
            Toast.makeText(ConnectShoesActivity.this, "Device doesn't support Bluetooth!",
                    Toast.LENGTH_LONG).show();
        } else {
            // TODO: Remove these toasts
            Toast.makeText(ConnectShoesActivity.this, "Device supports Bluetooth!",
                    Toast.LENGTH_LONG).show();
        }

        // Check if Bluetooth is enabled else request permission
        // TODO: app behavior if user declines Bluetooth permissions?
        if (!bluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }

        // Check already paired devices for target device
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
        if (pairedDevices.size() > 0) {
            for (BluetoothDevice device : pairedDevices) {
                Toast.makeText(ConnectShoesActivity.this, "Checking " + device.getName(),
                        Toast.LENGTH_LONG).show();
                checkAndConnectIfTarget(device);
            }
        }

        // Device discovery
        // Register for broadcasts when a device is discovered.
        if (!connected) {
            System.out.println("!!!!!!!!!!!!!!!!!!CHECKING DISCOVERY DEVICES!!!!!!!!!!!!!!!!!!!!");
            IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
            registerReceiver(receiver, filter);
        }

        // TODO: what to do if device not found? put this whole thing in a loop?

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Unregister the ACTION_FOUND receiver.
        unregisterReceiver(receiver);

    }

    private void checkAndConnectIfTarget(BluetoothDevice device) {
        String deviceName = device.getName();
        String deviceHardwareAddress = device.getAddress(); // MAC address
        if (deviceName.equals(targetDevice)) {
            // TODO: Connect device
            ConnectThread connectThread = new ConnectThread(device);
            connectThread.run();
            connected = true;
            System.out.println("CONNECTED!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        } else {
            connected = false;
        }
    }

}

