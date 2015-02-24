package com.example.benet.restaurant4app.Test;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.widget.ViewUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.benet.restaurant4app.Fragments.ListFragment;
import com.example.benet.restaurant4app.Fragments.WebFragment;
import com.example.benet.restaurant4app.Model.Restaurant;
import com.example.benet.restaurant4app.R;
import com.example.benet.restaurant4app.Utils.Constants;
import com.example.benet.restaurant4app.Utils.Util;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements ListFragment.OnFragmentInteractionListener {

    private ArrayList<Restaurant> data;
    private ListFragment listFragment;
    private WebFragment webFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Bundle arg;
    private Boolean mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        
        if(findViewById(R.id.container_mobile)!=null){
            this.mobile=true;
            this.fragmentTransaction.add(R.id.container_mobile, this.listFragment);

        }else{

            this.fragmentTransaction.add(R.id.tablet_list, this.listFragment);
            arg.putString(Constants.SEND_URL,data.get(0).getUrl());
            this.webFragment.setArguments(arg);
            this.fragmentTransaction.add(R.id.tablet_web,this.webFragment);
        }

            this.fragmentTransaction.commit();
    }

    private void initComponents(){
        this.mobile=false;
        this.arg=new Bundle();
        this.data= Util.getListRestaurants(this);
        this.listFragment=new ListFragment();
        this.webFragment=new WebFragment();
        this.fragmentManager=getFragmentManager();
        this.fragmentTransaction=fragmentManager.beginTransaction();
        arg.putSerializable(Constants.SEND_DATA_TO_LIST, data);
        listFragment.setArguments(arg);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(int pos) {

        this.fragmentTransaction=this.fragmentManager.beginTransaction();
        this.fragmentTransaction.addToBackStack(null);
        arg.putSerializable(Constants.SEND_URL, data.get(pos).getUrl());
        //this.webFragment.setArguments(arg);
        this.webFragment=new WebFragment();
        this.webFragment.setArguments(arg);
        if(mobile){

            this.fragmentTransaction.replace(R.id.container_mobile, this.webFragment);

        }else{

            this.fragmentTransaction.replace(R.id.tablet_web, this.webFragment);
        }
        this.fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {

        if(getFragmentManager().getBackStackEntryCount()>0){
            getFragmentManager().popBackStack();
        }else{
            super.onBackPressed();
        }
    }
}
