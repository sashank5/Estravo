package com.huawei.estravo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashBoard extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
    }

    public void profile(View view){
        Intent intent = new Intent(DashBoard.this,Profile.class);
        Bundle bundle = getIntent().getExtras();
        String User_name = bundle.getString("User_name");
        String Email = bundle.getString("Email");
        intent.putExtra("User_name",User_name);
        intent.putExtra("Email",Email);
        startActivity(intent);
    }
    public void top_destinations(View view){
        Intent intent = new Intent(DashBoard.this, TopDestinations.class);
        startActivity(intent);
    }
    public void restaurants(View view){
        Intent intent = new Intent(DashBoard.this, Restaurants.class);
        startActivity(intent);
    }
    public void emergency(View view){
        Intent intent = new Intent(DashBoard.this, EmergencyServices.class);
        startActivity(intent);
    }
    public void hotels(View view){
        Intent intent = new Intent(DashBoard.this, Recycler_hotels.class);
        startActivity(intent);
    }
    public void translations(View view){
        Intent intent = new Intent(DashBoard.this, EmergencyServices.class);
        startActivity(intent);
    }
    public void weather(View view){
        Intent intent = new Intent(DashBoard.this, Hotels.class);
        startActivity(intent);
    }

}