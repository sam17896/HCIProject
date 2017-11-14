package com.example.ahsan.hciproject.Activity;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ahsan.hciproject.Adapter.SectionPagerAdapter;
import com.example.ahsan.hciproject.Fragment.BreakfastMenu;
import com.example.ahsan.hciproject.Fragment.RegularMenu;
import com.example.ahsan.hciproject.R;
import com.example.ahsan.hciproject.util.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class MenuActivity extends AppCompatActivity {
    private Context mContext = MenuActivity.this;
    private static final int ACTIVITY_NO = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manu);
        setupBottomNavigationView();
        setUpViewPager();
    }


    private void setUpViewPager(){
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new BreakfastMenu());
        adapter.addFragment(new RegularMenu());

        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(1).setText("Regular Menu");
        tabLayout.getTabAt(0).setText("BreakFast Manu");
    }


    private void setupBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottonNavigationBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
      //  BottomNavigationViewHelper.enableNavigation(this, bottomNavigationViewEx);

        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NO);
        menuItem.setChecked(true);

    }
}
