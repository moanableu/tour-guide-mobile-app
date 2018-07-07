package com.example.android.tourguide;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * resources: Coding in Flow Navigation Drawer with Fragments
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayList<Location> mLocation;
    private DrawerLayout drawer;


    private TextView tour_name, tour_name1, tour_name2, tour_name3;
    //private ImageView image0, image1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.layout_drawer);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navbaropen, R.string.navbarclose);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        final LocationAdapter adapter = new LocationAdapter(mLocation);

        FrameLayout frame1 = findViewById(R.id.category_container);
        frame1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MuseumArtActivity.class);
                startActivity(intent);
            }
        });
        }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_seightseeing:
                getSupportFragmentManager().beginTransaction().replace(R.id.f_container, new MuseumArtActivity()).commit();
                break;
            case R.id.nav_seightseeing1:
                getSupportFragmentManager().beginTransaction().replace(R.id.f_container, new SeightseeingFragment()).commit();
                break;
            case R.id.nav_seightseeing2:
                getSupportFragmentManager().beginTransaction().replace(R.id.f_container, new FoodDrinkFragment()).commit();
                break;
            case R.id.nav_seightseeing3:
                getSupportFragmentManager().beginTransaction().replace(R.id.f_container, new BerlinaleFragment()).commit();
                break;
            case R.id.calendar:
                Toast.makeText(this, "Save to calendar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.maps:
                Toast.makeText(this, "Get directions", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();}
    }


}
