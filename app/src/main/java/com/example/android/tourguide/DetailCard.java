package com.example.android.tourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailCard extends AppCompatActivity {
    private ImageView detailImage;
    private TextView detailTitle, detailDescription, dHours, fees;
    private ArrayList <Location> locations;
    private LocationAdapter mAdapter;
    private LocationAdapter.OnItemClickListener mListener;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_card);

        LocationAdapter adapter = new LocationAdapter(locations);
        RecyclerView rv = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);

        rv.setAdapter(adapter);

        if (savedInstanceState == null) {
            locations = new ArrayList <Location>();
           // locations.get(int);
            getSupportFragmentManager().beginTransaction().replace(R.id.detail_card, new MuseumArtFragment()).commit();
            /*switch (locations){
                case 0:
                    getFragmentManager().beginTransaction().replace(R.id.content_container, new MuseumArtFragment()).commit();
                    break;
                case 1:
                    getFragmentManager().beginTransaction().replace(R.id.content_container, new SeightseeingFragment()).commit();
                    break;
                case 2:
                    getFragmentManager().beginTransaction().replace(R.id.content_container, new FoodDrinkFragment()).commit();
                    break;
                case 3:
                    getFragmentManager().beginTransaction().replace(R.id.content_container, new BerlinaleFragment()).commit();
                    break;*/
        } else {
            locations = savedInstanceState.getParcelableArrayList("cardItem");
        }

        //getSupportFragmentManager().beginTransaction().add(android.R.id.content, locations).commit();

        //locations = new ArrayList <>();

        Intent tIntent = getIntent();
        Location location = tIntent.getParcelableExtra("cardItem");
        int image = location.getImage();
        String name = location.getName();
        String hours = location.getSchedule();
        String description = location.getDescription();

        //create widgets
        detailImage = findViewById(R.id.detail_image);
        detailImage.setImageResource(image);

        detailTitle = findViewById(R.id.detail_name);
        detailTitle.setText(name);

        dHours = findViewById(R.id.hours);
        dHours.setText(hours);

        detailDescription = findViewById(R.id.detail_description);
        detailDescription.setText(description);
    }


}
