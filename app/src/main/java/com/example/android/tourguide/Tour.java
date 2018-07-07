package com.example.android.tourguide;

public class Tour {
    private int mImage, mName, mDescription;

    public Tour (int image, int name, int description){
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

    public int getDescription() {
        return mDescription;
    }
}
