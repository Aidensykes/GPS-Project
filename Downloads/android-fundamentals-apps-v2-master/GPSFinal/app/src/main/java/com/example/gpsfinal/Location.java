package com.example.gpsfinal;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class Location {

    @PrimaryKey
    public int locationID;

    @ColumnInfo(name = "xCoordinate")
    public String xCoordinate;

    @ColumnInfo(name = "yCoordinate")
    public String yCoordinate;

}
