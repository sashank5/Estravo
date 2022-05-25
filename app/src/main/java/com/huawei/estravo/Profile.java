package com.huawei.estravo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Bundle bundle = getIntent().getExtras();
        String User_name = bundle.getString("User_name");
        String Email = bundle.getString("Email");
        TextView user_name = findViewById(R.id.user_name);
        user_name.setText("User Name: " + User_name);
        TextView email = findViewById(R.id.email);
        email.setText("Email Address: " + Email);

    }
    public void dashboard(View view){
        Intent intent = new Intent(Profile.this,DashBoard.class);
        startActivity(intent);
    }

}