package com.example.android.tourguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MuseumArtFragment extends Fragment {
    private ArrayList <Location> mLocation;

    private RecyclerView mRecyclerView;
    private LocationAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public MuseumArtFragment() {
        // required emtpy constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.rb_recyclerview, container, false);

        final ArrayList <Location> locations = new ArrayList <Location>();
        locations.add(new Location(R.drawable.bikini_berlin_mademoiselle_maurice, "Bikini Berlin", "One place for all the arts", "shop.smb.museum", "10-6pm", "Berlin", "Free"));
        locations.add(new Location(R.drawable.seightseeing, "Museumsinsel1", "One place for all the arts", "shop.smb.museum", "10-6pm", "Berlin", "Free"));
        locations.add(new Location(R.drawable.seightseeing, "Museumsinsel2", "One place for all the arts", "shop.smb.museum", "10-6pm", "Berlin", "Free"));
        locations.add(new Location(R.drawable.seightseeing, "Museumsinse3", "One place for all the arts", "shop.smb.museum", "10-6pm", "Berlin", "Free"));
        locations.add(new Location(R.drawable.seightseeing, "Museumsinsel4", "One place for all the arts", "shop.smb.museum", "10-6pm", "Berlin", "Free"));
        locations.add(new Location(R.drawable.seightseeing, "Museumsinsel5", "One place for all the arts", "shop.smb.museum", "10-6pm", "Berlin", "Free"));
        locations.add(new Location(R.drawable.seightseeing, "Museumsinse6", "One place for all the arts", "shop.smb.museum", "10-6pm", "Berlin", "Free"));
        locations.add(new Location(R.drawable.seightseeing, "Museumsinsel7", "One place for all the arts", "shop.smb.museum", "10-6pm", "Berlin", "Free"));
        locations.add(new Location(R.drawable.seightseeing, "Museumsinsel8", "One place for all the arts", "shop.smb.museum", "10-6pm", "Berlin", "Free"));

        mLocation = locations;

        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new LocationAdapter(locations);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new LocationAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Fragment LFragment = new MuseumArtFragment();
                Bundle data = new Bundle();
                data.putParcelableArrayList("array", mLocation);
                LFragment.setArguments(data);

                Intent intent = new Intent(getActivity(), DetailCard.class);
                if (getActivity().getIntent() != null) {
                    intent.putExtra("position", position);
                    Location location = mLocation.get(position);
                    intent.putExtra("location", location);
                }
                startActivity(intent);
            }
        });
        return rootView;
    }
}
