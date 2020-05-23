package com.example.gpsfinal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

/**
 * An activity that displays a Google map with a marker (pin) to indicate a particular location.
 */
// [START maps_marker_on_map_ready]
public class MapsActivity extends AppCompatActivity
        implements OnMapReadyCallback {
    // [START_EXCLUDE]
    // [START maps_marker_get_map_async]
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_maps);
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }





    @Override
    public void onMapReady(GoogleMap gpsMap) {

     //   LatLng home = new LatLng(53.6880146, -1.7967885);
     //   gpsMap.addMarker(new MarkerOptions().position(home)
     //           .title("Marker at home"));
     //   gpsMap.moveCamera(CameraUpdateFactory.newLatLng(home));

        // Instantiates a new Polyline object and adds points to define a rectangle
        PolylineOptions homeRoute = new PolylineOptions()
                .add(new LatLng(53.6880146, -1.7967885))
                .add(new LatLng(53.6937457, -1.7890395))  // North of the previous point, but at the same longitude
                .add(new LatLng(53.6945143, -1.7920865))  // Same latitude, and 30km to the west
                .add(new LatLng(53.6923227, -1.795391))  // Same longitude, and 16km to the south
                .add(new LatLng(53.6894861, -1.7969306)); // Closes the polyline.

// Get back the mutable Polyline
        Polyline polyline = gpsMap.addPolyline(homeRoute);



    }




}
