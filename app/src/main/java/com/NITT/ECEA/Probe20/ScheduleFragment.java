package com.NITT.ECEA.Probe20;


import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {

    public TabLayout tabLayout;
    public ViewPager viewPager;
    public PagerAdapter pagerAdapter;
    public FragmentManager fragmentManager;


    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);

        tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Day 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Day 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Online"));
        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);

        fragmentManager = getFragmentManager();
        viewPager = view.findViewById(R.id.view_pager);
        pagerAdapter = new PagerAdapter(fragmentManager,tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }
}
