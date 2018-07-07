package com.example.android.tourguide;

public class Tour {
    private int mImage;
    private int mName;
    private String mDescription;

    public Tour(int image, int name, String description){
        mImage = image;
        mName = name;
        mDescription = description;
    }

    public int getImage() {
        return mImage;
    }

    public int getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }
}
