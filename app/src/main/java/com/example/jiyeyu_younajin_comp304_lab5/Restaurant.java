package com.example.jiyeyu_younajin_comp304_lab5;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "restaurants")
public class Restaurant {
    private static int idCounter = 1;

    @PrimaryKey
    @ColumnInfo(name = "restaurant_id")
    @NonNull
    private int restaurantId;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "cuisine")
    private String cuisine;
    @ColumnInfo(name = "address")
    private String address;
    @ColumnInfo(name = "flag_img")
    private int flagImg;
    @ColumnInfo(name = "restaurant_img")
    private int restaurantImg;
    @ColumnInfo(name = "latitude")
    private double latitude;
    @ColumnInfo(name = "longitude")
    private double longitude;

    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "snippet")
    private String snippet;

    public Restaurant(String name, String cuisine, String address, int flagImg, int restaurantImg
                        , double latitude, double longitude, String title, String snippet)
    {
        this.restaurantId = idCounter++;
        this.name = name;
        this.cuisine = cuisine;
        this.address = address;
        this.flagImg = flagImg;
        this.restaurantImg = restaurantImg;
        this.latitude = latitude;
        this.longitude = longitude;
        this.title = title;
        this.snippet =snippet;
    }
    public Restaurant()
    {
        this.restaurantId = idCounter++;
    }

    public int getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(int restaurantId)
    {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getFlagImg() { return flagImg; }

    public void setFlagImg(int flagImg) { this.flagImg = flagImg; }

    public int getRestaurantImg() { return restaurantImg; }

    public void setRestaurantImg(int restaurantImg) { this.restaurantImg = restaurantImg; }

    public double getLatitude() { return latitude; }

    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }

    public void setLongitude(double longitude) { this.longitude = longitude; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSnippet() {
        return snippet;
    }

    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }
}
