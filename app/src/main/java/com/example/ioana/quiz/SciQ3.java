package com.example.ioana.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SciQ3 extends AppCompatActivity {


    TextView scorePoints;
    int answerPoints;
    int score;
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
        setContentView(R.layout.activity_sci_q3);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        optionOneQ1 = (RadioButton) findViewById(R.id.radioButton);
        optionTwoQ1 = (RadioButton) findViewById(R.id.radioButton2);
        optionThreeQ1 = (RadioButton) findViewById(R.id.radioButton3);
        optionFourQ1 = (RadioButton) findViewById(R.id.radioButton4);
        optionFiveQ1 = (RadioButton) findViewById(R.id.radioButton5);
        nextQuestion = (Button) findViewById(R.id.next);
        scorePoints = (TextView) findViewById(R.id.scorePoints);


        //RECEIVE DATA FROM MAIN ACTIVITY
        score = getIntent().getExtras().getInt("Score");
        answerPoints = score;

        //SET THE DATA TO OUR LOCAL VIEWS
        scorePoints.setText(String.valueOf(score));


        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create a new intent to open the SciQ4 activity
                if(optionThreeQ1.isChecked() || optionTwoQ1.isChecked() || optionOneQ1.isChecked()){
                    answerPoints = answerPoints + 0;
                }
                else if (optionFourQ1.isChecked()) {
                    answerPoints++;
                }
                if(optionFourQ1.isChecked() || optionThreeQ1.isChecked() || optionTwoQ1.isChecked() || optionOneQ1.isChecked())
                {   sendData();

                }
            }
        });
    }

    private void sendData() {
        //GET PRIMITIVE VALUES TO SEND
        int score = answerPoints;

        //PACK THEM IN AN INTENT OBJECT
        Intent sciQ4Intent = new Intent(SciQ3.this, SciQ4.class);
        sciQ4Intent.putExtra("Score", score);

        //START SECOND ACTIVITY
        this.startActivity(sciQ4Intent);
    }


    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}




