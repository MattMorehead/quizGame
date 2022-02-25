package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.concurrent.ThreadLocalRandom;

public class quizActivity extends AppCompatActivity {

    String[] questions;
    String[] answers;
    String[] wrong;
    int score= 0;
    int randomNum = 0;
    int currentQuestion = 0;
    String message;
    TextView questionView;
    TextView statusView;
    RadioButton R0;
    RadioButton R1;
    RadioButton R2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constitution);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        message = intent.getStringExtra("name");
        questions = intent.getStringArrayExtra("QUESTIONS");
        answers = intent.getStringArrayExtra("ANSWERS");
        wrong = intent.getStringArrayExtra("WRONGS");
        questionView = findViewById(R.id.quizQuestion);
        statusView = findViewById(R.id.statusText);
        R0 =findViewById(R.id.radioButton);
        R1 =findViewById(R.id.radioButton2);
        R2 =findViewById(R.id.radioButton3);


        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
        questionSet(0);

    }
    public void questionSet(int qIndex){
        R0.setChecked(false);
        R1.setChecked(false);
        R2.setChecked(false);
        randomNum = ThreadLocalRandom.current().nextInt(0, 3);
        questionView.setText(questions[qIndex]);
        statusView.setText("");

        int badIndex1 = ThreadLocalRandom.current().nextInt(0, wrong.length);
        int badIndex2 = ThreadLocalRandom.current().nextInt(0, wrong.length);
        while (badIndex1 == badIndex2){
            badIndex2 = ThreadLocalRandom.current().nextInt(0, wrong.length);
        }

        if (randomNum == 0){
            R0.setText(answers[qIndex]);
            R1.setText(wrong[badIndex1]);
            R2.setText(wrong[badIndex2]);

        }
        else if(randomNum == 1){
            R1.setText(answers[qIndex]);
            R0.setText(wrong[badIndex1]);
            R2.setText(wrong[badIndex2]);
        }
        else {
            R2.setText(answers[qIndex]);
            R0.setText(wrong[badIndex1]);
            R1.setText(wrong[badIndex2]);
        }

    }
    public void pickAnswer(View view){
        if ((R0.isChecked() && randomNum == 0) || (R1.isChecked() && randomNum == 1)|| (R2.isChecked() && randomNum == 2) ){
            score++;
            statusView.setText("Correct!");

        }
        else{
            statusView.setText("Wrong!");
        }
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 1000ms
                currentQuestion++;
                if(currentQuestion >= questions.length){
                    // go to results activity pass score and name
                    Intent intent = new Intent(quizActivity.this, resultsActivity.class);
                    intent.putExtra("SCORE", score);
                    intent.putExtra("NAME", message);
                    startActivity(intent);
                }
                else {
                    questionSet(currentQuestion);}

            }
        }, 1000);
    }

}