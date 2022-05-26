package com.huawei.estravo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Recycler_restaurants extends AppCompatActivity {
    LinearLayoutManager layoutManager;
    RecyclerView mrecyclerView;
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
        tv.setText("Restaurants");
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
    public void back(View view){
        Intent intent = new Intent(this,DashBoard.class);
        startActivity(intent);
    }
    public void go_profile(View view){
        Intent intent = new Intent(this,Profile.class);
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

        userList.add(new ModelClass(R.drawable.res_1, "La Cabana", "Ram Nagar", "10 KM from here"));

        userList.add(new ModelClass(R.drawable.res_2, "Welcome Cafe", "Race Course", "44 KM from here"));

        userList.add(new ModelClass(R.drawable.res_3, "Afghan Grill", "Avinashi Rd", "44 KM from here"));

        userList.add(new ModelClass(R.drawable.res_4, "KOVE", "RS Puram", "44 KM from here"));

    }


}
