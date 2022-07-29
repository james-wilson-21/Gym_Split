package com.example.gymsplit;

import androidx.room.Insert;

@androidx.room.Dao
public interface UserDao {
    @Insert
    public void addUser(User user);
}
