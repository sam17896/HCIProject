package com.example.ahsan.hciproject.Activity;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.ahsan.hciproject.Fragment.Home;
import com.example.ahsan.hciproject.util.BottomNavigationViewHelper;
import com.example.ahsan.hciproject.util.ChildAnimationExample;
import com.example.ahsan.hciproject.R;
import com.example.ahsan.hciproject.Adapter.TransformerAdapter;
import com.example.ahsan.hciproject.util.UniversalImageLoader;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.HashMap;


public class BannerSliderActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_slider);
        initImageLoader();
        setupBottomNavigationView();
        setTitle("Home");
        Fragment Home =  new Home();
        android.support.v4.app.FragmentTransaction fragmentTransaction =  getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fra, Home,"Home").commit();
    }

    private void setupBottomNavigationView(){
        final BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottonNavigationBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        bottomNavigationViewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_house:
                        setTitle("Home");
                        Fragment Home =  new Home();
                        android.support.v4.app.FragmentTransaction fragmentTransaction =  getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fra, Home,"Home").commit();

                        Menu menu = bottomNavigationViewEx.getMenu();
                        MenuItem menuItem =  menu.getItem(0);
                        menuItem.setChecked(true);
                        return true;
                    case R.id.ic_search:
                        setTitle("Menu");
                        Fragment Menu =  new com.example.ahsan.hciproject.Fragment.Menu();
                        android.support.v4.app.FragmentTransaction fragmentTransaction1 =  getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.fra, Menu,"Menu").commit();

                        Menu menu1 = bottomNavigationViewEx.getMenu();
                        MenuItem menuItem1 =  menu1.getItem(1);
                        menuItem1.setChecked(true);
                        return true;

                }
                return false;
            }
        });
    }

    private void initImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(this);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds cartList to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_cart:
                Intent intent = new Intent(this, CartActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}