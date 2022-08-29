package com.example.noorehuda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchedVerses extends AppCompatActivity {
    ListView versesShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searched_verses);

        versesShowList=findViewById(R.id.versesShowList);
        DBAccess dbAccess=DBAccess.getInstance(getApplicationContext());
        dbAccess.open();

        int pos=getIntent().getIntExtra("pos",0);
        String surahName=getIntent().getStringExtra("SurahName");
        ArrayList<PairString> SurahVerses=dbAccess.searchParah(surahName);
        myAdapter as = new myAdapter(this, SurahVerses);
        versesShowList.setAdapter(as);
//        if(type.equals("Surah")){
//            ArrayList<PairString> SurahVerses=dbAccess.getSurahAyahs(pos);
//            myAdapter as = new myAdapter(this, SurahVerses);
//            versesShowList.setAdapter(as);
//        }
//        else{
//            ArrayList<PairString> SurahVerses=dbAccess.getParahAyahs(pos);
//            myAdapter as = new myAdapter(this, SurahVerses);
//            versesShowList.setAdapter(as);
//        }
    }
}