package com.example.android.tourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailCard extends AppCompatActivity {
    private ImageView detailImage;
    private TextView detailTitle, detailDescription, hours, fees;
    private ArrayList <Location> mLocation;
    private LocationAdapter mAdapter;
    private LocationAdapter.OnItemClickListener mListener;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_card);

        new ArrayList<Location>();


        LocationAdapter adapter = new LocationAdapter(mLocation);
        RecyclerView rv = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);

        rv.setAdapter(adapter);

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
