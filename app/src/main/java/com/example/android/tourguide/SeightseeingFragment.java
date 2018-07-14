package com.example.android.tourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class SeightseeingFragment extends Fragment {
    private ArrayList<Location> mLocation;

    private RecyclerView mRecyclerView;
    private LocationAdapter mAdapter; // limits displayed data  for improved performance
    private RecyclerView.LayoutManager mLayoutManager; //aligns items

    public SeightseeingFragment(){
        // required emtpy constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.rb_recyclerview,container,false);


        final ArrayList<Location> locations = new ArrayList <Location>();
        locations.add(new Location(R.drawable.seightseeing, "Museumsinsel", "One place for all the arts", "shop.smb.museum", "10-6pm", "Berlin", "Free"));
        locations.add(new Location(R.drawable.seightseeing,R.string.seightseeing, R.string.seigtseeing_intro));
        locations.add(new Location(R.drawable.seightseeing,R.string.seightseeing, R.string.seigtseeing_intro));
        locations.add(new Location(R.drawable.seightseeing,R.string.seightseeing, R.string.seigtseeing_intro));
        locations.add(new Location(R.drawable.seightseeing,R.string.seightseeing, R.string.seigtseeing_intro));
        locations.add(new Location(R.drawable.seightseeing,R.string.seightseeing, R.string.seigtseeing_intro));
        locations.add(new Location(R.drawable.seightseeing,R.string.seightseeing, R.string.seigtseeing_intro));
        locations.add(new Location(R.drawable.seightseeing,R.string.seightseeing, R.string.seigtseeing_intro));
        locations.add(new Location(R.drawable.seightseeing,R.string.seightseeing, R.string.seigtseeing_intro));

        // add onItemClickListener

        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new LocationAdapter(locations);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new LocationAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mLocation.get(position);

                /*Intent intent = new Intent(getActivity(), DetailCard.class); // TBT onItemClickListener + create card class!!
                if (getActivity().getIntent() != null){
                    intent.putExtra("position", position);
                    intent.putExtra("cardItem", mCard.get(position));
                }
                startActivity(intent);*/
            }
        });

        return rootView;

    }
}
