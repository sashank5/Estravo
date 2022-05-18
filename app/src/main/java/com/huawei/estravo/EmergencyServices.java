package com.huawei.estravo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EmergencyServices extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergencyservices);

    }

    public void home(View view){
        Intent intent = new Intent(this,DashBoard.class);
        startActivity(intent);
    }
    public void profile(View view){
        Intent intent = new Intent(this,Profile.class);
        Bundle bundle = getIntent().getExtras();
        String User_name = bundle.getString("User_name");
        String Email = bundle.getString("Email");
        intent.putExtra("User_name",User_name);
        intent.putExtra("Email",Email);
        startActivity(intent);
    }

}