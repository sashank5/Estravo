package com.huawei.estravo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Recycler_topdestinations extends AppCompatActivity {

    RecyclerView mrecyclerView;
    LinearLayoutManager layoutManager;
    List<ModelClass> userList;
    Adapter_relative_layout adapterRelativelayout;
    SearchView searchView;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        DashBoard d = new DashBoard();
        initData();
        initRecyclerView();
        tv=findViewById(R.id.tv34);
        tv.setText("Top Destinations");
        searchView = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return true;
            }
        });
    }
    public void go_profile(View view){
        Intent intent = new Intent(this,Profile.class);
        startActivity(intent);
    }
    public void back(View view){
        onBackPressed();

    }
    public void home(View view){
        Intent intent = new Intent(this,DashBoard.class);
        startActivity(intent);
    }
    private void filter(String newText){
        List<ModelClass> filteredList = new ArrayList<>();
        for(ModelClass item : userList){
            if(item.getTextview1().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(item);
            }
            adapterRelativelayout.filterList(filteredList);
        }
    }
    private void initRecyclerView() {
        mrecyclerView = findViewById(R.id.RecyclerView);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mrecyclerView.setLayoutManager(layoutManager);
        adapterRelativelayout = new Adapter_relative_layout(userList);
        mrecyclerView.setAdapter(adapterRelativelayout);
        adapterRelativelayout.notifyDataSetChanged();

    }
    private void initData() {
        userList = new ArrayList<>();

        userList.add(new ModelClass(R.drawable.top1, "Adiyogi", "Booluvampatti", "10 KM from here"));

        userList.add(new ModelClass(R.drawable.top2, "VOC Park & Zoo", "Gopalapuram", "44 KM from here"));

        userList.add(new ModelClass(R.drawable.top3, "Black Thunder", "Mettupalayam", "44 KM from here"));

        userList.add(new ModelClass(R.drawable.top4, "Marudhamalai", "Navavoor", "44 KM from here"));

        userList.add(new ModelClass(R.drawable.top5, "Brookefields Mall", "Ram Nagar", "44 KM from here"));
    }


}
