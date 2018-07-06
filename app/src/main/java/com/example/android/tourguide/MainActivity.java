package com.example.android.tourguide;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * resources: Coding in Flow Navigation Drawer with Fragments
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayList<TourCategory> mTourCategory;
    private ArrayList<Location> mLocation;
    private DrawerLayout drawer;

    // testing to see if I can implement the recycler view here directly
    private TextView name1, name, description1, description;
    private ImageView image0, image1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new SeightseeingFragment();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.layout_drawer);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navbaropen, R.string.navbarclose);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        final ArrayList<Tour> tours = new ArrayList <Tour>();
        tours.add(new Tour(R.drawable.seightseeing, "Museums & Kust", "Hammock pour-over chambray normcore YOLO vinyl."));
        tours.add(new Tour(R.drawable.seightseeing, "Restaurants & Breweries", "Distillery butcher portland celiac cray."));
        tours.add(new Tour(R.drawable.seightseeing, "Seightseeing", "Banjo polaroid selvage pitchfork asymmetrical, tumblr heirloom pour-over raw denim."));
        tours.add(new Tour(R.drawable.seightseeing, "Berlinale","Quinoa fixie subway tile man bun skateboard dreamcatcher."));

        TourAdapter adapter = new TourAdapter(this, tours);
        ListView listView = findViewById(R.id.tour_list);
        listView.setAdapter(adapter);

        //pending onItemClick method
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_seightseeing:
                getSupportFragmentManager().beginTransaction().replace(R.id.f_container, new SeightseeingFragment()).commit();
                break;
            case R.id.nav_seightseeing1:
                getSupportFragmentManager().beginTransaction().replace(R.id.f_container, new SeightseeingFragment()).commit();
                break;
            case R.id.nav_seightseeing2:
                getSupportFragmentManager().beginTransaction().replace(R.id.f_container, new SeightseeingFragment()).commit();
                break;
            case R.id.calendar:
                Toast.makeText(this, "Save to calendar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.maps:
                Toast.makeText(this, "Get directions", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                Toast.makeText(this, "Save to calendar", Toast.LENGTH_SHORT).show();
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
