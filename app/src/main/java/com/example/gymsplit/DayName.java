package com.example.gymsplit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DayName extends AppCompatActivity {

    TextView dayView, dayText, dayName;

    EditText editName;

    Button dayNameExit, dayNameNext;

    String day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_name);
        // Assign Variables
        dayView = findViewById(R.id.dayNameDayView);
        dayText = findViewById(R.id.dayNameTextView);
        dayName = findViewById(R.id.dayNameView);
        editName = findViewById(R.id.dayNameEditView);
        dayNameExit = findViewById(R.id.dayNameExitButton);
        dayNameNext = findViewById(R.id.dayNameNextButton);
        Intent intent = getIntent();
        // Set TextView Strings
        String dayTitle = getResources().getString(R.string.day_text);
        dayView.setText(dayTitle);
//        String one = getResources().getString(R.string.one);
        int number = intent.getIntExtra("keyCurrent", 0);
        String keyCurrent = getDayNumber(number);
        dayText.setText(keyCurrent);
        String firstDay = getResources().getString(R.string.day_name_text);
        dayName.setText(firstDay);



        String getDayName = editName.getText().toString();
        int nextDayNumber = number++;
        String exitButton = getResources().getString(R.string.exit_button);
        dayNameExit.setText(exitButton);
        String nextButton = getResources().getString(R.string.next_button);
        dayNameNext.setText(nextButton);

        dayNameExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                finish();
            }
        });

        dayNameNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DayName.this, Exercise.class);
                intent.putExtra("dayName", getDayName);
                intent.putExtra("keyCurrent", nextDayNumber);
                startActivity(intent);
            }
        });
    }
    private String getDayNumber(int number) {
        switch(number) {
            case 1:
                day = getResources().getString(R.string.one);
                break;
            case 2:
                day = getResources().getString(R.string.two);
                break;
            case 3:
                day = getResources().getString(R.string.three);
                break;
            case 4:
                day = getResources().getString(R.string.four);
                break;
            case 5:
                day = getResources().getString(R.string.five);
                break;
            case 6:
                day = getResources().getString(R.string.six);
                break;
            case 7:
                day = getResources().getString(R.string.seven);
                break;
            default:
                day = "error";
                break;
        }
        return day;
    }
}

