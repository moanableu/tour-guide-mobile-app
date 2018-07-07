package com.example.android.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new IntroFragment();
        } else if (position == 1){
            return new MuseumArtActivity();
        } else if (position == 2){
            return new SeightseeingFragment();
        } else if (position == 3){
            return new FoodDrinkFragment();
        } else {
            return new BerlinaleFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
