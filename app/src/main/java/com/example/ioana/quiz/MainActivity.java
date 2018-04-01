package com.example.ioana.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView geography = (ImageView) findViewById(R.id.geography);
        ImageView science = (ImageView) findViewById(R.id.science);



        // set a click listener on that View
        geography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a new intent to open the Geography activity
                Intent geographyIntent = new Intent(MainActivity.this, com.example.ioana.quiz.Geography.class);
                // start the new activity
                startActivity(geographyIntent);
            }
        });

        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scienceIntent = new Intent(MainActivity.this, com.example.ioana.quiz.Science.class);
                startActivity(scienceIntent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
