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
        locations.add(new Location(R.drawable.reisen_berlin, R.string.kunst_1,  R.string.kunst_1_desc, R.string.kunst_1_url,  R.string.kunst_1_address, R.string.kunst_1_hours, R.string.kunst_1_cost));
        locations.add(new Location(R.drawable.bikini_berlin_mademoiselle_maurice, R.string.kunst_2,  R.string.kunst_2_desc, R.string.kunst_2_url,  R.string.kunst_2_address, R.string.kunst_2_hours, R.string.kunst_2_cost));
        locations.add(new Location(R.drawable.reisen_berlin, R.string.kunst_3,  R.string.kunst_3_desc, R.string.kunst_3_url,  R.string.kunst_3_address, R.string.kunst_3_4_hours, R.string.kunst_3_4_6_cost));
        locations.add(new Location(R.drawable.schinkelpavillion, R.string.kunst_10, R.string.kunst_10_desc, R.string.kunst_10_url, R.string.kunst_10_address, R.string.kunst_10_hours, R.string.kunst_10_cost));

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
