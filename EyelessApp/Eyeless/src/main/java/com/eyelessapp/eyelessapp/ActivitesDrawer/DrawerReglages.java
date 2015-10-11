package com.eyelessapp.eyelessapp.ActivitesDrawer;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

import com.eyelessapp.eyelessapp.R;

public class DrawerReglages extends Activity {

    String[] drawerItemList;
    DrawerLayout drawerReglages;
    ListView itemDrawer;
    ActionBarDrawerToggle drawerToggle;
    CheckBox checkHomme,checkFemme;

    MyDrawerClickListener clickDrawer = new MyDrawerClickListener();//Création du click listener pour les items du drawer

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawerreglage);

        drawerReglages = (DrawerLayout) findViewById(R.id.drawer_reglages);
        drawerItemList = getResources().getStringArray(R.array.items_drawer); // recupere la liste pour le menu deroulant

        itemDrawer = (ListView) findViewById(R.id.menu_Coulissant);
        itemDrawer.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_item, drawerItemList));
        itemDrawer.setOnItemClickListener(clickDrawer);

        checkHomme = (CheckBox) findViewById(R.id.checkHomme);
        checkFemme = (CheckBox) findViewById(R.id.checkFemme);

        ActionBar actionBar;
        actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        drawerToggle = new ActionBarDrawerToggle(this, drawerReglages,R.string.ouverture,R.string.fermeture){

            public void onDrawerClosed(View view){
                invalidateOptionsMenu();}

            public void onDrawerOpened(View drawerView){
                invalidateOptionsMenu();
            }
        };

        drawerReglages.setDrawerListener(drawerToggle);

    }



    private class MyDrawerClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

            String  itemCLiquer = (String) adapter.getAdapter().getItem(position);

            switch (position+1){
                case 1://accueil
                    Intent intent = new Intent(DrawerReglages.this,DrawerAccueil.class);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                    break;

                case 2://profil
                Intent intentProfil = new Intent(DrawerReglages.this,DrawerProfil.class);
                startActivity(intentProfil);
                overridePendingTransition(0,0);
                break;

                case 3://messages
                    Intent intentMessages = new Intent(DrawerReglages.this,DrawerMessages.class);
                    startActivity(intentMessages);
                    overridePendingTransition(0,0);
                   break;

                case 4://reglages

                    break;

                case 5://A Propos
                    Intent intentApropos = new Intent(DrawerReglages.this,DrawerAPropos.class);
                    startActivity(intentApropos);
                    overridePendingTransition(0,0);
                    break;

            }

            drawerReglages.closeDrawer(itemDrawer);


        }


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)) {
            return true;}

        return super.onOptionsItemSelected(item);

    }
}
