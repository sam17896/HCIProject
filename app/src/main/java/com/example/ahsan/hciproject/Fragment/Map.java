package com.example.ahsan.hciproject.Fragment;

/**
 * Created by AHSAN on 11/18/2017.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ahsan.hciproject.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by AHSAN on 10/25/2017.
 */

public class Map extends Fragment {
    private GoogleMap mMap;
    private MapView mapView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_map, container, false);
        mapView = (MapView) view.findViewById(R.id.fragment_view_map);
        MapsInitializer.initialize(getActivity());
        if(mapView!=null){
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    mMap = googleMap;

                    // Add a marker in Sydney and move the camera
                    LatLng Karachi = new LatLng(24.946218, 67.005615);
                    mMap.addMarker(new MarkerOptions().position(Karachi).title("Karachi"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(Karachi));
                }
            });

        }
        return view;
    }

}