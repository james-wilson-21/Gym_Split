package com.example.gymsplit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AddWorkout extends AppCompatActivity {

    // Initialise variables
    public static GymDatabase gymDatabase;
    TextView workOutName, splitDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);

        workOutName = findViewById(R.id.addWorkoutName);
        splitDays = findViewById(R.id.addSplitDays);

        String addWorkoutName = getResources().getString(R.string.add_workout_name);
        String addSplitDays = getResources().getString(R.string.add_split_days);

        workOutName.setText(addWorkoutName);
        splitDays.setText(addSplitDays);


    }
}