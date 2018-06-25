package com.happycoderz.espa.model;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("id")
    String id;

    @SerializedName("title")
    String title;

    @SerializedName("code")
    String code;

    @SerializedName("image")
    String image;

    public Product(String id, String title, String code, String image) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.image = image;
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
}