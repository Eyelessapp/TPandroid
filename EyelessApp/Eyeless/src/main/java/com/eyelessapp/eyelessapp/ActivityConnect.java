package com.eyelessapp.eyelessapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;

import com.eyelessapp.eyelessapp.ActivitesDrawer.DrawerAccueil;

public class ActivityConnect extends Activity {

    Button boutonConnection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);
        setTitle(R.string.app_name);


        View.OnClickListener ButtonConnection = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 Intent intent = new Intent(ActivityConnect.this,DrawerAccueil.class);
                startActivity(intent);}

        };


        boutonConnection=(Button) findViewById(R.id.bouton_connection);
        boutonConnection.setOnClickListener(ButtonConnection);


    }


}
