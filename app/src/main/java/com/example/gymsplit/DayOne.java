package com.example.gymsplit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DayOne extends AppCompatActivity {

    TextView dayView, dayText, dayName;

    EditText editName;

    Button dayOneExit, dayOneNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_one);

        // Assign Variables
        dayView = findViewById(R.id.dayOneDayView);
        dayText = findViewById(R.id.dayOneTextView);
        dayName = findViewById(R.id.dayOneNameView);
        editName = findViewById(R.id.dayOneEditView);
        dayOneExit = findViewById(R.id.dayOneExitButton);
        dayOneNext = findViewById(R.id.dayOneNextButton);
        // Set TextView Strings
        String dayTitle = getResources().getString(R.string.day_text);
        dayView.setText(dayTitle);
        String one = getResources().getString(R.string.one);
        dayText.setText(one);
        String firstDay = getResources().getString(R.string.day_name_text);
        dayName.setText(firstDay);
        String exitButton = getResources().getString(R.string.exit_button);
        dayOneExit.setText(exitButton);
        String nextButton = getResources().getString(R.string.next_button);
        dayOneNext.setText(nextButton);
    }
}
