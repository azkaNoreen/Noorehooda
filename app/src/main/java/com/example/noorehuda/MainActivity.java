package com.example.noorehuda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    EditText ssurah;
    TextView show;
    Button ss;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    Boolean tran;

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
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.mylist);
        ssurah = findViewById(R.id.ssurah);
        ss = findViewById(R.id.ss);
        show = findViewById(R.id.show);


        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, SearchedVerses.class);
                in.putExtra("SurahName",ssurah.getText().toString() );
                startActivity(in);
            }
        });


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer);

        View headerView = navigationView.inflateHeaderView(R.layout.header);
        Switch sw=headerView.findViewById(R.id.tran);
        tran=true;
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    tran=false;
                }
                else{
                    tran=true;
                }
            }
        });

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.surahIndex:
                                Intent in = new Intent(MainActivity.this, Base.class);
                                in.putExtra("Type", "Surah");
                                in.putExtra("Tran", tran);
                                startActivity(in);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.paraIndex:
                        ArrayAdapter ad = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,  tran?EnglishParahName:ParahName);
                        list.setAdapter(ad);

                        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent in = new Intent(MainActivity.this, Verses.class);
                                in.putExtra("pos", position+1);
                                in.putExtra("Type", "Parah");
                                in.putExtra("Tran", tran);
                                startActivity(in);

                                startActivity(in);
                            }
                        });
                        drawerLayout.closeDrawer(GravityCompat.START);

                        break;

                    case R.id.EnglishTeanslation:
                        Toast.makeText(getApplicationContext(), "EnglishTeanslation", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.UrduTeanslation:
                        Toast.makeText(getApplicationContext(), "UrduTeanslation", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.web:
                        Toast.makeText(getApplicationContext(), "Our Website", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

                return true;
            }
        });
    }

    ArrayList<String> getSurahVerses(int position) {
        int s = SSP[position];
        int e= (position==SSP.length-1)?QuranArabicText.length+1:SSP[position + 1];
        ArrayList<String> verses = new ArrayList<String>();
        for (int i = s; i < e; i++) {
            verses.add(QuranArabicText[i - 1]);
        }
        return verses;
    }
    ArrayList<String> getParaVerses(int position) {
        int s = PSP[position];
        int e= (position==PSP.length-1)?QuranArabicText.length+1:PSP[position + 1];
        ArrayList<String> verses = new ArrayList<String>();
        for (int i = s; i < e; i++) {
            verses.add(QuranArabicText[i - 1]);
        }
        return verses;
    }
//
//    @Override
//    public void onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START);
//            Toast.makeText(getApplicationContext(), "Start", Toast.LENGTH_LONG).show();
//
//        } else {
//            Toast.makeText(getApplicationContext(), "End", Toast.LENGTH_LONG).show();
//        }
//    }
}