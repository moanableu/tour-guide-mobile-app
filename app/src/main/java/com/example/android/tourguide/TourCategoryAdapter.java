package com.example.android.tourguide;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TourCategoryAdapter extends RecyclerView.Adapter<TourCategoryAdapter.TourCategoryViewHolder> {
    private ArrayList<TourCategory> mTourCategory;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class TourCategoryViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImage;
        public TextView mName, mDescription;

        public TourCategoryViewHolder(final View itemView, final OnItemClickListener listener) {
            super(itemView);

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
                        }
                    }
                }
            });
    }}

        public TourCategoryAdapter(ArrayList<TourCategory> categories){
            mTourCategory = categories;
        }

    @NonNull
    @Override
    public TourCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_main,parent,false);
        TourCategoryViewHolder cvh = new TourCategoryViewHolder(view, mListener);
        return cvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TourCategoryViewHolder holder, int position) {
        TourCategory currentItem = mTourCategory.get(position);

        holder.mImage.setImageResource(currentItem.getImage());
        holder.mName.setText(currentItem.getName());
        holder.mDescription.setText(currentItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return mTourCategory.size();
    }
}
