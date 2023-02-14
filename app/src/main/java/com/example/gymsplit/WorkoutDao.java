package com.example.gymsplit;


import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@androidx.room.Dao
public interface WorkoutDao {
    @Insert
    public void addWorkout(Workout workout);
    @Query("SELECT * From Workout")
    List<Workout> getWorkout();
}
