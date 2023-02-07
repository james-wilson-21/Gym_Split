package com.example.gymsplit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    // Initialise variables
    TextView currentUserName;
    Button logoutButton;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // Assign Variables
        currentUserName = findViewById(R.id.currentUserName);
        logoutButton = findViewById(R.id.logoutButton);

        // Initialise SessionManager
        sessionManager = new SessionManager(getApplicationContext());

        // Get username from session
        String sUsername = sessionManager.getUsername();
        // Set username on the TextView
        currentUserName.setText(sUsername);

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
}