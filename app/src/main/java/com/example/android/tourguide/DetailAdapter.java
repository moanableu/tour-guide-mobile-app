package com.example.android.tourguide;

import android.content.Context;
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

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailViewHolder> {
    private ArrayList<Location> mLocation;
    private OnItemClickListener mListener;
    private LayoutInflater layoutInflater;
    private Context mContext;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class DetailViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImage;
        public TextView mName, mDescription, mWebsite, mSchedule, mAddress, mEntryFee;

        public DetailViewHolder(final View itemView, final OnItemClickListener listener) {
            super(itemView);

            mImage = itemView.findViewById(R.id.detail_image);
            mName = itemView.findViewById(R.id.detail_name);
            mDescription = itemView.findViewById(R.id.detail_description);
            mWebsite = itemView.findViewById(R.id.website);
            mSchedule = itemView.findViewById(R.id.hours);
            mAddress = itemView.findViewById(R.id.address);
            mEntryFee = itemView.findViewById(R.id.fees);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(v.getContext(), DetailCard.class);
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION);{
                            listener.onItemClick(position);
                            i.putExtra("passes", position);
                            Log.i("Detail position is ", "No: " + position); // works
                            v.getContext().startActivity(i);
                        }
                    }
                }
            });
        }
    }

    public DetailAdapter(ArrayList <Location> locations){
        this.layoutInflater = LayoutInflater.from(mContext);
        mLocation = locations;
    }


    @NonNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail_card,parent,false);
        DetailViewHolder dvh = new DetailViewHolder(view, mListener);
        return dvh;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailViewHolder holder, int position) {
        Location currentItem = mLocation.get(position);

        holder.mImage.setImageResource(currentItem.getImage());
        holder.mName.setText(currentItem.getName());
        holder.mAddress.setText(currentItem.getAddress());
        holder.mSchedule.setText(currentItem.getSchedule());
        holder.mDescription.setText(currentItem.getDescription());
        holder.mEntryFee.setText(currentItem.getEntryFee());
    }

    @Override
    public int getItemCount() {
        return mLocation.size();
    }
}
