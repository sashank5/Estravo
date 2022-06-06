package com.huawei.estravo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Recycler_emergency extends AppCompatActivity {

    RecyclerView mrecyclerView;
    List<Model_card_class> userList;
    Adapter_card_layout adapterRelativelayout;
    SearchView searchView;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        initData();
        initRecyclerView();
        tv=findViewById(R.id.tv34);
        tv.setText("Emergency Services");
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
        onBackPressed();

    }
    public void home(View view){
        Intent intent = new Intent(this,DashBoard.class);
        startActivity(intent);
    }
    public void go_profile(View view){
        Intent intent = new Intent(this,Profile.class);
        startActivity(intent);
    }
    private void filter(String newText){
        List<Model_card_class> filteredList = new ArrayList<>();
        for(Model_card_class item : userList){
            if(item.getTextview1().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(item);
            }
            adapterRelativelayout.filterList(filteredList);
        }
    }
    private void initRecyclerView() {
        mrecyclerView = findViewById(R.id.RecyclerView);
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        mrecyclerView.setLayoutManager(manager);
        adapterRelativelayout = new Adapter_card_layout(userList);
        mrecyclerView.setAdapter(adapterRelativelayout);
        adapterRelativelayout.notifyDataSetChanged();

    }
    private void initData() {
        userList = new ArrayList<>();

        userList.add(new Model_card_class(R.drawable.police, "Police", "Dial: 100"));

        userList.add(new Model_card_class(R.drawable.ambulance, "Ambulance", "Dial: 108"));

        userList.add(new Model_card_class(R.drawable.fire, "Fire", "Dial: 104"));

        userList.add(new Model_card_class(R.drawable.women, "Women Helpline", "Dial: 1091"));

    }


}
