package com.happycoderz.espa.model;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class EspaResponse implements Serializable {

    @SerializedName("corporate")
    public ArrayList<Corporate> corporate;

    @SerializedName("contact")
    public ArrayList<Contact> contact;

    @SerializedName("news")
    public ArrayList<News> news;

    @SerializedName("categories")
    public ArrayList<Category> categories;
}
