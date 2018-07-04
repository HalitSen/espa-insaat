package com.happycoderz.espa.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable{

    @SerializedName("id")
    String id;

    @SerializedName("title")
    String title;

    @SerializedName("code")
    String code;

    @SerializedName("image")
    String image;

    private  ArrayList<Product> relatedProducts = new ArrayList<>();

    String description;

    public Product(String id, String title, String code, String image, String description) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.image = image;
        this.description = description;
    }

    public Product() {
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Product> getRelatedProducts() {
        return relatedProducts;
    }

    public void setRelatedProducts(ArrayList<Product> relatedProducts) {
        this.relatedProducts = relatedProducts;
    }
}