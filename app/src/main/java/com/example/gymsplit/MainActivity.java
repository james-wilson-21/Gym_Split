package com.example.gymsplit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Initialise Variables
    boolean isAndroidReady = false;
    EditText loginUserName;
    Button loginButton, exitButton;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Handle the splash screen transition
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);

        // Keep splash screen on for longer
        View content = findViewById(android.R.id.content);

        // Add pre-draw listener to view tree observer
        content.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                if (isAndroidReady) {
                    content.getViewTreeObserver().removeOnPreDrawListener(this);
                }

                // Method for isAndroidReady boolean
                dismissSplashScreen();
                return false;
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Assign Variables
        loginUserName = findViewById(R.id.loginEditText);
        loginButton = findViewById(R.id.loginLoginButton);
        exitButton = findViewById(R.id.loginExitButton);

        sessionManager = new SessionManager(getApplicationContext());

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sUsername = loginUserName.getText().toString().trim();
            }
        });

        initialiseTitle();
    }

    private void dismissSplashScreen() {
        // establish handler
        new Handler().postDelayed(() -> {
            // change boolean
            isAndroidReady = true;
        }, 2000);
    }

    private void initialiseTitle() {

    }
}