package com.example.android.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TourAdapter extends ArrayAdapter {
    TextView name, description;
    ImageView image;

    public TourAdapter(@NonNull Context context, @NonNull ArrayList <Tour> tours) {
        super(context, 0, tours);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View introView = convertView;
        if(introView == null){
            introView = LayoutInflater.from(getContext()).inflate(R.layout.content_main,parent,false);
        }

        Tour currentTour = (Tour) getItem(position);
        name = introView.findViewById(R.id.tour_name);
        name.setText(currentTour.getName());

        description = introView.findViewById(R.id.tour_description);
        description.setText(currentTour.getDescription());

        image = introView.findViewById(R.id.tour_image);
        image.setImageResource(currentTour.getImage());

        return introView;
    }
}
