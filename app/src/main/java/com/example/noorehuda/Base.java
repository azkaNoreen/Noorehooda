package com.example.noorehuda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Base extends AppCompatActivity {
    ListView list;
    QDH qdh = new QDH();
    QuranArabicText quranArabicText = new QuranArabicText();
    String[] QuranArabicText = quranArabicText.QuranArabicText;
    int[] SSP = qdh.SSP;
    int[] PSP = qdh.PSP;
    String[] englishSurahNames = qdh.englishSurahNames;
    String[] ParahName = qdh.ParahName;
    String[] EnglishParahName=qdh.englishParahName;
    String[] urduSurahNames =qdh.urduSurahNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        list=findViewById(R.id.mylist);

        String type=getIntent().getStringExtra("Type");
        Boolean tran=getIntent().getBooleanExtra("Tran",false);


        ArrayAdapter as = new ArrayAdapter(Base.this, android.R.layout.simple_list_item_1, tran?englishSurahNames:urduSurahNames);

        list.setAdapter(as);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in = new Intent(Base.this, Verses.class);
                in.putExtra("pos", position+1);
                in.putExtra("Type", "Surah");
                in.putExtra("Tran", tran);
                startActivity(in);
            }
        });
    }
}