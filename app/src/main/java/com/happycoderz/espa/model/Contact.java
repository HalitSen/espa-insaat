package com.happycoderz.espa.model;

import com.google.gson.annotations.SerializedName;

public class Contact {

    @SerializedName("title")
    String title;

    @SerializedName("phoneNumber")
    String phoneNumber;

    @SerializedName("address")
    String address;

    @SerializedName("email")
    String email;

    @SerializedName("latitude")
    String latitude;

    @SerializedName("longtitude")
    String longitude;

    public Contact(String title, String phoneNumber, String address, String email, String latitude, String longitude) {
        this.title = title;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Contact() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
