package com.example.gpsfinal;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

// Dao = Data access objects.

// Used to store queries and methods for accessing the database

@Dao
public interface LocationDao {

    @Query("SELECT * FROM location")
    List<Location> getAll();

    @Query("SELECT * FROM location WHERE locationID IN (:locationIDs)")
    List<Location> loadAllByIds(int[] locationIDs);

   // @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
    //        "last_name LIKE :last LIMIT 1")
   // User findByName(String first, String last);

    @Insert
    void insertAll(Location... locations);

    @Delete
    void delete(Location location);


}
