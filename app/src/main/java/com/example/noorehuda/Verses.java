package com.example.noorehuda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Verses extends AppCompatActivity {
TextView e;
ListView versesShowList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verses);

        e=findViewById(R.id.v);
        versesShowList=findViewById(R.id.versesShowList);


        ArrayList<String> email=getIntent().getStringArrayListExtra("Quran");
        ArrayAdapter as = new ArrayAdapter(this, android.R.layout.simple_list_item_1, email);
        versesShowList.setAdapter(as);


    }
}