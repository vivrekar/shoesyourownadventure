package com.janakivivrekar.shoesyourownadventure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button begin_button = findViewById(R.id.begin_button);
        ConnectShoesIntent = new Intent(WelcomeActivity.this, ConnectShoesActivity.class);
        begin_button.setOnClickListener(new begin_button.OnClickListener() {
            public void onClick(View v) {
                startActivity(ConnnectShoesIntent);
            }
    })

}
