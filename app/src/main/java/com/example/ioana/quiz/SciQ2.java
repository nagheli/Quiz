package com.example.ioana.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SciQ2 extends AppCompatActivity {


    TextView scorePoints;
    int score;
    int answerPoints;
    EditText answer;
    Button nextQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sci_q2);

        answer = (EditText) findViewById(R.id.answerS31);
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
                // create a new intent to open the SciQ3 activity
                if(answer.getText().toString().equalsIgnoreCase("Air")) {
                    answerPoints++;}
                else{answerPoints = answerPoints + 0;
                }

                if(!answer.getText().toString().equals(""))
                {
                    sendData();

                }
            }
        });
    }

    private void sendData() {
        //GET PRIMITIVE VALUES TO SEND
        int score = answerPoints;

        //PACK THEM IN AN INTENT OBJECT
        Intent sciQ3Intent = new Intent(SciQ2.this,SciQ3.class);
        sciQ3Intent.putExtra("Score", score);

        //START SECOND ACTIVITY
        this.startActivity(sciQ3Intent);
    }


    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}

