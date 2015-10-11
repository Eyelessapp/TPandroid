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
import android.widget.ListView;

import com.eyelessapp.eyelessapp.R;

public class DrawerMessages extends Activity {

    String[] drawerItemList;
    DrawerLayout drawerMessages;
    ListView itemDrawer;
    ActionBarDrawerToggle drawerToggle;

    MyDrawerClickListener clickDrawer = new MyDrawerClickListener();//Création du click listener pour les items du drawer

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawermessages);

        drawerMessages = (DrawerLayout) findViewById(R.id.drawer_messages);
        drawerItemList = getResources().getStringArray(R.array.items_drawer); // recupere la liste pour le menu deroulant

        itemDrawer = (ListView) findViewById(R.id.menu_Coulissant);
        itemDrawer.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_item, drawerItemList));
        itemDrawer.setOnItemClickListener(clickDrawer);

        ActionBar actionBar;
        actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        drawerToggle = new ActionBarDrawerToggle(this, drawerMessages,R.string.ouverture,R.string.fermeture){

            public void onDrawerClosed(View view){
                invalidateOptionsMenu();}

            public void onDrawerOpened(View drawerView){
                invalidateOptionsMenu();
            }
        };

        drawerMessages.setDrawerListener(drawerToggle);

    }



    private class MyDrawerClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

            String  itemCLiquer = (String) adapter.getAdapter().getItem(position);

            switch (position+1){
                case 1: //accueil
                    Intent intentaccueil = new Intent(DrawerMessages.this,DrawerAccueil.class);
                    startActivity(intentaccueil);
                    overridePendingTransition(0,0);
                    break;

                case 2: //profil

                    Intent intentprofil = new Intent(DrawerMessages.this,DrawerProfil.class);
                    startActivity(intentprofil);
                    overridePendingTransition(0,0);
                    break;




                case 3: //messages
                 break;

                case 4: //reglages
                    Intent intentreglages = new Intent(DrawerMessages.this,DrawerReglages.class);
                    startActivity(intentreglages);
                    overridePendingTransition(0,0);
                    break;

                case 5: //a propos
                    Intent intentapropos = new Intent(DrawerMessages.this,DrawerAPropos.class);
                    startActivity(intentapropos);
                    overridePendingTransition(0,0);
                    break;

            }

            drawerMessages.closeDrawer(itemDrawer);


        }


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)) {
            return true;}

        return super.onOptionsItemSelected(item);

    }
}
