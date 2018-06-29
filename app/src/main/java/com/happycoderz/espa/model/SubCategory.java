package com.happycoderz.espa.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class SubCategory implements Serializable {

    @SerializedName("id")
    String id;

    @SerializedName("title")
    String title;

    @SerializedName("products")
    public ArrayList<Product> product;

    public SubCategory(String id, String title, ArrayList<Product> product) {
        this.id = id;
        this.title = title;
        this.product = product;
    }

    public SubCategory() {
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

    public ArrayList<Product> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Product> product) {
        this.product = product;
    }
}
