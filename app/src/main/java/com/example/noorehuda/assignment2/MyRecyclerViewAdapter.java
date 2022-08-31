package com.example.noorehuda.assignment2;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noorehuda.R;
import com.example.noorehuda.assignment1.Verses;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.myVH> {
    ArrayList<VerseAndTranslation> verseArrayList=new ArrayList<VerseAndTranslation>();

    @NonNull
    @Override
    public MyRecyclerViewAdapter.myVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singleverse,parent,false);
        return new myVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.myVH holder, int position) {
        VerseAndTranslation st=verseArrayList.get(position);
        myVH studentViewHolder= (myVH) holder;

        studentViewHolder.verse.setText(st.getVerse());
        studentViewHolder.translation.setText(st.getTranslation());
    }

    @Override
    public int getItemCount() {
        return verseArrayList.size();
    }
    public void setData(ArrayList<VerseAndTranslation> verseArrayList){
        this.verseArrayList=verseArrayList;
        notifyDataSetChanged();
    }

    public class myVH extends RecyclerView.ViewHolder{
        TextView verse;
        TextView translation;
        public myVH(@NonNull View itemView) {
            super(itemView);

            verse=itemView.findViewById(R.id.verse);
            translation=itemView.findViewById(R.id.translation);
        }
    }
}
