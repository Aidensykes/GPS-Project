package com.example.gpsfinal;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Route {

    @PrimaryKey
    public int RouteID;

    @ColumnInfo(name = "RouteName")
    public String RouteName;


}
