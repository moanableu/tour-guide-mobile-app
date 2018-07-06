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

public class CategoryFragment extends Fragment {
    private ArrayList<TourCategory> mTourCategory;
    private ArrayList<Location> mLocation;

    private RecyclerView mRecyclerView;
    private TourCategoryAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public CategoryFragment(){
        // required emtpy constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.rb_recyclerview,container,false);

        //add constructor with only img, name + desc!!!
        final ArrayList<TourCategory> categories = new ArrayList <TourCategory>();
        categories.add(new TourCategory(R.drawable.seightseeing, "Museums & Kust", "Hammock pour-over chambray normcore YOLO vinyl."));
        categories.add(new TourCategory(R.drawable.seightseeing, "Restaurants & Breweries", "Distillery butcher portland celiac cray."));
        categories.add(new TourCategory(R.drawable.seightseeing, "Seightseeing", "Banjo polaroid selvage pitchfork asymmetrical, tumblr heirloom pour-over raw denim."));
        categories.add(new TourCategory(R.drawable.seightseeing, "Berlinale", "Quinoa fixie subway tile man bun skateboard dreamcatcher."));


        mRecyclerView = rootView.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new TourCategoryAdapter(categories);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new TourCategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mTourCategory.get(position);

                // TBT onItemClickListener
                Intent intent = new Intent(getActivity(), SeightseeingFragment.class);
                if (getActivity().getIntent() != null){
                    //intent.putExtra("position", position);
                    //intent.putExtra("locationItem", mLocation.get(position));
                    Log.i("log intent: ", categories.get(0).getName());
                }
                //startActivity(intent);
            }
        });

        return rootView;

    }
    }

