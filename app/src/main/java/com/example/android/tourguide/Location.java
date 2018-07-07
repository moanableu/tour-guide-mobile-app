package com.example.android.tourguide;

import android.os.Parcel;
import android.os.Parcelable;

public class Location implements Parcelable {

    private String mName;
    private int mName1;
    private String mDescription;
    private int mDescription1;
    private String mWebsite;
    private String mSchedule;
    private String mAddress;
    private int mImage = NO_IMAGE;
    private String mEntryFee;
    private static final int NO_IMAGE = -1;

    public Location (int image, int name, int description){
        mImage = image;
        mName1 = name;
        mDescription1 = description;
    }

    public Location (String name, String description, String website, String schedule, String address){
        mName = name;
        mDescription = description;
        mWebsite = website;
        mSchedule = schedule;
        mAddress = address;
    }

    public Location(String name, String description, String website, String schedule, String address, int image){
        mName = name;
        mDescription = description;
        mWebsite = website;
        mSchedule = schedule;
        mAddress = address;
        mImage = image;
    }

    public Location(int image, String name, String description, String website, String schedule, String address, String entryFee){
        mImage = image;
        mName = name;
        mDescription = description;
        mWebsite = website;
        mSchedule = schedule;
        mAddress = address;
        mEntryFee = entryFee;
    }

    protected Location(Parcel in) {
        mName = in.readString();
        mDescription = in.readString();
        mWebsite = in.readString();
        mSchedule = in.readString();
        mAddress = in.readString();
        mImage = in.readInt();
        mEntryFee = in.readString();
    }

    public static final Creator <Location> CREATOR = new Creator <Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mDescription);
        dest.writeString(mWebsite);
        dest.writeString(mSchedule);
        dest.writeString(mAddress);
        dest.writeInt(mImage);
        dest.writeString(mEntryFee);
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getSchedule() {
        return mSchedule;
    }

    public String getAddress() {
        return mAddress;
    }

    public int getImage() {
        return mImage;
    }

    public String getEntryFee() {
        return mEntryFee;
    }

    public boolean hasImage(){
        return mImage != NO_IMAGE;
    }

    @Override
    public String toString() {
        return "Location{" +
                "mName: " + mName
                + "mDescription: " + mDescription
                + "mWebsite: " + mWebsite
                + "mSchedule: " + mSchedule
                + "mAddress: " + mAddress
                + "mImage: " + mImage
                + "mEntryFee: " + mEntryFee + "}";
    }
}
