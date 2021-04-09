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

    public Restaurant(String name, String cuisine, String address, int flagImg, int restaurantImg
                        , double latitude, double longitude)
    {
        this.restaurantId = idCounter++;
        this.name = name;
        this.cuisine = cuisine;
        this.address = address;
        this.flagImg = flagImg;
        this.restaurantImg = restaurantImg;
        this.latitude = latitude;
        this.longitude = longitude;
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
}
