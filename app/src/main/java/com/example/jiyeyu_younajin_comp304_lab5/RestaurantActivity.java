package com.example.jiyeyu_younajin_comp304_lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class RestaurantActivity extends AppCompatActivity {

    ListView listView;
    String[] arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);


        arr = getResources().getStringArray(R.array.starr);

        //Bridge
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.list, arr);

        listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);



        //Intent intent = new Intent(getActivity(), MainActivity.class);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = listView.getItemAtPosition(i).toString();
                if (item.equals("Italian"))
                    startActivity(new Intent(getApplicationContext(),
                            MapsActivity.class));

                else if (item.equals("Greek"))
                    startActivity(new Intent(getApplicationContext(),
                            MapsActivity.class));

                else if (item.equals("Chinese"))
                    startActivity(new Intent(getApplicationContext(),
                            MapsActivity.class));

                else if (item.equals("Indian"))

                    startActivity(new Intent(getApplicationContext(),
                            MapsActivity.class));
            }
        });

    }

}