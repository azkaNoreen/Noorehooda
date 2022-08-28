package com.example.noorehuda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Verses extends AppCompatActivity {
ListView versesShowList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verses);

        versesShowList=findViewById(R.id.versesShowList);
        DBAccess dbAccess=DBAccess.getInstance(getApplicationContext());
        dbAccess.open();

        int pos=getIntent().getIntExtra("pos",0);
        String type=getIntent().getStringExtra("Type");
        if(type.equals("Surah")){
            ArrayList<PairString> SurahVerses=dbAccess.getSurahAyahs(pos);
            myAdapter as = new myAdapter(this, SurahVerses);
            versesShowList.setAdapter(as);
        }
        else{
            ArrayList<PairString> SurahVerses=dbAccess.getParahAyahs(pos);
            myAdapter as = new myAdapter(this, SurahVerses);
            versesShowList.setAdapter(as);
        }
    }
}