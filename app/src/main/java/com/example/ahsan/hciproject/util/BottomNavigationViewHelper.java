package com.example.ahsan.hciproject.util;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.ahsan.hciproject.Activity.BannerSliderActivity;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by Sohail Arshad on 7/25/2017.
 */

public class BottomNavigationViewHelper {


    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx viewEx){
        viewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Preference preference = new Preference(context);
                switch (item.getItemId()) {
                    case R.id.ic_house:
                        if (preference.getCurrNavigation().equals("Home")) {

                        } else {
                            Intent intent1 = new Intent(context, BannerSliderActivity.class);
                            context.startActivity(intent1);
                            preference.setCurrNavigation("Home");
                        }
                        break;
                }

                return false;
            }
        });
    }
}
