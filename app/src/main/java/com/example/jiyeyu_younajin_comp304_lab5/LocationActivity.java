package com.example.jiyeyu_younajin_comp304_lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LocationActivity extends AppCompatActivity {
    Restaurant restaurant = MainActivity.myAppDB.myDao().getRestaurantsById(MainActivity.selectedRestaurantId);
    TextView txtName, txtInfo;
    ImageView imgRestaurant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        txtName = findViewById(R.id.txt_location_name);
        txtInfo = findViewById(R.id.txt_location_address);
        imgRestaurant = findViewById(R.id.img_location_res);

        txtName.setText(restaurant.getName());
        txtInfo.setText(restaurant.getAddress());
        imgRestaurant.setImageResource(restaurant.getRestaurantImg());
    }
}