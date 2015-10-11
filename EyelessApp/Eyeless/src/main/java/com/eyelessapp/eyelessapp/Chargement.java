package com.eyelessapp.eyelessapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Chargement extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chargement);


        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(500);
                } catch (Exception e) {

                } finally {
                    Intent i = new Intent(Chargement.this, ActivityConnect.class);
                    startActivity(i);
                    finish();
                }
            }
        };

        welcomeThread.start();
    }
}
