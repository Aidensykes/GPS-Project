package com.example.gpsfinal;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Location.class,
        parentColumns = "LocationID",
        childColumns = "RouteID",
        onDelete = ForeignKey.NO_ACTION))

public class Route {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "RouteID")
    public int routeID;

    @ColumnInfo(name = "RouteName")
    public String routeName;

}
