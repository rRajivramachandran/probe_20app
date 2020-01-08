package com.example.rajiv.signupandregister;

import com.example.rajiv.signupandregister.schedule.Day0;
import com.example.rajiv.signupandregister.schedule.Day1;
import com.example.rajiv.signupandregister.schedule.Day2;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class PagerAdapter extends FragmentStatePagerAdapter {

    int noOfTabs;

    public PagerAdapter(FragmentManager fragmentManager,int noOfTabs){
        super(fragmentManager);
        this.noOfTabs = noOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Day0 day0 = new Day0();
                return day0;
            case 1:
                Day1 day1 = new Day1();
                return day1;
            case 2:
                Day2 day2 = new Day2();
                return day2;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
