package com.example.android.tourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailCard extends AppCompatActivity {
    private ImageView detailImage;
    private TextView detailTitle, detailDescription, hours, fees;
    private ArrayList<Location> mLocation;
    private LocationAdapter mAdapter;
    private LocationAdapter.OnItemClickListener mListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_card);

       /* mLocation = new ArrayList <Location>();
        mAdapter = new LocationAdapter(mLocation);*/

        /*
        detailDescription = findViewById(R.id.detail_description);
        hours = findViewById(R.id.hours);
        fees = findViewById(R.id.fees);*/

        Intent tIntent = getIntent();
        Location location = tIntent.getParcelableExtra("position");
        int image = location.getImage();
        String name = location.getName();
        //String address = location.getAddress();

        //create widgets
        detailImage = findViewById(R.id.detail_image);
        detailImage.setImageResource(image);

        detailTitle = findViewById(R.id.detail_name);
        detailTitle.setText(name);

        /*hours = findViewById(R.id.detail_description);
        hours.setText();*/
    }
}
