package com.example.gpsfinal;


import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

public class LocationService extends Service {
    FusedLocationProviderClient fusedLocationProviderClient;
    LocationCallback locationCallback;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Provides Location updates. Specifications within requestLocation
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        locationCallback = new LocationCallback() {
            @Override

            // Upon getting a new location
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);

                //Display Latitude and Logitude information via tooltip

                Log.d("mylog", "Latitute:  " + locationResult.getLastLocation().getLatitude() + ", "
                        + "Longitude: " + locationResult.getLastLocation().getLongitude());
                Intent intent = new Intent("ACT_LOC");
                intent.putExtra("latitude", locationResult.getLastLocation().getLatitude());
                intent.putExtra("longitude", locationResult.getLastLocation().getLongitude());

                // Send location data to Android Room Database (Latitude + Longitude and such)
            //    LocationDatabase location_db = LocationDatabase.getInstance(this);
                String x = String.valueOf(locationResult.getLastLocation().getLatitude());
                String y = String.valueOf(locationResult.getLastLocation().getLongitude());
                Location location =
                        new Location(x,y);

                sendBroadcast(intent);



            }
        };
    }

    @Override
    // When service is started will start requesting locations
    public int onStartCommand(Intent intent, int flags, int startId) {
        requestLocation();
        return super.onStartCommand(intent, flags, startId);
    }

    private void requestLocation() {
        // Initialise object
        LocationRequest locationRequest = new LocationRequest();
        // Requests a new location given the interval below in milliseconds
        locationRequest.setInterval(5000);
        //Power accuracy
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        fusedLocationProviderClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper());
    }
}
