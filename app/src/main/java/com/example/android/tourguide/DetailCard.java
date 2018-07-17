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
    private ArrayList <Location> mLocation;

    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_card);

        mLocation = new ArrayList <Location>();

        LocationAdapter adapter = new LocationAdapter(this.mLocation);
        RecyclerView rv = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);

        rv.setAdapter(adapter);

        Intent tIntent = getIntent();
        Location location = tIntent.getParcelableExtra("location");

        int image = location.getImage();
        String name = location.getName();
        String hours = location.getSchedule();
        String description = location.getDescription();
        String entryfee = location.getEntryFee();

        //create widgets
        detailImage = findViewById(R.id.detail_image);
        detailImage.setImageResource(image);

        detailTitle = findViewById(R.id.detail_name);
        detailTitle.setText(name);

        dHours = findViewById(R.id.hours);
        dHours.setText(hours);

        detailDescription = findViewById(R.id.detail_description);
        detailDescription.setText(description);

        fees = findViewById(R.id.fees);
        fees.setText(entryfee);
    }
}
