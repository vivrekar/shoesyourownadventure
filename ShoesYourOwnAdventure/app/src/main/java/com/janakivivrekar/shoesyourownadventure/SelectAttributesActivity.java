package com.janakivivrekar.shoesyourownadventure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;

public class SelectAttributesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_attributes_screen);
        Intent nextActivity = new Intent(this, ActiveAdventureActivity.class);
        startActivity(nextActivity);
        /*ScrollView attributesScrollView = findViewById(R.id.attributes_scroll_view);
        CheckBox nature = findViewById(R.id.nature);
        if (nature.isChecked()) {
            nature.setChecked(true);
            createAttribute(nature, true);
        }*/
    }

    public void createAttribute(CheckBox checkbox, boolean isChecked) {
        int checkBoxId = checkbox.getId();
        if (checkBoxId == R.id.nature) {
            AdventureAttribute nature = new AdventureAttribute("nature", true);
        }
    }

}
