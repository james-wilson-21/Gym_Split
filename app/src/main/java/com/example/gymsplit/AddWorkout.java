package com.example.gymsplit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddWorkout extends AppCompatActivity {

    // Initialise variables
    TextView workOutName, splitDays;
    EditText workoutInput, splitInput;
    Button dayOneButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);

        // Assign Variables
        workOutName = findViewById(R.id.addWorkoutName);
        splitDays = findViewById(R.id.addSplitDays);
        dayOneButton = findViewById(R.id.dayOneButton);
        cancelButton = findViewById(R.id.cancelButton);
        workoutInput = findViewById(R.id.addWorkoutInput);
        splitInput = findViewById(R.id.addSplitDaysInput);

        String addWorkoutName = getResources().getString(R.string.add_workout_name);
        String addSplitDays = getResources().getString(R.string.add_split_days);
        String addDayButton = getResources().getString(R.string.day_one_button);
        String addCancelButton = getResources().getString(R.string.cancel_workout);

        workOutName.setText(addWorkoutName);
        splitDays.setText(addSplitDays);
        dayOneButton.setText(addDayButton);
        cancelButton.setText(addCancelButton);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainMenu.class));
                finish();
            }
        });

        dayOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AddWorkout.this, DayOne.class);
                intent.putExtra("keyname", workoutInput.getText().toString());
                intent.putExtra("keySplit", splitInput.getText().toString());
                startActivity(intent);
            }
        });
    }
}