package com.example.gpsfinal;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Initializing Class used in Android Room database. This is how information is stored locally rather than using an online database.

@Entity
public class Location {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "LocationID")
    public int locationID;


    @ColumnInfo(name = "xCoordinate")
    public String xCoordinate;

    @ColumnInfo(name = "yCoordinate")
    public String yCoordinate;



}
