package com.example.android.tourguide;

import android.os.Parcel;
import android.os.Parcelable;

public class TourCategory implements Parcelable {

    private int mImage;
    private String mName;
    private String mDescription;

    public TourCategory (int image, String name, String description){
        mImage = image;
        mName = name;
        mDescription = description;
    }

    protected TourCategory(Parcel in) {
        mImage = in.readInt();
        mName = in.readString();
        mDescription = in.readString();
    }


    public static final Creator <TourCategory> CREATOR = new Creator <TourCategory>() {
        @Override
        public TourCategory createFromParcel(Parcel in) {
            return new TourCategory(in);
        }

        @Override
        public TourCategory[] newArray(int size) {
            return new TourCategory[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mImage);
        dest.writeString(mName);
        dest.writeString(mDescription);
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

    @Override
    public String toString() {
        return "Categories {" + "mName: " + mName + "mDescription: " + mDescription;
    }
}
