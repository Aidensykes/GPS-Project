package com.example.gpsfinal;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Location {

    @PrimaryKey
    public int locationID;

    @ColumnInfo(name = "xCoordinate")
    public String xCoordinate;

    @ColumnInfo(name = "yCoordinate")
    public String yCoordinate;

}
