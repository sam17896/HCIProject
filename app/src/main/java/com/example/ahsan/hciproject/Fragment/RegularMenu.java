package com.example.ahsan.hciproject.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


import com.example.ahsan.hciproject.Activity.DealsActivity;
import com.example.ahsan.hciproject.Adapter.GridImageAdapter;
import com.example.ahsan.hciproject.R;
import com.example.ahsan.hciproject.entity.Deal;
import com.example.ahsan.hciproject.util.UniversalImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by AHSAN on 10/25/2017.
 */

public class RegularMenu extends Fragment {

    private static final int NUM_WIDTH_COL = 2;
    private GridView gridView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_reg_menu, container, false);
        gridView = view.findViewById(R.id.gridView);
        initImageLoader();
        tempGridSetup();

        return view;
    }
    private void tempGridSetup(){
        ArrayList<Deal> deals = new ArrayList<>();

        deals.add(new Deal("deal1","https://pbs.twimg.com/profile_images/616076655547682816/6gMRtQyY.jpg"));
        deals.add(new Deal("deal2","https://i.redd.it/9bf67ygj710z.jpg"));
        deals.add(new Deal("deal3","https://c1.staticflickr.com/5/4276/34102458063_7be616b993_o.jpg"));
        deals.add(new Deal("deal4","http://i.imgur.com/EwZRpvQ.jpg"));
        deals.add(new Deal("deal5","http://i.imgur.com/JTb2pXP.jpg"));
        deals.add(new Deal("deal6","https://i.redd.it/59kjlxxf720z.jpg"));
        deals.add(new Deal("deal7","https://i.redd.it/pwduhknig00z.jpg"));
        deals.add(new Deal("deal8","https://i.redd.it/clusqsm4oxzy.jpg"));
        deals.add(new Deal("deal9","https://i.redd.it/svqvn7xs420z.jpg"));
        deals.add(new Deal("deal10","http://i.imgur.com/j4AfH6P.jpg"));
        deals.add(new Deal("deal11","https://i.redd.it/89cjkojkl10z.jpg"));
        deals.add(new Deal("deal12","https://i.redd.it/aw7pv8jq4zzy.jpg"));

        setupImageGrid(deals);

    }

    private void setupImageGrid(ArrayList<Deal> imgURLs){

        int gridWidth = getResources().getDisplayMetrics().widthPixels;
        int imageWidth = gridWidth/NUM_WIDTH_COL;
        gridView.setColumnWidth(imageWidth);

        GridImageAdapter adapter =  new GridImageAdapter(getContext(), R.layout.layout_gridview ,"",imgURLs);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =  new Intent(getActivity(), DealsActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initImageLoader(){
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(getContext());
        ImageLoader.getInstance().init(universalImageLoader.getConfig());
    }
}