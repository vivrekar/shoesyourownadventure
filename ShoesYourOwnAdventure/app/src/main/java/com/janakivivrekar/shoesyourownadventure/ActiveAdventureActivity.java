package com.janakivivrekar.shoesyourownadventure;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ActiveAdventureActivity extends AppCompatActivity {
    boolean active = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_adventure_screen);
        final Button pause_resume_button = (Button) findViewById(R.id.pause_resume_button);
        final TextView adventureText = (TextView) findViewById(R.id.adventure_text);
        final ImageView adventureGraphic = (ImageView) findViewById(R.id.adventure_graphic);
        final Resources res = getResources();
        pause_resume_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (active) {
                    active = false;
                    // Change text, graphic and button to paused options
                    adventureText.setText(R.string.paused_text);
                    pause_resume_button.setText(R.string.resume);
                    adventureGraphic.setImageDrawable(res.getDrawable(R.drawable.take_break));
                } else {
                    active = true;
                    // Change text, graphic and button to active options
                    adventureText.setText(R.string.active_text);
                    pause_resume_button.setText(R.string.pause);
                    adventureGraphic.setImageDrawable(res.getDrawable(R.drawable.enjoy_adventure));
                }
            }
        });

        Button end_button = (Button) findViewById(R.id.end_button);
        end_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: uncomment when feedback screen is implemented
                //Intent nextActivity = new Intent(ActiveAdventureActivity.this, FeedbackActivity.class);
                //startActivity(nextActivity);
            }
        });
    }
}
