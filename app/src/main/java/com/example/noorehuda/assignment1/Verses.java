package com.example.noorehuda.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.noorehuda.R;
import com.example.noorehuda.assignment1.DBAccess;
import com.example.noorehuda.assignment1.PairString;
import com.example.noorehuda.assignment1.QDH;
import com.example.noorehuda.assignment1.myAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Verses extends AppCompatActivity {
    ListView versesShowList;
    private QDH qdh = new QDH();


    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verses);

        versesShowList = findViewById(R.id.versesShowList);
        DBAccess dbAccess = DBAccess.getInstance(getApplicationContext());
        dbAccess.open();

        int pos = getIntent().getIntExtra("pos", -1);
        String type = getIntent().getStringExtra("Type");
        String Name = getIntent().getStringExtra("Name");

        if (pos < 0)  //its search results
        {
            if (type.equals("Surah")) {
                int position = qdh.getSurahID(Name) + 1;
                ArrayList<PairString> SurahVerses = dbAccess.getSurahAyahs(position);
                myAdapter as = new myAdapter(this, SurahVerses);
                versesShowList.setAdapter(as);
            } else {
                int position = qdh.getParahID(Name) + 1;
                ArrayList<PairString> SurahVerses = dbAccess.getParahAyahs(position);
                myAdapter as = new myAdapter(this, SurahVerses);
                versesShowList.setAdapter(as);
            }
        } else {
            if (type.equals("Surah")) {
                ArrayList<PairString> SurahVerses = dbAccess.getSurahAyahs(pos);
                myAdapter as = new myAdapter(this, SurahVerses);
                versesShowList.setAdapter(as);
            } else {
                ArrayList<PairString> SurahVerses = dbAccess.getParahAyahs(pos);
                myAdapter as = new myAdapter(this, SurahVerses);
                versesShowList.setAdapter(as);
            }
        }

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                switch (menuItem.getItemId()) {
//                    case R.id.TranslatorName:
//                        Toast.makeText(getApplicationContext(), "Teanslator1", Toast.LENGTH_LONG).show();
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//
//                    case R.id.TranslatorName2:
//                        Toast.makeText(getApplicationContext(), "Teanslator27", Toast.LENGTH_LONG).show();
//                        drawerLayout.closeDrawer(GravityCompat.START);
//                        break;
//                }
//
//                return true;
//            }
//        });
    }


}