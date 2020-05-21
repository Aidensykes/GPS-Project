package com.example.gpsfinal;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

//Initializing Class used in Android Room database. This is how information is stored locally rather than using an online database.

@Entity(tableName = "location")
public class Location {

    @PrimaryKey(autoGenerate = true)
    private int locationID;

    @ColumnInfo(name = "xCoordinate")
    private Double xCoordinate;

    @ColumnInfo(name = "yCoordinate")
    private Double yCoordinate;

    public Location(int locationID, Double xCoordinate, Double yCoordinate){

        this.locationID = locationID;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

    }

    @Ignore
    public Location(Double xCoordinate, Double yCoordinate){

        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

    }

    
public int getLocationID() {return locationID;}

public void setLocationID(int locationID) {this.locationID = locationID;}

public double getx() {return xCoordinate;}

public void setx(double xCoordinate) {this.xCoordinate = xCoordinate;}

public double gety() {return yCoordinate;}

public void sety(double yCoordinate) {this.yCoordinate = yCoordinate;}

}
