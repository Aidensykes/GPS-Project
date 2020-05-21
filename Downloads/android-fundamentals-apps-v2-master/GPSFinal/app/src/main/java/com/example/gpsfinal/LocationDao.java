package com.example.gpsfinal;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

// Dao = Data access objects.

// Used to store queries and methods for accessing the database

@Dao
public interface LocationDao {

 @Query("Select * from location")

    List<Location> getLocationList();

 @Insert
    void insertLocation(Location location);
 @Update
    void updateLocation(Location location);
 @Delete
    void deleteLocation(Location location);

}
