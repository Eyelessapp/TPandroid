package com.eyelessapp.eyelessapp.ActivitesDrawer;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.eyelessapp.eyelessapp.ActivityGps;
import com.eyelessapp.eyelessapp.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class DrawerAccueil extends FragmentActivity implements OnMapReadyCallback
{

    private String[] drawerItemsList;
    private ListView itemDrawer;
    private TextView textViewDrawer;
    private DrawerLayout drawerAccueil;
    private ActionBarDrawerToggle drawerToggle;
    private ActionBar actionBar ;
    private DrawerLayout drawermsg;
    GoogleMap mMap;

    MyDrawerClickListener clickDrawer = new MyDrawerClickListener();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draweraccueil);

        drawerAccueil = (DrawerLayout) findViewById(R.id.drawer_layout);
        //textViewDrawer = (TextView) findViewById(R.id.affichage_drawer_txt);
        drawerItemsList = getResources().getStringArray(R.array.items_drawer);
        actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);


        itemDrawer = (ListView) findViewById(R.id.menu_Coulissant);
        itemDrawer.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_item, drawerItemsList));
        itemDrawer.setOnItemClickListener(clickDrawer);



        drawerToggle = new ActionBarDrawerToggle(this, drawerAccueil,R.string.ouverture, R.string.fermeture){

            public void onDrawerClosed(View view){
                getActionBar().setTitle(getTitle());
                invalidateOptionsMenu();}

            public void onDrawerOpened(View drawerView){
                getActionBar().setTitle((R.string.app_name));
                        invalidateOptionsMenu();
            }
        };


        drawerAccueil.setDrawerListener(drawerToggle);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        }



    private class MyDrawerClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {


            switch (position+1){
             case 1: //accueil
                 break;
             case 2: //profil

                 Intent intentprofil = new Intent(DrawerAccueil.this,DrawerProfil.class);
                 startActivity(intentprofil);
                 overridePendingTransition(0, 0);
                 break;




             case 3: //messages
                 Intent intentmessages = new Intent(DrawerAccueil.this,DrawerMessages.class);
                 startActivity(intentmessages);
                 overridePendingTransition(0, 0);
                 break;

             case 4: //reglages
                 Intent intentreglages = new Intent(DrawerAccueil.this,DrawerReglages.class);
                 startActivity(intentreglages);
                 overridePendingTransition(0, 0);
                 break;

             case 5: //a propos
                 Intent intentapropos = new Intent(DrawerAccueil.this,DrawerAPropos.class);
                 startActivity(intentapropos);
                 overridePendingTransition(0, 0);
                 break;

            }

            drawerAccueil.closeDrawer(itemDrawer);


        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
                if(drawerToggle.onOptionsItemSelected(item)) {
                   return true;}

                return super.onOptionsItemSelected(item);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        mMap.setMyLocationEnabled(true);



    }
}



