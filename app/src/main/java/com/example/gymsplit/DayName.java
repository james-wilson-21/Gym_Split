package com.example.gymsplit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DayName extends AppCompatActivity {

    TextView dayView, dayText, dayName;

    EditText editName;

    Button dayOneExit, dayOneNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_name);

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
        String getDayName = editName.getText().toString();
        String exitButton = getResources().getString(R.string.exit_button);
        dayOneExit.setText(exitButton);
        String nextButton = getResources().getString(R.string.next_button);
        dayOneNext.setText(nextButton);

        dayOneExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                finish();
            }
        });

        dayOneNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DayName.this, Exercise.class);
                intent.putExtra("dayName", getDayName);
                intent.putExtra("dayNumber", one);
                startActivity(intent);
            }
        });
    }
}
