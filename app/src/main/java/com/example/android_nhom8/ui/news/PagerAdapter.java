package com.example.android_nhom8.ui.news;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.android_nhom8.ui.news.FragmentClass.EntertainmentFragment;
import com.example.android_nhom8.ui.news.FragmentClass.GeneralFragment;
import com.example.android_nhom8.ui.news.FragmentClass.HealthFragment;
import com.example.android_nhom8.ui.news.FragmentClass.HomeFragment;
import com.example.android_nhom8.ui.news.FragmentClass.BusinessFragment;
import com.example.android_nhom8.ui.news.FragmentClass.ScienceFragment;
import com.example.android_nhom8.ui.news.FragmentClass.SportFragment;
import com.example.android_nhom8.ui.news.FragmentClass.TechnologyFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    int tabCount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new BusinessFragment();
            case 2:
                return new EntertainmentFragment();
            case 3:
                return new GeneralFragment();
            case 4:
                return new HealthFragment();
            case 5:
                return new ScienceFragment();
            case 6:
                return new SportFragment();
            case 7:
                return new TechnologyFragment();

            default:
                return  null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
