package com.example.noorehuda.assignment2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noorehuda.R;

import java.util.ArrayList;

public class ChapterRecyclerViewAdapter extends RecyclerView.Adapter<ChapterRecyclerViewAdapter.MyVH> {
    ArrayList<VerseAndTranslation> myList=new ArrayList<VerseAndTranslation>();
    @NonNull
    @Override
    public ChapterRecyclerViewAdapter.MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.chapterlist,parent,false);
        return new ChapterRecyclerViewAdapter.MyVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterRecyclerViewAdapter.MyVH holder, int position) {
        VerseAndTranslation st=myList.get(position);
        ChapterRecyclerViewAdapter.MyVH listViewHolder= (ChapterRecyclerViewAdapter.MyVH) holder;

        listViewHolder.name.setText(st.getVerse());
        listViewHolder.englishName.setText(st.getTranslation());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }
    public void setData(ArrayList<VerseAndTranslation> myList){
        this.myList=myList;
        notifyDataSetChanged();
    }

    public class MyVH extends RecyclerView.ViewHolder {
        TextView name;
        TextView englishName;
        ImageView imag;

        public MyVH(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name);
            englishName=itemView.findViewById(R.id.englishName);
//            imag=itemView.findViewById(R.drawable.ic_launcher_background);

        }
    }
}
