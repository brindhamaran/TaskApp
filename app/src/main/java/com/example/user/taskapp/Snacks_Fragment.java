package com.example.user.taskapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Snacks_Fragment extends Fragment {

    ViewPager viewPager;
    int images[];

    {
        images = new int[]{R.drawable.combo_31, R.drawable.combo_32, R.drawable.combo_34};
    }
    SnacksPagerAdapter snacksPagerAdapter;

    public Snacks_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.snacks_layout, container, false);
        viewPager = (ViewPager)view.findViewById(R.id.viewPager);
        snacksPagerAdapter = new SnacksPagerAdapter(this.getActivity(), images);
        viewPager.setAdapter(snacksPagerAdapter);
        return view;
    }
}
