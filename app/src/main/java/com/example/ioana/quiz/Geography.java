package com.example.ioana.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Geography extends AppCompatActivity {


    TextView scorePoints;
    int answerPoints;
    RadioGroup radioGroup;
    RadioButton optionOneQ1;
    RadioButton optionTwoQ1;
    RadioButton optionThreeQ1;
    RadioButton optionFourQ1;
    RadioButton optionFiveQ1;
    Button nextQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geography);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        optionOneQ1 = (RadioButton) findViewById(R.id.radioButton);
        optionTwoQ1 = (RadioButton) findViewById(R.id.radioButton2);
        optionThreeQ1 = (RadioButton) findViewById(R.id.radioButton3);
        optionFourQ1 = (RadioButton) findViewById(R.id.radioButton4);
        optionFiveQ1 = (RadioButton) findViewById(R.id.radioButton5);
        nextQuestion = (Button) findViewById(R.id.next);
        scorePoints = (TextView) findViewById(R.id.scorePoints);


        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a new intent to open the GeoQ1 activity
                if(optionFiveQ1.isChecked() ||optionFourQ1.isChecked() || optionTwoQ1.isChecked() || optionOneQ1.isChecked()){
                    answerPoints = 0;
                }
                else if (optionThreeQ1.isChecked()) {
                    answerPoints++;
                }
                if(optionFiveQ1.isChecked() ||optionFourQ1.isChecked() || optionThreeQ1.isChecked() || optionTwoQ1.isChecked() || optionOneQ1.isChecked())
                {   sendData();

                }
            }
        });
    }

    private void sendData() {
        //GET PRIMITIVE VALUES TO SEND
        int score = answerPoints;

        //PACK THEM IN AN INTENT OBJECT
        Intent geoQ1Intent = new Intent(Geography.this, GeoQ1.class);
        geoQ1Intent.putExtra("Score", score);

        //START SECOND ACTIVITY
        this.startActivity(geoQ1Intent);
    }


    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}




