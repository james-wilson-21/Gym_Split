package com.example.gymsplit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddWorkout extends AppCompatActivity {

    // Initialise variables
    public static GymDatabase gymDatabase;
    TextView workOutName, splitDays;

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
    }
}