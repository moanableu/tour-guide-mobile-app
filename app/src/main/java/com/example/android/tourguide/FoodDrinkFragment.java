package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
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

public class FoodDrinkFragment extends Fragment {
    private ArrayList <Location> mLocation;

    private RecyclerView mRecyclerView;
    private LocationAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public FoodDrinkFragment() {
        // required emtpy constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.rb_recyclerview, container, false);

        final ArrayList <Location> locations = new ArrayList <Location>();
        locations.add(new Location(R.drawable.le_faubourg, R.string.fd_restos_1, R.string.fd_restos_1_desc, R.string.fd_restos_1_url, R.string.fd_restos_1_address, R.string.fd_restos_1_hours, R.string.fd_restos_1_cost));
        locations.add(new Location(R.drawable.neumond_restaurant, R.string.fd_restos_2, R.string.fd_restos_2_desc, R.string.fd_restos_2_url, R.string.fd_restos_2_address, R.string.fd_restos_2_hours, R.string.fd_restos_2_cost));
        locations.add(new Location(R.drawable.vox, R.string.fd_restos_3, R.string.fd_restos_3_desc, R.string.fd_restos_3_url, R.string.fd_restos_3_address, R.string.fd_restos_3_hours, R.string.fd_restos_3_cost));
        locations.add(new Location(R.drawable.patio, R.string.fd_restos_4, R.string.fd_restos_4_desc, R.string.fd_restos_4_url, R.string.fd_restos_4_address, R.string.fd_restos_4_hours, R.string.fd_restos_4_cost));

        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new LocationAdapter(locations);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mLocation = locations;

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
