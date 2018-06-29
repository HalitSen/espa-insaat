package com.happycoderz.espa.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Category implements Serializable{

    @SerializedName("id")
    String id;

    @SerializedName("title")
    String title;

    @SerializedName("products")
    public ArrayList<Product> products;

    @SerializedName("sub_categories")
    public ArrayList<SubCategory> subCategories;

    public Category(String id, String title, ArrayList<Product> products, ArrayList<SubCategory> subCategories) {
        this.id = id;
        this.title = title;
        this.products = products;
        this.subCategories = subCategories;
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

    public ArrayList<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(ArrayList<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }
}


