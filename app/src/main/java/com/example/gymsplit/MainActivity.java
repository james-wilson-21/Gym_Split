package com.example.gymsplit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Handle the splash screen transition
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);

        // Keep splash screen on for longer
        View content = findViewById(android.R.id.content);

        // Add pre-draw listener to view tree observer
//        content.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
//            @Override
//            public boolean onPreDraw() {
//                return false;
//            }
//        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}