package com.huawei.estravo;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class DashBoard extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        ActivityResultLauncher<String[]> locationPermissionRequest =
                registerForActivityResult(new ActivityResultContracts
                                .RequestMultiplePermissions(), result -> {
                            Boolean fineLocationGranted = result.getOrDefault(
                                    Manifest.permission.ACCESS_FINE_LOCATION, false);
                            Boolean coarseLocationGranted = result.getOrDefault(
                                    Manifest.permission.ACCESS_COARSE_LOCATION,false);
                            if (fineLocationGranted != null && fineLocationGranted) {

                            } else if (coarseLocationGranted != null && coarseLocationGranted) {

                            } else {
                            }
                        }
                );

        locationPermissionRequest.launch(new String[] {
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        });
    }

    public void profile(View view){
        Intent intent = new Intent(DashBoard.this,Profile.class);
        startActivity(intent);
    }
    public void top_destinations(View view){
        Intent intent = new Intent(DashBoard.this, Recycler_topdestinations.class);
        startActivity(intent);
    }
    public void restaurants(View view){
        Intent intent = new Intent(DashBoard.this, Recycler_restaurants.class);
        startActivity(intent);
    }
    public void emergency(View view){
        Intent intent = new Intent(DashBoard.this, Recycler_emergency.class);
        startActivity(intent);
    }
    public void hotels(View view){
        Intent intent = new Intent(DashBoard.this, Recycler_hotels.class);
        startActivity(intent);
    }
    public void weather(View view){
        Intent intent = new Intent(DashBoard.this, Weather.class);
        startActivity(intent);
    }
    public void translations(View view){
        Intent intent = new Intent(DashBoard.this,Translations.class);
        startActivity(intent);
    }


}