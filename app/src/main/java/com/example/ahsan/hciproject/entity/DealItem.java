package com.example.ahsan.hciproject.entity;

import java.util.ArrayList;

/**
 * Created by AHSAN on 11/15/2017.
 */

public class DealItem {
    String image_url;
    String name;
    ArrayList<Item> items;
    String price;

    public DealItem(String image_url, String name, ArrayList<Item> items, String price) {
        this.image_url = image_url;
        this.name = name;
        this.items = items;
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

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
