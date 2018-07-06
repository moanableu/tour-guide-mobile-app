package com.example.android.tourguide;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TourAdapter extends ArrayAdapter {
    TextView name, description;
    ImageView image;

    public TourAdapter(Activity context, ArrayList<Tour> tours){
        super(context, 0, tours);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View tView = convertView;
        if (tView == null){
            tView = LayoutInflater.from(getContext()).inflate(R.layout.content_main,parent,false);
        }

        Tour currentTour = (Tour) getItem(position);

        image = (ImageView) tView.findViewById(R.id.tour_image);
        image.setImageResource(R.drawable.seightseeing);

        name = tView.findViewById(R.id.tour_name);
        name.setText(currentTour.getName());

        description = tView.findViewById(R.id.tour_description);
        description.setText(currentTour.getDescription());

        View category_container = tView.findViewById(R.id.category_container);

        return tView;
    }
}
