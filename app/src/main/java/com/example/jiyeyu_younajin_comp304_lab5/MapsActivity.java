package com.example.jiyeyu_younajin_comp304_lab5;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Restaurant restaurant = MainActivity.myAppDB.myDao().getRestaurantsById(MainActivity.selectedRestaurantId);
    double latitude, longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        //latitude and longitude for restaurant location
        latitude = restaurant.getLatitude();
        longitude = restaurant.getLongitude();

        
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng restaurant = new LatLng(latitude, longitude);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(restaurant));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(restaurant, 16));

        MarkerOptions marker = new MarkerOptions();
        marker .position(new LatLng(latitude, longitude))
                //임시로 2번기준으로만
                .title("Nomé Izakaya")
                .snippet("4848 Yonge St, North York, ON M2N 5N2");
        googleMap.addMarker(marker).showInfoWindow();


        mMap.moveCamera(CameraUpdateFactory.newLatLng(restaurant));

    }
}