package com.example.gymsplit;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Workout") // "Workout" refers to the table name, not the Class below;

 public class Workout {

 @PrimaryKey(autoGenerate = true)
 @ColumnInfo(name = "ID")
 private int id;

 @ColumnInfo(name="workoutName")
 private String workoutName;

 @ColumnInfo(name = "splitDays")
 private int splitDays;

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getWorkoutName() {
  return workoutName;
 }

 public void setWorkoutName(String workoutName) {
  this.workoutName = workoutName;
 }

 public int getSplitDays() {
  return splitDays;
 }

 public void setSplitDays(int splitDays) {
  this.splitDays = splitDays;
 }
}
