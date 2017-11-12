package com.example.ahsan.hciproject.Adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ahsan.hciproject.Fragment.BreakfastMenu;
import com.example.ahsan.hciproject.Fragment.RegularMenu;


public class SectionPagerAdapter extends FragmentPagerAdapter {

    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new RegularMenu();
            case 1:
                return new BreakfastMenu();
        }
        return null;
    }

    @Override public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Regular Menu";
            case 1:
                return "BreakFast Meny";
        }
        return null;
    }
}