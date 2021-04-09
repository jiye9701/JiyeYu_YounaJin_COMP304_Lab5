package com.example.jiyeyu_younajin_comp304_lab5;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyDao {
    //restaurants

    @Insert
    void addRestaurant(Restaurant restaurant);

    @Query("select * from restaurants")
    public List<Restaurant> getAllRestaurants();

    @Query("select distinct cuisine from restaurants")
    public List<String> getCuisines();

    @Query("select distinct flag_img from restaurants")
    public List<Integer> getFlagImgs();

    @Query("select * from restaurants where cuisine = :cuisine")
    public List<Restaurant> getRestaurantsByCuisine(String cuisine);

    @Query("select * from restaurants where restaurant_id = :id")
    public Restaurant getRestaurantsById(int id);

    @Insert
    void addCuisine(Cuisine cuisine);

    @Query("select * from cuisines")
    public List<Cuisine> getAllCuisines();
}
