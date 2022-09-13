package com.example.gymsplit;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

    // Initialise Variables
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    // SessionManager constructor
    public SessionManager (Context context) {
        sharedPreferences = context.getSharedPreferences("AppKey", 0);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    // Create set Login method
    public void setLogin (boolean login) {
        editor.putBoolean("KEY_LOGIN", login);
        editor.commit();
    }

    // Create the get Login method
    public boolean getLogin () {
        return sharedPreferences.getBoolean("KEY_LOGIN", false);
    }

    // Set the username
    public void setUsername (String userName) {
        editor.putString("KEY_USERNAME", userName);
        editor.commit();
    }

    public String getUsername () {
        return sharedPreferences.getString("KEY_USERNAME", "");
    }
}
