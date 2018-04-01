package com.example.ioana.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class SciQ1 extends AppCompatActivity {


    TextView scorePoints;
    int answerPoints = 0;
    int score;
    CheckBox optionOneQ1;
    CheckBox optionTwoQ1;
    CheckBox optionThreeQ1;
    CheckBox optionFourQ1;
    Button nextQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sci_q1);

        optionOneQ1 = (CheckBox) findViewById(R.id.checkBox);
        optionTwoQ1 = (CheckBox) findViewById(R.id.checkBox2);
        optionThreeQ1 = (CheckBox) findViewById(R.id.checkBox3);
        optionFourQ1 = (CheckBox) findViewById(R.id.checkBox4);
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
                // create a new intent to open the SciQ2 activity
                if(optionOneQ1.isChecked() || optionTwoQ1.isChecked()){
                    answerPoints = answerPoints + 0;                }
                else if (optionThreeQ1.isChecked() && optionFourQ1.isChecked()) {
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
        Intent sciQ2Intent = new Intent(SciQ1.this, SciQ2.class);
        sciQ2Intent.putExtra("Score", score);

        //START SECOND ACTIVITY
        this.startActivity(sciQ2Intent);
    }


    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}

