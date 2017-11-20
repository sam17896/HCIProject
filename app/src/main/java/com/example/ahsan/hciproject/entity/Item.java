package com.example.ahsan.hciproject.entity;

/**
 * Created by AHSAN on 11/15/2017.
 */

public class Item {

    String image_url;
    String name;
    String price;
    boolean isBottle;

    public boolean isBottle() {
        return isBottle;
    }

    public void setBottle(boolean bottle) {
        isBottle = bottle;
    }

    public Item(String image_url, String name, String price, boolean isBottle) {
        this.image_url = image_url;
        this.name = name;
        this.price = price;
        this.isBottle = isBottle;
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
