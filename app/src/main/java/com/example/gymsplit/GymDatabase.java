package com.example.gymsplit;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class GymDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
