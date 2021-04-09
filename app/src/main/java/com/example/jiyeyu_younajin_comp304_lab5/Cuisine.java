package com.example.jiyeyu_younajin_comp304_lab5;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cuisines")
public class Cuisine {
    private static int idCounter = 1;

    @PrimaryKey
    @ColumnInfo(name = "cuisine_id")
    @NonNull
    private int cuisineId;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "flag_img")
    private int flagImg;

    public Cuisine(@NonNull String name, int flagImg) {
        this.cuisineId = idCounter++;
        this.name = name;
        this.flagImg = flagImg;
    }
    public Cuisine(){
        this.cuisineId = idCounter++;
        //Empty constructor
    }

    public int getCuisineId() {
        return cuisineId;
    }

    public void setCuisineId(int cuisineId) {
        this.cuisineId = cuisineId;
    }

    public String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
    }

    public int getFlagImg() {
        return flagImg;
    }

    public void setFlagImg(int flagImg) {
        this.flagImg = flagImg;
    }
}