package com.example.jiyeyu_younajin_comp304_lab5;

import android.app.Activity;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CuisineList extends ArrayAdapter {
    private Cuisine[] cuisineList;
    private Activity context;

    public CuisineList(Activity context, String[] names, Cuisine[] cuisineList){
        super(context, R.layout.cuisine_item, names);
//            public myTestsListAdapter(Activity context, String[] names, Test[] testList){
//            super(context, R.layout.test_row, names);
        this.context = context;
        this.cuisineList = cuisineList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View item = convertView;

        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView == null){
            item = inflater.inflate(R.layout.cuisine_item, null, true);
        }
        TextView txtCuisine = (TextView)item.findViewById(R.id.txt_cuisine);
        ImageView imgFlag = (ImageView)item.findViewById(R.id.img_cuisine_flag);
        txtCuisine.setText(cuisineList[position].getName());
        imgFlag.setImageResource(cuisineList[position].getFlagImg());

        return item;
    }
}
