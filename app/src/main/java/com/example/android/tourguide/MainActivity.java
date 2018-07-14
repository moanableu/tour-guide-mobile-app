package com.example.android.tourguide;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * resources: Coding in Flow Navigation Drawer with Fragments tutorial
 * I also reverse engineered the template navigation bar that Android Studio provides
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayList<Location> mLocation;
    private DrawerLayout drawer;
    private RecyclerView mRecyclerView;
    private LocationAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new DetailCard();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.layout_drawer);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navbaropen, R.string.navbarclose);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
        getSupportFragmentManager().beginTransaction().replace(R.id.f_container, new IntroFragment()).commit();
        navigationView.setCheckedItem(R.id.nav_intro);
            }

        }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_intro:
                getSupportFragmentManager().beginTransaction().replace(R.id.f_container, new IntroFragment()).commit();
                break;
            case R.id.nav_seightseeing:
                getSupportFragmentManager().beginTransaction().replace(R.id.f_container, new MuseumArtFragment()).commit();
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
