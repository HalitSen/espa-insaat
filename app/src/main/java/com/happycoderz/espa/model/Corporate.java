package com.happycoderz.espa.model;


import com.google.gson.annotations.SerializedName;

public class Corporate {

    @SerializedName("id")
    String id;

    @SerializedName("title")
    String title;

    @SerializedName("content")
    public CorporateContent content;

    public class CorporateContent {
        @SerializedName("tr")
        public String tr;

        public CorporateContent(String tr) {
            this.tr = tr;
        }

        public CorporateContent() {
        }

        public String getTr() {
            return tr;
        }

        public void setTr(String tr) {
            this.tr = tr;
        }
    }

    public Corporate(String id, String title, CorporateContent content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Corporate() {
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

    public CorporateContent getContent() {
        return content;
    }

    public void setContent(CorporateContent content) {
        this.content = content;
    }
}
