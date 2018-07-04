package com.happycoderz.espa.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class News implements Serializable{

    @SerializedName("id")
    String id;

    @SerializedName("title")
    String title;

    @SerializedName("date")
    String date = "23 Aralık 2017";

    @SerializedName("content")
    public NewsContent content;

    public class NewsContent implements  Serializable {
        @SerializedName("tr")
        public String tr;

        public NewsContent(String tr) {
            this.tr = tr;
        }

        public NewsContent() {
        }

        public String getTr() {
            return tr;
        }

        public void setTr(String tr) {
            this.tr = tr;
        }
    }

    @SerializedName("image")
    String image;

    public News(String id, String title, NewsContent content, String image) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
    }

    public News() {
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

    public NewsContent getContent() {
        return content;
    }

    public void setContent(NewsContent content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
