package com.example.noorehuda.assignment2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.noorehuda.R;
import com.example.noorehuda.assignment1.DBAccess;
import com.example.noorehuda.assignment1.PairString;
import com.example.noorehuda.assignment1.QDH;
import com.example.noorehuda.assignment1.Verses;
import com.example.noorehuda.assignment1.myAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class VersesTranslated extends AppCompatActivity {
    RecyclerView versesShowList;
    private QDH qdh = new QDH();
    String translator;


    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    ArrayList<VerseAndTranslation> SurahVerseAndTranslation=new ArrayList<VerseAndTranslation>();
    int position;
    int positionFromIntent;
    String type,Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verses_translated);

        versesShowList = findViewById(R.id.versesShowList);
//        DBAccess dbAccess = DBAccess.getInstance(getApplicationContext());
//        dbAccess.open();

        positionFromIntent = getIntent().getIntExtra("pos", -1);
        type = getIntent().getStringExtra("Type");
        Name = getIntent().getStringExtra("Name");
        ArrayList<PairString> SurahVerses=new ArrayList<PairString>();
//        ArrayList<VerseAndTranslation> SurahVerseTr=new ArrayList<VerseAndTranslation>();
        translator="DrMohsinKhan";
        GetArrayAndInitRecycleView(SurahVerseAndTranslation, position,translator);


//        myAdapter as = new myAdapter(this, SurahVerses);
//        versesShowList.setAdapter(as);

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
                    case R.id.DrMohsinKhan:
//                        Toast.makeText(getApplicationContext(), "Teanslator1", Toast.LENGTH_LONG).show();
                        translator="DrMohsinKhan";
                        GetArrayAndInitRecycleView(SurahVerseAndTranslation, position,translator);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.MuftiTaqiUsmani:
                        translator="MuftiTaqiUsmani";
                        GetArrayAndInitRecycleView(SurahVerseAndTranslation, position,translator);

//                        Toast.makeText(getApplicationContext(), "Teanslator27", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.MehmoodulHassan:
                        translator="MehmoodulHassan";
                        GetArrayAndInitRecycleView(SurahVerseAndTranslation, position,translator);

                        Toast.makeText(getApplicationContext(), "Our Website", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.FatehMuhammadJalandhri:
                        translator="FatehMuhammadJalandhri";
                        GetArrayAndInitRecycleView(SurahVerseAndTranslation, position,translator);
                        Toast.makeText(getApplicationContext(), "Our Website", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

                return true;
            }
        });
    }
    public void GetArrayAndInitRecycleView(ArrayList<VerseAndTranslation> SurahVerseTr, int position,String translator )
    {
        DBAccess dbAccess = DBAccess.getInstance(getApplicationContext());
        dbAccess.open();
        if (positionFromIntent < 0)  //its search results
        {
            if (type.equals("Surah")) {
                position = qdh.getSurahID(Name) + 1;
                SurahVerseTr = dbAccess.getSurahAyahs(position,translator);
//                SurahVerseTr = dbAccess.getSurahAyahs(position,translator);
//                GetArrayAndInitRecycleView(SurahVerseAndTranslation, position,translator);
//                MyRecyclerViewAdapter ad = new MyRecyclerViewAdapter();
//                versesShowList.setLayoutManager(new LinearLayoutManager(this));
//                ad.setData(SurahVerseTr);
//                versesShowList.setAdapter(ad);
            } else {
                position = qdh.getParahID(Name) + 1;
//                SurahVerses = dbAccess.getParahAyahs(position);
                SurahVerseTr = dbAccess.getParahAyahs(position,translator);

            }
        } else {
            if (type.equals("Surah")) {
                SurahVerseTr = dbAccess.getSurahAyahs(positionFromIntent,translator);

            } else {
                SurahVerseTr = dbAccess.getParahAyahs(positionFromIntent,translator);

            }
        }


//        SurahVerseTr = dbAccess.getSurahAyahs(position,translator);
        MyRecyclerViewAdapter ad = new MyRecyclerViewAdapter();
        versesShowList.setLayoutManager(new LinearLayoutManager(this));
        ad.setData(SurahVerseTr);
        versesShowList.setAdapter(ad);
    }


}