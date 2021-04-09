package com.example.jiyeyu_younajin_comp304_lab5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static MyAppDB myAppDB;
    public static Cuisine selectedCuisine;
    public static int selectedRestaurantId;
    ListView lst_cuisine;
    Cuisine[] cuisines;
    CuisineList cuisineList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myAppDB = Room.databaseBuilder(getApplicationContext(), MyAppDB.class, "myDB").allowMainThreadQueries().build();
        initializeDB();

        List<Cuisine> list = MainActivity.myAppDB.myDao().getAllCuisines();
        cuisines = new Cuisine[list.size()];
        list.toArray(cuisines);
        String[] names = new String[list.size()];
        for(int i = 0;  i < list.size(); i++)
        {
            names[i] = cuisines[i].getName();
        }

        lst_cuisine = (ListView)findViewById(R.id.lst_cuisine);
        cuisineList = new CuisineList(MainActivity.this, names, cuisines);
        lst_cuisine.setAdapter(cuisineList);
        lst_cuisine.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedCuisine = cuisines[position];
                Toast.makeText(getApplicationContext(), selectedCuisine.getName(), Toast.LENGTH_LONG).show();
                startActivity(new Intent(view.getContext(), RestaurantListActivity.class));
            }
        });
    }


    public void initializeDB() {
        if (MainActivity.myAppDB.myDao().getAllRestaurants().isEmpty()) {
            try {
                Restaurant[] restaurants = new Restaurant[5];
                restaurants[0] = new Restaurant("Onnki Donburi", "Korean", "40 Hayden St", R.drawable.korea, R.drawable.korea, 43.669971, -79.384590);
                restaurants[1] = new Restaurant("Nomé Izakaya", "Japanese", "4848 Young St", R.drawable.japan, R.drawable.japan, 36.204823, 138.252930);
                restaurants[2] = new Restaurant("B", "Italian", "40 Hayden St3", R.drawable.italy, R.drawable.italy, 41.871941, 12.567380);
                restaurants[3] = new Restaurant("C", "Chinese", "40 Hayden St4", R.drawable.china, R.drawable.china, 45.36694434346996, 137.29509282253906);
                restaurants[4] = new Restaurant("D", "French", "40 Hayden St5", R.drawable.france, R.drawable.france, 33.39828969425322, 126.5866119652072);

                for (int i = 0; i < restaurants.length; i++) {
                    MainActivity.myAppDB.myDao().addRestaurant(restaurants[i]);
                }
            } catch (Exception e) {
                //Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        initializeCuisines();
    }
    public void initializeCuisines(){
        if (MainActivity.myAppDB.myDao().getAllCuisines().isEmpty())
        {
            try{
                List<String> names = MainActivity.myAppDB.myDao().getCuisines();
                List<Integer> flags = MainActivity.myAppDB.myDao().getFlagImgs();
                Cuisine[] cuisines = new Cuisine[names.size()];

                for(int i = 0; i < cuisines.length; i++)
                {
                    Cuisine cuisine = new Cuisine(names.get(i), flags.get(i));
                    MainActivity.myAppDB.myDao().addCuisine(cuisine);
                }
            }catch (Exception e)
            {
                //Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
    }
}