package com.huawei.estravo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_card_layout extends RecyclerView.Adapter<Adapter_card_layout.ViewHolder>{
    private List<Model_card_class> userList;

    public Adapter_card_layout(List<Model_card_class>userList) {
        this.userList=userList;
    }
    @NonNull
    @Override
    public Adapter_card_layout.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        return new Adapter_card_layout.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int resource = userList.get(position).getImageview();
        String tv1=userList.get(position).getTextview1();
        String tv2=userList.get(position).getTextview2();
        holder.setData(resource,tv1,tv2);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void filterList(List<Model_card_class> filteredList) {
        userList = filteredList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView1;
        private TextView textView2;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //here use xml ids
            //give different name not like constructor
            imageView=itemView.findViewById(R.id.imageview);
            textView1=itemView.findViewById(R.id.textview1);
            textView2=itemView.findViewById(R.id.textview2);

        }

        public void setData(int resource, String tv1, String tv2) {

            imageView.setImageResource(resource);
            textView1.setText(tv1);
            textView2.setText(tv2);

        }
    }
}

