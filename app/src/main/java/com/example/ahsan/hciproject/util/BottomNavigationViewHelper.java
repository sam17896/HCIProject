package com.example.ahsan.hciproject.util;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.ahsan.hciproject.Activity.BannerSliderActivity;
import com.example.ahsan.hciproject.Activity.MenuActivity;
import com.example.ahsan.hciproject.R;
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

}
