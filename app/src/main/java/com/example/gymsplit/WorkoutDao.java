package com.example.gymsplit;


import androidx.room.Insert;

@androidx.room.Dao
public interface WorkoutDao {
    @Insert
    public void addWorkout(Workout workout);
}
