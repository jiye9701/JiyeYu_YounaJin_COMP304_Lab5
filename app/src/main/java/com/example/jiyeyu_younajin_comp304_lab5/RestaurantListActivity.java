package com.example.jiyeyu_younajin_comp304_lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class RestaurantListActivity extends AppCompatActivity {
    TextView cuisineTitle;
    ListView lst_restaurant;
    RestaurantList restaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        try {
            cuisineTitle = (TextView) findViewById(R.id.txt_cuisine_title);
            cuisineTitle.setText(MainActivity.selectedCuisine.getName()  + " Restaurants");

            List<Restaurant> list = MainActivity.myAppDB.myDao().getRestaurantsByCuisine(MainActivity.selectedCuisine.getName());
            Restaurant[] restaurants = new Restaurant[list.size()];
            String[] names = new String[list.size()];
            int index = 0;
            for (Restaurant res : list)
            {
                names[index] = res.getName();
            }
            list.toArray(restaurants);

            lst_restaurant = (ListView) findViewById(R.id.lst_restaurant);
            restaurantList = new RestaurantList(RestaurantListActivity.this, names, restaurants);
            lst_restaurant.setAdapter(restaurantList);
            lst_restaurant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    MainActivity.selectedRestaurantId = restaurants[position].getRestaurantId();
                    Toast.makeText(getApplicationContext(), Integer.toString(MainActivity.selectedRestaurantId), Toast.LENGTH_LONG).show();
                    startActivity(new Intent(view.getContext(), LocationActivity.class));
                }
            });
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}