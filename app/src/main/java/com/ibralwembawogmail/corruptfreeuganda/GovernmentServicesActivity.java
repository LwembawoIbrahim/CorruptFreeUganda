package com.ibralwembawogmail.corruptfreeuganda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GovernmentServicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_government_services);
        FetchDataFromServer fetch = new FetchDataFromServer();
        fetch.execute();
    }
    Intent intent = getIntent();

}
