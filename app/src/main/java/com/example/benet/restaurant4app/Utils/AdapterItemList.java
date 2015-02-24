package com.example.benet.restaurant4app.Utils;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.benet.restaurant4app.Model.Restaurant;
import com.example.benet.restaurant4app.R;

import java.util.ArrayList;

/**
 * Created by Benet on 23/02/15.
 */
public class AdapterItemList extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private ArrayList<Restaurant> data;
    private int item_layout;
    private Activity context;

    public AdapterItemList(Activity context, ArrayList<Restaurant> data, int item_layout) {

        this.context=context;
        this.data=data;
        this.item_layout=item_layout;

        this.layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView=this.layoutInflater.inflate(item_layout,parent,false);
        }
        TextView title=(TextView)convertView.findViewById(R.id.item_title);
        TextView city=(TextView)convertView.findViewById(R.id.item_city);
        TextView district=(TextView)convertView.findViewById(R.id.item_district);
        ImageView img=(ImageView)convertView.findViewById(R.id.item_img);

        title.setText(data.get(position).getName());
        city.setText(data.get(position).getCity());
        district.setText(data.get(position).getDistrict());
        img.setImageResource(data.get(position).getImg());

        return convertView;
    }
}
