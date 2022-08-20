package com.example.gymsplit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;

public class MainActivity extends AppCompatActivity {
    // Boolean variable
    boolean isAndroidReady = false;
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
        checkUserExists();
        setContentView(R.layout.activity_login);

        initialiseTitle();
    }

    private void dismissSplashScreen() {
        // establish handler
        new Handler().postDelayed(() -> {
            // change boolean
            isAndroidReady = true;
        }, 2000);
    }

    private void checkUserExists() {

    }
    private void initialiseTitle() {

    }
}