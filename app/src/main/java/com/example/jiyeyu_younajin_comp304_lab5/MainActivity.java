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
                restaurants[0] = new Restaurant("Onnki Donburi", "Korean", "40 Hayden St", R.drawable.korea, R.drawable.korea, 43.669971, -79.384590,"Onnki Donburi","40 Hayden St, Toronto, ON M4Y 1V8");
                restaurants[1] = new Restaurant("Nomé Izakaya", "Japanese", "4848 Young St", R.drawable.japan, R.drawable.japan, 43.764272195905704, -79.41048152437747,"Nomé Izakaya","4848 Yonge St, North York, ON M2N 5N2");
                restaurants[2] = new Restaurant("Carisma", "Italian", "15 Toronto St", R.drawable.italy, R.drawable.italy, 43.65054791107293, -79.3758827520356,"Carisma","15 Toronto St, Toronto, ON M5C 2E3");
                restaurants[3] = new Restaurant("Swatow Restaurant", "Chinese", "309 Spadina Ave", R.drawable.china, R.drawable.china, 43.65537528580339, -79.39797830372721,"Swatow Restaurant","309 Spadina Ave., Toronto, ON M5T 1H1");
                restaurants[4] = new Restaurant("Le Sélect Bistro", "French", "432 Wellington St W", R.drawable.france, R.drawable.france, 43.645868052678495, -79.39703417463498,"Le Sélect Bistro","432 Wellington St W, Toronto, ON M5V 1E3");

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