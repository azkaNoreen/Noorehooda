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
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    QDH qdh = new QDH();
    QuranArabicText quranArabicText = new QuranArabicText();
    String[] QuranArabicText = quranArabicText.QuranArabicText;
    int[] SSP = qdh.SSP;
    int[] PSP = qdh.PSP;
    String[] englishSurahNames = qdh.englishSurahNames;
    String[] ParahName = qdh.ParahName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.mylist);

        ArrayAdapter as = new ArrayAdapter(this, android.R.layout.simple_list_item_1, englishSurahNames);
        list.setAdapter(as);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String t = "";
                ArrayList<String> SurahVerses=getSurahVerses(position);
                Intent in = new Intent(MainActivity.this, Verses.class);
                in.putExtra("Quran", SurahVerses);
                startActivity(in);
            }
        });

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.surahIndex:
                        Toast.makeText(getApplicationContext(), "Surah INdex", Toast.LENGTH_LONG).show();
//                        Intent intent = new Intent(MainActivity.this, BookActivity.class);
//                        startActivity(intent);
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        ArrayAdapter as = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, englishSurahNames);
                        list.setAdapter(as);

                        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String t = "";
                                ArrayList<String> SurahVerses=getSurahVerses(position);
                                Intent in = new Intent(MainActivity.this, Verses.class);
                                in.putExtra("Quran", SurahVerses);
                                startActivity(in);
                            }
                        });
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.paraIndex:
                        ArrayAdapter ad = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, ParahName);
                        list.setAdapter(ad);

                        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String t = "";
                                ArrayList<String> SurahVerses=getParaVerses(position);
                                Intent in = new Intent(MainActivity.this, Verses.class);
                                in.putExtra("Quran", SurahVerses);
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
        int e= (position==SSP.length-1)?QuranArabicText.length-1:SSP[position + 1];
        ArrayList<String> verses = new ArrayList<String>();
        for (int i = s; i < e; i++) {
            verses.add(QuranArabicText[i - 1]);
        }
        return verses;
    }
    ArrayList<String> getParaVerses(int position) {
        int s = PSP[position];
        int e= (position==PSP.length-1)?QuranArabicText.length-1:PSP[position + 1];
        ArrayList<String> verses = new ArrayList<String>();
        for (int i = s; i < e; i++) {
            verses.add(QuranArabicText[i - 1]);
        }
        return verses;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(getApplicationContext(), "Start", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getApplicationContext(), "End", Toast.LENGTH_LONG).show();
        }
    }
}