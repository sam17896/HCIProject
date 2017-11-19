package com.example.ahsan.hciproject.Fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ahsan.hciproject.Adapter.SectionPagerAdapter;
import com.example.ahsan.hciproject.R;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ahsan.hciproject.Adapter.SectionPagerAdapter;
import com.example.ahsan.hciproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Auth extends Fragment {


    public Auth() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.activity_manu, container, false);
        setUpViewPager(view);
        return view;
    }


    private void setUpViewPager(View view){
        SectionPagerAdapter adapter = new SectionPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new Login());
        adapter.addFragment(new Register());

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.container);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("Login");
        tabLayout.getTabAt(1).setText("Register");
    }


}
