package com.example.android.tourguide;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {
    private ArrayList<Location> mLocation;

    public static class LocationViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImage;
        public TextView mName, mDescription;

        public LocationViewHolder(View itemView) {
            super(itemView);

           /* views pending implementations
            private String mWebsite;
            private String mSchedule;
            private String mAddress;
            private String mEntryFee;*/

            mImage = itemView.findViewById(R.id.image);
            mName = itemView.findViewById(R.id.name);
            mDescription = itemView.findViewById(R.id.description);
        }
    }

    public LocationAdapter(ArrayList<Location> locations){
        mLocation = locations;
    }


    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rb_cardview,parent,false);
        LocationViewHolder lvh = new LocationViewHolder(view);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        Location currentItem = mLocation.get(position);

        holder.mImage.setImageResource(currentItem.getImage());
        holder.mName.setText(currentItem.getName());
        holder.mDescription.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return mLocation.size();
    }
}
