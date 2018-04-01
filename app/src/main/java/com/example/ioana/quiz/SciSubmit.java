package com.example.ioana.quiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SciSubmit extends AppCompatActivity {

    int answerPoints;
    int score;
    TextView scorePoints;
    Button restart;
    Button share;
    Button quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sci_submit);

        scorePoints = (TextView) findViewById(R.id.scorePoints);
        restart = (Button) findViewById(R.id.restart);
        share = (Button) findViewById(R.id.share);
        quit = (Button) findViewById(R.id.quit);

        //RECEIVE DATA FROM MAIN ACTIVITY
        score = getIntent().getExtras().getInt("Score");
        answerPoints = score;

        //SET THE DATA TO OUR LOCAL VIEWS
        scorePoints.setText(String.valueOf(score));

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a new intent to open the Science activity

                Intent intent = new Intent(SciSubmit.this,Science.class);
                startActivity(intent);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a new intent to open the Email app activity

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT,getString(R.string.category4));
                intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.scoree) + answerPoints + getString(R.string.scoreTextt));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a new intent to open the MainActivity activity

                Intent intent = new Intent(SciSubmit.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
