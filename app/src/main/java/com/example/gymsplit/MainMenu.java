package com.example.gymsplit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainMenu extends AppCompatActivity {

    // Initialise variables
    public static GymDatabase gymDatabase;
    TextView workOutTitle, currentUserName, tableWorkoutName, tableWorkoutSplitDays;
    Button logoutButton;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        gymDatabase = Room.databaseBuilder(getApplicationContext(), GymDatabase.class, "gymdb")
                .allowMainThreadQueries()
                .build();
        tableWorkoutName = findViewById(R.id.workoutNameText);
        tableWorkoutSplitDays =  findViewById(R.id.workoutSplitText);
        // Assign Variables
        currentUserName = findViewById(R.id.currentUserName);
        logoutButton = findViewById(R.id.logoutButton);
        workOutTitle = findViewById(R.id.workOutTitle);

        // Initialise SessionManager
        sessionManager = new SessionManager(getApplicationContext());

        // Set greeting string
        String greeting = getResources().getString(R.string.login_greeting);
        // Set work out menu title
        String workOut = getResources().getString(R.string.title_workout);
        // Get username from session
        String sUsername = sessionManager.getUsername();
        // Set username on the TextView
        currentUserName.setText(greeting + " " + sUsername);
        // Set work out title
        workOutTitle.setText(workOut);
        showWorkoutTable();

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialise alert dialog builder
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                // Set title
                builder .setTitle("Log out");
                // Set message
                builder.setMessage("Are you sure you want to log out?");
                // Set positive button
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Set login false
                        sessionManager.setLogin(false);
                        // Set username empty
                        sessionManager.setUsername("");
                        // Redirect activity
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        // Finish activity
                        finish();
                    }
                });
                // Set negative button
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Cancel dialog
                        dialog.cancel();
                    }
                });
                // Initialse alert dialog
                AlertDialog alertDialog = builder.create();
                // Show alert dialog
                alertDialog.show();
            }
        });
    }

    public void showWorkoutTable() {
    List<Workout> workout = gymDatabase.workoutDao().getWorkout();
    String workOutName= "", splitDayNumber= "";
    for(Workout text: workout) {
        workOutName += text.getWorkoutName() + "/n";
        splitDayNumber += text.getSplitDays() + "/n";
        tableWorkoutName.setText(workOutName);
        tableWorkoutSplitDays.setText(splitDayNumber);
    }
    }
}