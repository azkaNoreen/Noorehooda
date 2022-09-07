package com.example.noorehuda.assignment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.noorehuda.R;
import com.example.noorehuda.assignment1.QDH;

public class AsmaUlHusna extends AppCompatActivity {
    QDH qdh=new QDH();
    RecyclerView mylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asma_ul_husna);
        mylist=findViewById(R.id.mylist);


        NamesRecyclerView ad = new NamesRecyclerView();
        mylist.setLayoutManager(new GridLayoutManager(this,3   ));
        ad.setData(qdh.AllahNames);
        mylist.setAdapter(ad);
    }
}