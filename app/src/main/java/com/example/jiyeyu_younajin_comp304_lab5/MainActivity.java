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
                //Toast.makeText(getApplicationContext(), selectedCuisine.getName(), Toast.LENGTH_LONG).show();
                startActivity(new Intent(view.getContext(), RestaurantListActivity.class));
            }
        });
    }


    public void initializeDB() {
        if (MainActivity.myAppDB.myDao().getAllRestaurants().isEmpty()) {
            try {
                Restaurant[] restaurants = new Restaurant[25];
                restaurants[0] = new Restaurant("Onnki Donburi", "Korean", "40 Hayden St", R.drawable.korea, R.drawable.onnki_donburi, 43.669971, -79.384590);
                restaurants[1] = new Restaurant("Nomé Izakaya", "Japanese", "4848 Young St", R.drawable.japan, R.drawable.nome_izakaya, 43.76253436457568, -79.41144425015626);
                restaurants[2] = new Restaurant("Carisma", "Italian", "15 Toronto St", R.drawable.italy, R.drawable.carisma, 43.65030897360517, -79.37600894397332);
                restaurants[3] = new Restaurant("Swatow Restaurant", "Chinese", "309 Spadina Ave", R.drawable.china, R.drawable.swatow_restaurant, 43.65384712819282, -79.39811750650269);
                restaurants[4] = new Restaurant("Le Sélect Bistro", "French", "432 Wellington St W", R.drawable.france, R.drawable.le_select_bistro, 43.64382231580537, -79.39681957657822);

                restaurants[5] = new Restaurant("Lee Nam Jang", "Korean", "4846 Yonge St", R.drawable.korea, R.drawable.leenamjang, 43.762497498754534, -79.41143663696859);
                restaurants[6] = new Restaurant("NKINKA IZAKAYA ORIGINAL", "Japanese", "398 Church St", R.drawable.japan, R.drawable.kinka_izakaya_original,43.66041804202121, -79.37889925026549);
                restaurants[7] = new Restaurant("Masseria", "Italian", "577 King St W, Toronto", R.drawable.italy, R.drawable.masseria, 43.64436254128769, -79.39973136410295);
                restaurants[8] = new Restaurant("Hong Shing Chinese Restaurant", "Chinese", "195 Dundas St W", R.drawable.china, R.drawable.hong_shing, 43.65495086568616, -79.38690516358538);
                restaurants[9] = new Restaurant("Café Boulud", "French", "60 Yorkville Ave", R.drawable.france, R.drawable.cafe_boulud, 43.67173397343038, -79.38997825429334);

                restaurants[10] = new Restaurant("Nakwon Korean Restaurant", "Korean", "5594 Yonge St", R.drawable.korea, R.drawable.nak_won_korean_restaurant, 43.779473065894095, -79.41578912773784);
                restaurants[11] = new Restaurant("Don Don Izakaya", "Japanese", "130 Dundas St W", R.drawable.japan, R.drawable.don_don_izakaya, 43.655739526274324, -79.38464612997765);
                restaurants[12] = new Restaurant("Terroni", "Italian", "57 Adelaide St E", R.drawable.italy, R.drawable.terroni, 43.65093525615899, -79.37568568890397);
                restaurants[13] = new Restaurant("House Of Gourmet", "Chinese", "484 Dundas St W", R.drawable.china, R.drawable.house_of_gourmet, 43.65323704041392, -79.39725719450833);
                restaurants[14] = new Restaurant("Midi Bistro Restaurant", "French", "168 McCaul St", R.drawable.france, R.drawable.midi_bistro, 43.65584208757676, -79.39218294780163);

                restaurants[15] = new Restaurant("Huh Ga Ne", "Korean", "19A Finch Ave W", R.drawable.korea, R.drawable.huh_ga_ne, 43.77919713325, -79.41724968803443);
                restaurants[16] = new Restaurant("Yuugi Izakaya", "Japanese", "49 Baldwin St", R.drawable.japan, R.drawable.yuugi_izakaya, 43.6557895322812, -79.39385983622414);
                restaurants[17] = new Restaurant("Figo Toronto", "Italian", "295 Adelaide St W", R.drawable.italy, R.drawable.figo_toronto, 43.64769370032781, -79.39042388155465);
                restaurants[18] = new Restaurant("New Ho King", "Chinese", "410 Spadina Ave", R.drawable.china, R.drawable.new_ho_king, 43.656160760748385, -79.39969546999946);
                restaurants[19] = new Restaurant("Chabrol", "French", "156 Cumberland St", R.drawable.france, R.drawable.chabrol, 43.66997369139091, -79.39331686429372);

                restaurants[20] = new Restaurant("Bobooya", "Korean", "4850 Yonge St", R.drawable.korea, R.drawable.bobooya, 43.76258728577661, -79.41146007391515);
                restaurants[21] = new Restaurant("Rain Izakaya", "Japanese", "35 Sheppard Ave E, North York", R.drawable.japan, R.drawable.rain_izakaya, 43.76170034027086, -79.40920512217576);
                restaurants[22] = new Restaurant("Buca", "Italian", "604 King St W", R.drawable.italy, R.drawable.buca, 43.656696129463505, -79.40119592720612);
                restaurants[23] = new Restaurant("Taste of China Seafood Restaurant", "Chinese", "338 Spadina Ave", R.drawable.china, R.drawable.taste_of_china_seafood_restaurant, 43.654048527056034, -79.39876325431767);
                restaurants[24] = new Restaurant("Sorrel", "French", "1158 Yonge St", R.drawable.france, R.drawable.sorrel, 43.68022125302347, -79.39108488164354);

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