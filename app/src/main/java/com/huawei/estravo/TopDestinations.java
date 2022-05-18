package com.huawei.estravo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TopDestinations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topdestinations);
    }
    public void home(View view){
        Intent intent = new Intent(this,DashBoard.class);
        startActivity(intent);
    }

}