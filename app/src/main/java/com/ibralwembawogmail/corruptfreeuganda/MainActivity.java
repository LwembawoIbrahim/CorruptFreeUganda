package com.ibralwembawogmail.corruptfreeuganda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.ibralwembawogmail.corruptfreeuganda.FragmentClasses.CourtCasesActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView reportCardView = (CardView)findViewById(R.id.cardViewReportCase);
        reportCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent reportCases = new Intent(MainActivity.this,TextReportingActivity.class);
                startActivity(reportCases);
            }
        });

        CardView cardViewCourtCase = (CardView)findViewById(R.id.cardViewCourtCases);
        cardViewCourtCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent courCases = new Intent(MainActivity.this,CourtCasesActivity.class);
                startActivity(courCases);

            }
        });

        CardView cardViewGoverntmentServices = (CardView)findViewById(R.id.cardViewGovServices);
        cardViewGoverntmentServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent governmentServices = new Intent(MainActivity.this,GovernmentServicesActivity.class);
                startActivity(governmentServices);
            }
        });

        CardView cardViewInformation = (CardView)findViewById(R.id.cardViewInformation);
        cardViewInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent information = new Intent(MainActivity.this,InformationActivity.class);
                startActivity(information);

            }
        });
    }
}
