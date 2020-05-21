package com.example.gpsfinal;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

//Initializing Class used in Android Room database. This is how information is stored locally rather than using an online database.

@Entity(tableName = "location")
public class Location {

    @PrimaryKey(autoGenerate = true)
    public int locationID;

    @ColumnInfo(name = "xCoordinate")
    public String xCoordinate;

    @ColumnInfo(name = "yCoordinate")
    public String yCoordinate;

    public Location(int locationID, String xCoordinate, String yCoordinate){

        this.locationID = locationID;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

    }

    @Ignore
    public Location(String xCoordinate, String yCoordinate){

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

    }


public int getLocationID() {return locationID;}

public void setLocationID(int locationID) {this.locationID = locationID;}

public String getx() {return xCoordinate;}

public void setx(String xCoordinate) {this.xCoordinate = xCoordinate;}

public String gety() {return yCoordinate;}

public void sety(String yCoordinate) {this.yCoordinate = yCoordinate;}

}
