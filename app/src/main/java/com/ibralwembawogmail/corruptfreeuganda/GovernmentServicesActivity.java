package com.ibralwembawogmail.corruptfreeuganda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GovernmentServicesActivity extends AppCompatActivity {

    public  static TextView data;
    Button ClickMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_government_services);

        data = findViewById(R.id.textView2);
        ClickMe = findViewById(R.id.button);
        //FetchDataFromServer fetch = new FetchDataFromServer();
        //fetch.execute();


        ClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Server server = new Server();
                server.execute();

            }
        });
    }
    Intent intent = getIntent();

}
