package com.example.user.taskapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Drinks_Fragment extends Fragment {

    ViewPager viewPager;
    int images[];
    {
        images = new int[]{R.drawable.combo_3, R.drawable.combo_2, R.drawable.combo_3};
    }
    DrinksPagerAdapter drinksPagerAdapter;

    public Drinks_Fragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.drinks_layout, container, false);
        viewPager = (ViewPager)view.findViewById(R.id.viewPager);
        drinksPagerAdapter = new DrinksPagerAdapter(this.getActivity(), images);
        viewPager.setAdapter(drinksPagerAdapter);
        return view;
    }
}
