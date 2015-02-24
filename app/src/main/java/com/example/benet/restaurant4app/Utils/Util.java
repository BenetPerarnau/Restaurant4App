package com.example.benet.restaurant4app.Utils;

import android.app.Activity;

import com.example.benet.restaurant4app.Model.Restaurant;
import com.example.benet.restaurant4app.R;

import java.util.ArrayList;

/**
 * Created by Benet on 23/02/15.
 */
public class Util {

    public static ArrayList<Restaurant> getListRestaurants(Activity context){
        ArrayList<Restaurant> data=new ArrayList<Restaurant>();

        String [] names=context.getResources().getStringArray(R.array.names_restaurant);
        String [] citys=context.getResources().getStringArray(R.array.citys_restaurant);
        String [] districts=context.getResources().getStringArray(R.array.districts_restaurant);
        String [] urls=context.getResources().getStringArray(R.array.url_restaurant);
        String [] imgs=context.getResources().getStringArray(R.array.img_restaurant);
        while(data.size()<10) {
            for (int i = 0; i < names.length; i++) {
                data.add(new Restaurant(names[i], citys[i], districts[i], urls[i],
                        context.getResources().getIdentifier(imgs[i], "mipmap", context.getPackageName())));
            }
        }
        return data;
    }

}
