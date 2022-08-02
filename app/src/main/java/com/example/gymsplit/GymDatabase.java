package com.example.gymsplit;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Workout.class}, version = 2)
public abstract class GymDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract WorkoutDao workoutDao();
}
