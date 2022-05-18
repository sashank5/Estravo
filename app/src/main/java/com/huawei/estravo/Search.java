package com.huawei.estravo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadSystemException;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextClock;
import android.widget.TextView;
import java.util.ArrayList;
public class Search extends AppCompatActivity {

    SearchView s;
    ListView l;
    String locations[]
            = {"Agra","Bangalore","Chennai","Delhi","Hyderabad","Mumbai"};
    private Context context;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        s=findViewById(R.id.search);
        l = (ListView)findViewById(R.id.listview);
        ArrayAdapter<String> arr= new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, locations);
        s.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arr.getFilter().filter(newText);
                return false;
            }
        });
        l.setAdapter(arr);
    }
}