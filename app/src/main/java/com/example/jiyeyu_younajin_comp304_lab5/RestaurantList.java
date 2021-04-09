package com.example.jiyeyu_younajin_comp304_lab5;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RestaurantList extends ArrayAdapter{
    private Restaurant[] restaurants;
    private Activity context;

    public RestaurantList(Activity context, String[] names, Restaurant[] restaurantList){
        super(context, R.layout.cuisine_item, names);
//            public myTestsListAdapter(Activity context, String[] names, Test[] testList){
//            super(context, R.layout.test_row, names);
        this.context = context;
        this.restaurants = restaurantList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View item = convertView;

        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView == null){
            item = inflater.inflate(R.layout.restaurant_item, null, true);
        }
        TextView txtRestaurant = (TextView)item.findViewById(R.id.txt_restaurant);
        ImageView imgRestaurant = (ImageView)item.findViewById(R.id.img_restaurant);
        Restaurant restaurant = restaurants[position];
        txtRestaurant.setText(restaurant.getName());
        imgRestaurant.setImageResource(restaurant.getFlagImg());

        return item;
    }
}
