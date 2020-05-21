package com.example.gpsfinal;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Prepopulate Database before application starts
        //  Room.databaseBuilder(appContext, AppDatabase.class, "location.db")
        //          .createFromFile(new File("com\\example\\gpsfinal"))
        //          .build();


        // Save state on startup
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button flipActivity = findViewById(R.id.mapButton);
        flipActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("Button Clicked");
                Intent activity2Intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(activity2Intent);
            }
        });

        if (Build.VERSION.SDK_INT >= 23) {

            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // Request Location of GPS tracker
                // Permissions = To Access user's GPS

                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

            } else {
                // Request permission
                startService();
            }
            // Request Location

        } else {

            //start location services
            startService();
        }


    }

    void startService() {
        Intent intent = new Intent(MainActivity.this, LocationService.class);
        startService(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startService();
                } else {
                    Toast.makeText(this, "Give permissions to start", Toast.LENGTH_LONG).show();
                }
        }
    }


}

//setContentView(R.layout.activity_main);