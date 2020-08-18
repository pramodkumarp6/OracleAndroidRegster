package com.android.oracle.android.regster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        getSupportActionBar().hide();

        Thread t=new Thread() {
            public void run() {

                try {

                    sleep(1000);


                    Intent i=new Intent(HomeActivity.this, Login.class);
                    startActivity(i);


                    finish();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };


        t.start();
    }
}


