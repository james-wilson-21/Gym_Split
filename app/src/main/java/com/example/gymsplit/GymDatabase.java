package com.example.gymsplit;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Workout.class}, version = 1)
public abstract class GymDatabase extends RoomDatabase {
    public abstract WorkoutDao workoutDao();
}
