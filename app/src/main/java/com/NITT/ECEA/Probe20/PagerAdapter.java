package com.NITT.ECEA.Probe20;

import com.NITT.ECEA.Probe20.schedule.Day1;
import com.NITT.ECEA.Probe20.schedule.Day2;
import com.NITT.ECEA.Probe20.schedule.Online;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


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
                Day1 day0 = new Day1();
                return day0;
            case 1:
                Day2 day1 = new Day2();
                return day1;
            case 2:
                Online day2 = new Online();
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
