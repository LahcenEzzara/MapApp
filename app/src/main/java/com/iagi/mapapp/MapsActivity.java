package com.iagi.mapapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.iagi.mapapp.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button buttonReturn = findViewById(R.id.button_return);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public Bitmap resizeBitmap(Bitmap bitmap, int newWidth, int newHeight) {
        return Bitmap.createScaledBitmap(bitmap, newWidth, newHeight, false);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Get the map type from the intent
        String mapType = getIntent().getStringExtra("MAP_TYPE");
        if ("satellite".equals(mapType)) {
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        } else {
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }

        // Define the new width and height for the images
        int newWidth = 100;  // You can adjust this value
        int newHeight = 100;  // You can adjust this value

        // Add a marker in Marrakech and move the camera
        LatLng marrakech = new LatLng(31.624948314438864, -7.987258421890261);  // Coordinates for Koutoubia Mosque in Marrakech
        Bitmap koutoubiaBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.koutoubia);
        Bitmap smallKoutoubiaBitmap = resizeBitmap(koutoubiaBitmap, newWidth, newHeight);
        MarkerOptions markerOptionsMarrakech = new MarkerOptions().position(marrakech).title("Marrakech").icon(BitmapDescriptorFactory.fromBitmap(smallKoutoubiaBitmap));
        mMap.addMarker(markerOptionsMarrakech);

        // Add a marker in Casablanca
        LatLng casablanca = new LatLng(33.574110943355436, -7.595076220262121);  // Coordinates for Hassan II Mosque in Casablanca
        Bitmap hassaniiBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hassanii);
        Bitmap smallHassaniiBitmap = resizeBitmap(hassaniiBitmap, newWidth, newHeight);
        MarkerOptions markerOptionsCasablanca = new MarkerOptions().position(casablanca).title("Casablanca").icon(BitmapDescriptorFactory.fromBitmap(smallHassaniiBitmap));
        mMap.addMarker(markerOptionsCasablanca);

        // Add a marker in Rabat
        LatLng rabat = new LatLng(34.01046732008569, -6.852117532830594);  // Coordinates for Mausoleum of Mohammed V in Rabat
        Bitmap mohammedvBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mohammedv);
        Bitmap smallMohammedvBitmap = resizeBitmap(mohammedvBitmap, newWidth, newHeight);
        MarkerOptions markerOptionsRabat = new MarkerOptions().position(rabat).title("Rabat").icon(BitmapDescriptorFactory.fromBitmap(smallMohammedvBitmap));
        mMap.addMarker(markerOptionsRabat);

        // Move the camera to Marrakech
        mMap.moveCamera(CameraUpdateFactory.newLatLng(marrakech));
    }


}