package com.example.android.tourguide;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Location implements Parcelable {

    private ArrayList <Location> locations;
    private int mName;
    private int mWebsite;
    private int mAddress;

    private int mImage = NO_IMAGE;
    private int mSchedule = NO_SCHEDULE;
    private int mDescription = NO_DESCRIPTION;
    private int mEntryFee = NO_FEE;

    private static final int NO_IMAGE = -1;
    private static final int NO_SCHEDULE = -1;
    private static final int NO_DESCRIPTION = -1;
    private static final int NO_FEE = -1;

    //int image, int name, int website, int address, int schedule
    //int image, int name, int website, int address
    //int image, int name, int description, int website, int address, int schedule, int fee

    public Location(int image, int name, int website, int address, int schedule) {
        mImage = image;
        mName = name;
        mWebsite = website;
        mAddress = address;
        mSchedule = schedule;
    }

    public Location(int image, int name, int website, int address) {
        mImage = image;
        mName = name;
        mWebsite = website;
        mAddress = address;
    }

    public Location(int image, int name, int description, int website, int address, int schedule, int fee) {
        mImage = image;
        mName = name;
        mDescription = description;
        mWebsite = website;
        mAddress = address;
        mSchedule = schedule;
        mEntryFee = fee;
    }

    //int image, int name, int description, int website, int address, int schedule, int fee


    protected Location(Parcel in) {
        locations = in.createTypedArrayList(Location.CREATOR);
        mName = in.readInt();
        mWebsite = in.readInt();
        mAddress = in.readInt();
        mImage = in.readInt();
        mSchedule = in.readInt();
        mDescription = in.readInt();
        mEntryFee = in.readInt();
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeTypedList(locations);
        dest.writeInt(mName);
        dest.writeInt(mWebsite);
        dest.writeInt(mAddress);
        dest.writeInt(mImage);
        dest.writeInt(mSchedule);
        dest.writeInt(mDescription);
        dest.writeInt(mEntryFee);
    }


    public int getName() {
        return mName;
    }

    public int getWebsite() {
        return mWebsite;
    }

    public int getAddress() {
        return mAddress;
    }

    public int getImage() {
        return mImage;
    }

    public int getSchedule() {
        return mSchedule;
    }

    public int getDescription() {
        return mDescription;
    }

    public int getEntryFee() {
        return mEntryFee;
    }

    /**
     * set booleans for information that is not available
     * @return
     */



    public boolean hasImage() {
        return mImage != NO_IMAGE;
    }

    public boolean hasSchedule(){
        return mSchedule != NO_SCHEDULE;
    }

    public boolean hasDescription(){
        return mDescription != NO_DESCRIPTION;
    }

    public boolean hasFee(){
        return mEntryFee != NO_FEE;
    }

}
