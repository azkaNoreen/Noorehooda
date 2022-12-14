package com.example.noorehuda.assignment1;

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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.noorehuda.R;
import com.example.noorehuda.assignment2.AsmaUlHusna;
import com.example.noorehuda.assignment2.VersesTranslated;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    Button ss,sp,si,pi;
    ImageView show;
    AutoCompleteTextView ssurah,sparah;


    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    QDH qdh=new QDH();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ss = findViewById(R.id.ss);
        sp = findViewById(R.id.sp);
        si = findViewById(R.id.si);
        pi = findViewById(R.id.pi);
        show=findViewById(R.id.imag);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, AsmaUlHusna.class);
                startActivity(in);
            }
        });

        sparah = findViewById(R.id.sparah);
        ArrayAdapter<String> adapterparah = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, qdh.englishParahName);

        sparah.setThreshold(2);
        sparah.setAdapter(adapterparah);
        ssurah = findViewById(R.id.ssurah);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item, qdh.englishSurahNames);

        ssurah.setThreshold(2);
        ssurah.setAdapter(adapter);

        si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, Base.class);
                in.putExtra("Type", "Surah");
//                in.putExtra("Tran", tran);
                startActivity(in);
            }
        });
        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Base.class);
                intent.putExtra("Type", "Parah");
//                intent.putExtra("Tran", tran);
                startActivity(intent);
            }
        });
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, VersesTranslated.class);
                in.putExtra("Name",ssurah.getText().toString() );
                in.putExtra("Type","Surah");
                startActivity(in);
            }
        });
        sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, VersesTranslated.class);
                in.putExtra("Name",sparah.getText().toString() );
                in.putExtra("Type","Parah");
                startActivity(in);
            }
        });

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer);

//        View headerView = navigationView.inflateHeaderView(R.layout.header);

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
//                                in.putExtra("Tran", tran);
                                startActivity(in);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.paraIndex:
                        Intent intent = new Intent(MainActivity.this, Base.class);
                        intent.putExtra("Type", "Parah");
//                        intent.putExtra("Tran", tran);
                        startActivity(intent);
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

}