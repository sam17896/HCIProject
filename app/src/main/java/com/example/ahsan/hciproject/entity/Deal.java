package com.example.ahsan.hciproject.entity;

import org.json.JSONObject;

/**
 * Created by xmuSistone on 2017/5/12.
 */

public class Deal {

    private String name;
    private String imageUrl;

    public Deal(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
