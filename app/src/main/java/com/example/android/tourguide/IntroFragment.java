package com.example.android.tourguide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class IntroFragment extends Fragment {
    TourAdapter adapter;

    public IntroFragment(){
        // required emtpy constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tour_list,container,false);

        final ArrayList<Tour> tours = new ArrayList <Tour>();
        tours.add(new Tour(R.drawable.bikini_berlin_mademoiselle_maurice_, (R.string.museums_kust), (R.string.kunst_intro)));
        tours.add(new Tour(R.drawable.sanssouci_, (R.string.seightseeing), (R.string.seigtseeing_intro)));
        tours.add(new Tour(R.drawable.vox_, (R.string.food_drinks), (R.string.food_intro)));
        tours.add(new Tour(R.drawable.kino_arsenal_, (R.string.berlinale),(R.string.berlinale_intro)));

        adapter = new TourAdapter(getActivity(),tours);
        ListView lv = rootView.findViewById(R.id.intro_list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                Tour tour = tours.get(position);

                switch (position){
                    case 0:
                        getFragmentManager().beginTransaction().replace(R.id.f_container, new MuseumArtFragment()).commit();
                        break;
                    case 1:
                        getFragmentManager().beginTransaction().replace(R.id.f_container, new SeightseeingFragment()).commit();
                        break;
                    case 2:
                        getFragmentManager().beginTransaction().replace(R.id.f_container, new FoodDrinkFragment()).commit();
                        break;
                    case 3:
                        getFragmentManager().beginTransaction().replace(R.id.f_container, new BerlinaleFragment()).commit();
                        break;
                }
            }
        });
        return rootView;
    }
}
