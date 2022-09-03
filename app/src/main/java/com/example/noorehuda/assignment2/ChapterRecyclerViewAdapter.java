package com.example.noorehuda.assignment2;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noorehuda.R;

import java.util.ArrayList;

public class ChapterRecyclerViewAdapter extends RecyclerView.Adapter<ChapterRecyclerViewAdapter.MyVH> {
    ArrayList<RVListChapters> myList=new ArrayList<RVListChapters>();
    MyOnClickListener myOnClickListener;

    public void setMyInterface(MyOnClickListener myInterface){
        this.myOnClickListener=myInterface;
    }

    @NonNull
    @Override
    public ChapterRecyclerViewAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.chapterlist,parent,false);
        return new ChapterRecyclerViewAdapter.MyVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterRecyclerViewAdapter.MyVH holder, int position) {
        RVListChapters st=myList.get(position);
        ChapterRecyclerViewAdapter.MyVH listViewHolder= (ChapterRecyclerViewAdapter.MyVH) holder;

        listViewHolder.name.setText(st.getName());
        listViewHolder.englishName.setText(st.getEngName());
        listViewHolder.number.setText(st.getPosition()+"");

        listViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myOnClickListener.onCahpterClick(st);
            }
        });

    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
    public void setData(ArrayList<RVListChapters> myList){
        this.myList=myList;
        notifyDataSetChanged();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        TextView name;
        TextView englishName;
        ImageView imag;
        TextView number;

        public MyVH(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name);
            englishName=itemView.findViewById(R.id.englishName);
            number=itemView.findViewById(R.id.number);


        }
    }
}
