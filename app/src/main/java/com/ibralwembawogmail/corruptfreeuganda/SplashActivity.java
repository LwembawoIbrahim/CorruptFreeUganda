package com.ibralwembawogmail.corruptfreeuganda;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
    private static int Splash_time_out =3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

       /* Intent goToMainActivity = new Intent(this,MainActivity.class);
         startActivity(goToMainActivity);
         3000)
         finish();*/
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent goToMainActivity = new Intent(SplashActivity.this,MainActivity.class);
               startActivity(goToMainActivity);
               finish();
           }
       },
       Splash_time_out);


    }



}
