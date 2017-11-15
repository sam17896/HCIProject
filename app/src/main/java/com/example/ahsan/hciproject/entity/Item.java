package com.example.ahsan.hciproject.entity;

/**
 * Created by AHSAN on 11/15/2017.
 */

public class Item {

    String image_url;
    String name;
    String price;

    public Item(String image_url, String name, String price) {
        this.image_url = image_url;
        this.name = name;
        this.price = price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
