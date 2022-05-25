package com.huawei.estravo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_relative_layout extends RecyclerView.Adapter<Adapter_relative_layout.ViewHolder> {

    private List<ModelClass> userList;

    public Adapter_relative_layout(List<ModelClass>userList) {
        this.userList=userList;
    }


    @NonNull
    @Override
    public Adapter_relative_layout.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_relative_layout.ViewHolder holder, int position) {

        int resource = userList.get(position).getImageview();
        String tv1=userList.get(position).getTextview1();
        String tv2=userList.get(position).getTextview2();
        String tv3=userList.get(position).getTextview3();

        holder.setData(resource,tv1,tv2,tv3);



    }
    public void filterList(List<ModelClass> filteredList){
        userList = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    //view holder class



    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView1;
        private TextView textView2;
        private TextView textview3;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //here use xml ids
            //give different name not like constructor
            imageView=itemView.findViewById(R.id.imageview);
            textView1=itemView.findViewById(R.id.textview1);
            textView2=itemView.findViewById(R.id.textview2);
            textview3=itemView.findViewById(R.id.textview3);


        }

        public void setData(int resource, String tv1, String tv2, String tv3) {

            imageView.setImageResource(resource);
            textView1.setText(tv1);
            textView2.setText(tv2);
            textview3.setText(tv3);



        }
    }
}

