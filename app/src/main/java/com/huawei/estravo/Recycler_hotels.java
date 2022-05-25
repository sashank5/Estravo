package com.huawei.estravo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Recycler_hotels extends AppCompatActivity {
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
        initData();
        initRecyclerView();
        tv=findViewById(R.id.tv34);
        tv.setText("Hotels");
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
        Bundle bundle = getIntent().getExtras();
        String User_name = bundle.getString("User_name");
        String Email = bundle.getString("Email");
        intent.putExtra("User_name",User_name);
        intent.putExtra("Email",Email);
        startActivity(intent);
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

        userList.add(new ModelClass(R.drawable.hotel_1,"Vivanta Coimbatore","Railway Station","10 KM from here"));

        userList.add(new ModelClass(R.drawable.hotel_2,"Holiday Residency","Saravanampatti","44 KM from here"));

        userList.add(new ModelClass(R.drawable.hotel_3,"The Orbis Hotel","Peelamedu","44 KM from here"));

        userList.add(new ModelClass(R.drawable.hotel_4,"Welcomhotel","Race Course","44 KM from here"));

        userList.add(new ModelClass(R.drawable.hotel_5,"Ibis","Lakshmi Mills","44 KM from here"));
    }


}

