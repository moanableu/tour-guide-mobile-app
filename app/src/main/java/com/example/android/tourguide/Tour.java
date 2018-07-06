package com.example.android.tourguide;

public class Tour {
    private int mImage;
    private String mName;
    private String mDescription;

    public Tour(int image, String name, String description){
        mImage = image;
        mName = name;
        mDescription = description;
    }

    public int getImage() {
        return mImage;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }
}
