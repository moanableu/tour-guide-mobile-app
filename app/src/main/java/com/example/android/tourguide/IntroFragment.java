package com.example.android.tourguide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class IntroFragment extends Fragment {
    private ArrayList<Location> mLocation;

    private RecyclerView mRecyclerView;
    private LocationAdapter mAdapter; // limits displayed data  for improved performance
    private RecyclerView.LayoutManager mLayoutManager; //aligns items

    public IntroFragment(){
        // required emtpy constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_main,container,false);


        final ArrayList<Tour> tours = new ArrayList <Tour>();
        tours.add(new Tour(R.drawable.seightseeing, (R.string.museums_kust), (R.string.kunst_intro)));
        tours.add(new Tour(R.drawable.seightseeing, (R.string.seightseeing), (R.string.seigtseeing_intro)));
        tours.add(new Tour(R.drawable.seightseeing, (R.string.food_drinks), (R.string.food_intro)));
        tours.add(new Tour(R.drawable.seightseeing, (R.string.berlinale),(R.string.berlinale_intro)));
        // add onItemClickListener

        // add adapter

        return rootView;

    }
}
