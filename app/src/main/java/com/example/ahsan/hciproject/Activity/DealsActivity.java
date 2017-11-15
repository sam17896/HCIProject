package com.example.ahsan.hciproject.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ahsan.hciproject.Adapter.SectionPagerAdapter;
import com.example.ahsan.hciproject.Fragment.Beverages;
import com.example.ahsan.hciproject.Fragment.BreakfastMenu;
import com.example.ahsan.hciproject.Fragment.CrispyChicken;
import com.example.ahsan.hciproject.Fragment.Deals;
import com.example.ahsan.hciproject.Fragment.Desserts;
import com.example.ahsan.hciproject.Fragment.HappyMeals;
import com.example.ahsan.hciproject.Fragment.RegularMenu;
import com.example.ahsan.hciproject.Fragment.ShareBox;
import com.example.ahsan.hciproject.Fragment.SideLines;
import com.example.ahsan.hciproject.Fragment.ValueMeals;
import com.example.ahsan.hciproject.Fragment.WhatNew;
import com.example.ahsan.hciproject.R;
import com.example.ahsan.hciproject.util.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class DealsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals);
      //  setupBottomNavigationView();
        setUpViewPager();

    }


    private void setUpViewPager(){
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Deals());
        adapter.addFragment(new WhatNew());
        adapter.addFragment(new ValueMeals());
        adapter.addFragment(new CrispyChicken());
        adapter.addFragment(new ShareBox());
        adapter.addFragment(new HappyMeals());
        adapter.addFragment(new Desserts());
        adapter.addFragment(new Beverages());
        adapter.addFragment(new SideLines());
       
        ViewPager viewPager = findViewById(R.id.container);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout =  findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("DEALS");
        tabLayout.getTabAt(1).setText("WHAT'S NEW");
        tabLayout.getTabAt(2).setText("VALUE MEALS");
        tabLayout.getTabAt(3).setText("CRISPY CHICKEN");
        tabLayout.getTabAt(4).setText("SHARE BOX");
        tabLayout.getTabAt(5).setText("HAPPY MEALS");
        tabLayout.getTabAt(6).setText("DESSERTS");
        tabLayout.getTabAt(7).setText("BEVERAGES");
        tabLayout.getTabAt(8).setText("SIDE LINES");

    }

}
