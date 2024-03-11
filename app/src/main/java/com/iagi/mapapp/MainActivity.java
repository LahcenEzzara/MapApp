package com.iagi.mapapp;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

// MainActivity.java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonNormalMap = findViewById(R.id.button_normal_map);
        buttonNormalMap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("MAP_TYPE", "normal");
                startActivity(intent);
            }
        });

        Button buttonSatelliteMap = findViewById(R.id.button_satellite_map);
        buttonSatelliteMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("MAP_TYPE", "satellite");
                startActivity(intent);
            }
        });

        FloatingActionButton fabExit = findViewById(R.id.fab_exit);
        fabExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();  // This will finish all activities in the task
                System.exit(0);  // This will terminate the app
            }
        });
    }
}
