package com.example.ahsan.hciproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button swipeLayout, pileLayout, viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        swipeLayout = findViewById(R.id.swipeLayout);
        pileLayout = findViewById(R.id.pileLayout);
        viewFlipper = findViewById(R.id.viewFlipper);

        swipeLayout.setOnClickListener(this);
        pileLayout.setOnClickListener(this);
        viewFlipper.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id){
            case R.id.swipeLayout:
                Intent bannerSliderActivity = new Intent(this,BannerSliderActivity.class);
                startActivity(bannerSliderActivity);
                break;
            case R.id.pileLayout:
                Intent pileActivity = new Intent(this, PileLayoutActivity.class);
                startActivity(pileActivity);
                break;
            case R.id.viewFlipper:
                Intent viewFilpperActivity = new Intent(this, MainActivity.class);
                startActivity(viewFilpperActivity);
                break;
        }
    }
}
