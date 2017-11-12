package com.example.ahsan.hciproject.Fragment;

/**
 * Created by AHSAN on 11/12/2017.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ahsan.hciproject.R;

/**
 * Created by AHSAN on 10/25/2017.
 */

public class BreakfastMenu extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_breakfast_menu, container, false);
        return view;
    }

}