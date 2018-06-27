package com.happycoderz.espa.model;


public class Photo {

     String imageUrl;

    public Photo(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Photo() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
