package com.example.noorehuda.assignment2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noorehuda.R;

import java.util.ArrayList;

public class NamesRecyclerView extends RecyclerView.Adapter<NamesRecyclerView.namesVH> {
    String[] myList;
    @NonNull
    @Override
    public NamesRecyclerView.namesVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.namelist,parent,false);
        return new NamesRecyclerView.namesVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NamesRecyclerView.namesVH holder, int position) {
        String st=myList[position];
        NamesRecyclerView.namesVH listViewHolder= (NamesRecyclerView.namesVH) holder;

        listViewHolder.name.setText(st);
    }

    @Override
    public int getItemCount() {
        return myList.length;
    }
    public void setData(String[] myList){
        this.myList=myList;
        notifyDataSetChanged();
    }
    public class namesVH extends RecyclerView.ViewHolder{
        TextView name;
        public namesVH(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);

        }
    }
}
