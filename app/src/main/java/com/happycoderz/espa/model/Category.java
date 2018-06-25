package com.happycoderz.espa.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Category {

    @SerializedName("id")
    String id;

    @SerializedName("title")
    String title;

    @SerializedName("products")
    public ArrayList<Product> products;

    public Category(String id, String title, ArrayList<Product> products) {
        this.id = id;
        this.title = title;
        this.products = products;
    }

    public Category() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}


