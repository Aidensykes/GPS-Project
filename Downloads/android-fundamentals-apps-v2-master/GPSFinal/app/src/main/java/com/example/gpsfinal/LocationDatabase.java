package com.example.gpsfinal;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.google.android.gms.location.LocationCallback;

@Database(entities = {Location.class}, version = 1)
public abstract class LocationDatabase extends RoomDatabase {

    private static final String databaseName = "Location_db";
    private static LocationDatabase instance;

    public static synchronized LocationDatabase getInstance(LocationCallback context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), LocationDatabase.class,databaseName)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
    public abstract LocationDao LocationDao();
}