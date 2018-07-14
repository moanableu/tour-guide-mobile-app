package com.example.android.tourguide;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {
    private ArrayList<Location> mLocation;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class LocationViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImage;
        public TextView mName, mDescription, mWebsite, mSchedule, mAddress, mEntryFee;

        public LocationViewHolder(final View itemView, final OnItemClickListener listener) {
            super(itemView);

           /* views pending implementations
            private String mWebsite;
            private String mSchedule;
            private String mAddress;
            private String mEntryFee;*/

            mImage = itemView.findViewById(R.id.image);
            mName = itemView.findViewById(R.id.name);
            mDescription = itemView.findViewById(R.id.description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION);{
                            listener.onItemClick(position);
                            Log.i("position is ", "No: " + position); // works
                        }
                    }
                }
            });
        }
    }

    public LocationAdapter(ArrayList<Location> locations){
        mLocation = locations;
    }


    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rb_cardview,parent,false);
        LocationViewHolder lvh = new LocationViewHolder(view, mListener);
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
