package com.example.whichnumberisbigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView score;
    private Button buttonLeft;
    private Button buttonRight;

    private int intScore;
    private int leftNum;
    private int rightNum;
    public static final int MAX_NUM = 1000;
    public static final int MIN_NUM = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        intScore = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        updateDisplay();

    }

    private void updateDisplay() {
        String scoreString = getResources().getString(R.string.main_score);
        score.setText(scoreString + " " + intScore);
        randomizeNumbers();
        buttonLeft.setText(String.valueOf(leftNum));
        buttonRight.setText(String.valueOf(rightNum));
    }

    private void randomizeNumbers() {
        leftNum = genNumber();
        rightNum = genNumber();

        while(leftNum == rightNum)
        {
          rightNum = genNumber();
        }
    }

    private int genNumber(){
        int range = MAX_NUM - MIN_NUM + 1;
        return MIN_NUM + (int)(Math.random() * range);

    }

    private void wireWidgets() {
        buttonLeft = findViewById(R.id.button_main_left);
        buttonRight = findViewById(R.id.button_main_right);
        score = findViewById(R.id.textview_main_score);
    }


    public void onLeftClick(View view) {
        String message;
        if(leftNum > rightNum) {
            message = "Correct!";
            intScore++;
        }
        else
        {
            message = "Incorrect!";
            intScore--;
        }

        updateDisplay();
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }

    public void onRightClick(View view) {
        String message;
        if(rightNum > leftNum)
        {
            message = "Correct!";
            intScore++;
            Toast.makeText(getApplicationContext(), message,Toast.LENGTH_SHORT).show();
            randomizeNumbers();
            updateDisplay();
        }
        else
        {
            message = "Incorrect!";
            intScore--;
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            randomizeNumbers();
            updateDisplay();
        }

    }
}
