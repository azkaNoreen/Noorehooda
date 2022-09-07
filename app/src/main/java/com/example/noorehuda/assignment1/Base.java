package com.example.noorehuda.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.noorehuda.R;
import com.example.noorehuda.assignment2.ChapterRecyclerViewAdapter;
import com.example.noorehuda.assignment2.MyOnClickListener;
import com.example.noorehuda.assignment2.RVListChapters;
import com.example.noorehuda.assignment2.VersesTranslated;

public class Base extends AppCompatActivity {
    RecyclerView list;
    QDH qdh = new QDH();
    String[] englishSurahNames = qdh.englishSurahNames;
    String[] ParahName = qdh.ParahName;
    String[] EnglishParahName = qdh.englishParahName;
    String[] urduSurahNames = qdh.urduSurahNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        list = findViewById(R.id.mylist);

        String type = getIntent().getStringExtra("Type");
//        Boolean tran = getIntent().getBooleanExtra("Tran", false);

        if (type.equals("Surah")) {
//            ArrayAdapter as = new ArrayAdapter(Base.this, android.R.layout.simple_list_item_1,englishSurahNames);
            ChapterRecyclerViewAdapter as = new ChapterRecyclerViewAdapter();
            as.setData(qdh.GetSurahNames());
            list.setAdapter(as);
            list.setLayoutManager(new LinearLayoutManager(this));
            as.setMyInterface(new MyOnClickListener() {
                @Override
                public void onChapterClick(RVListChapters chapters) {
                    Intent in = new Intent(Base.this, VersesTranslated.class);
                    in.putExtra("pos", chapters.getPosition());
                    in.putExtra("Type", chapters.getType());
                    startActivity(in);
                }
            });
//            list.addOnItemTouchListener(new RecyclerIt);

//            list.setOnClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Intent in = new Intent(Base.this, VersesTranslated.class);
//                    in.putExtra("pos", position + 1);
//                    in.putExtra("Type", "Surah");
//                    startActivity(in);
//                }
//            });
        } else {
//            ArrayAdapter as = new ArrayAdapter(Base.this, android.R.layout.simple_list_item_1, EnglishParahName);
            ChapterRecyclerViewAdapter as = new ChapterRecyclerViewAdapter();
            as.setData(qdh.GetParahNames());
            list.setAdapter(as);
            list.setLayoutManager(new LinearLayoutManager(this));

            as.setMyInterface(new MyOnClickListener() {
                @Override
                public void onChapterClick(RVListChapters chapters) {
                    Intent in = new Intent(Base.this, VersesTranslated.class);
                    in.putExtra("pos", chapters.getPosition());
                    in.putExtra("Type", chapters.getType());
                    startActivity(in);
                }
            });
//            list.setAdapter(as);
//
//            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Intent in = new Intent(Base.this, VersesTranslated.class);
//                    in.putExtra("pos", position + 1);
//                    in.putExtra("Type", "Parah");
//                    startActivity(in);
//                }
//            })';

        }
    }
}