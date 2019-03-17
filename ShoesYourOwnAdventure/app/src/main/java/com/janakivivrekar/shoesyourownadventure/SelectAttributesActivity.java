package com.janakivivrekar.shoesyourownadventure;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;

public class SelectAttributesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_attributes_screen);
        ScrollView attributesScrollView = findViewById(R.id.attributes_scroll_view);
    }
}