package com.example.ahsan.hciproject.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by AHSAN on 11/13/2017.
 */

public class Preference {

    private static final String PREF_NAME = "mypreference";
    private static final String CURR_NAVIGATION = "current_navigation";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    public Preference(Context context){
        preferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void setCurrNavigation(String s){
        editor.putString(CURR_NAVIGATION, s);
        editor.commit();
    }

    public String getCurrNavigation(){
        return preferences.getString(CURR_NAVIGATION, "Home");
    }


}
