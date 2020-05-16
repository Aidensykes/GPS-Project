package com.example.gpsfinal;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
@Entity
public class Route {

    @PrimaryKey
    public int routeID;

    @ColumnInfo(name = "RouteName")
    public String routeName;

    // Foreign Key - Location

   // @Entity(foreignKeys = @ForeignKey(entity = Location.class,
   //         parentColumns = "locationID",
   //         childColumns = "routeID",
   //         onDelete = ForeignKey.CASCADE))


}
