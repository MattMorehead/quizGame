package com.example.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class resultsActivity extends AppCompatActivity {

    TextView T1;
    TextView T2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Intent intent = getIntent();


        String name = intent.getStringExtra("NAME");

        int score = intent.getIntExtra("SCORE",0);
        T1 =findViewById(R.id.nameText);
        T2 =findViewById(R.id.scoreText);
        T1.setText(name);
        T2.setText(""+score);




    }
    public void restart(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}