package com.example.noorehuda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView surahs;
QDH qdh=new QDH();
QuranArabicText quranArabicText=new QuranArabicText();
    String[] QuranArabicText = quranArabicText.QuranArabicText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surahs = findViewById(R.id.mylist);
        String[] englishSurahNames = qdh.englishSurahNames;
        int[] SSP = qdh.SSP;


        ArrayAdapter as = new ArrayAdapter(this, android.R.layout.simple_list_item_1, englishSurahNames);
        surahs.setAdapter(as);

        surahs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String t = "";
                int s = SSP[position];
                int e = SSP[position + 1];
                ArrayList<String> SurahVerses=getSurahVerses(s,e);

                Intent in = new Intent(MainActivity.this, Verses.class);
                in.putExtra("Quran", SurahVerses);
                startActivity(in);


            }
        });
    }
    ArrayList<String> getSurahVerses(int start, int end)
    {
        ArrayList<String>  verses=new ArrayList<String>();
        for (int i = start; i < end; i++) {
//            String qs = QuranArabicText[i - 1];
//            t = t + qs;
            verses.add(QuranArabicText[i - 1]);
        }
        return verses;
    }

}