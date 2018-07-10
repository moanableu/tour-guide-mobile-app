package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TourDetailCard extends AppCompatActivity {
    private ImageView detailImage;
    private TextView detailTitle, detailDescription, hours, fees;
    private ArrayList<Location> mLocation;
    private LocationAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        detailImage = findViewById(R.id.detail_image);
        detailTitle = findViewById(R.id.detail_name);
        detailDescription = findViewById(R.id.detail_description);
        hours = findViewById(R.id.hours);
        fees = findViewById(R.id.fees);

        Intent tIntent = getIntent();
        Location location = tIntent.getParcelableExtra("position");
        int image = location.getImage();
        String name = location.getName();
        String address = location.getAddress();

        //create widgets
        ImageView imageView = findViewById(R.id.detail_image);
    }
}
