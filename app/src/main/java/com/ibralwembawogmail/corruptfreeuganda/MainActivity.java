package com.ibralwembawogmail.corruptfreeuganda;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.ibralwembawogmail.corruptfreeuganda.FragmentClasses.civil_cases.CivilCaseFragment;
import com.ibralwembawogmail.corruptfreeuganda.FragmentClasses.civil_cases.OnGoingCivilCaseFragment;
import com.ibralwembawogmail.corruptfreeuganda.FragmentClasses.criminal_cases.CourtCasesFragment;
import com.ibralwembawogmail.corruptfreeuganda.FragmentClasses.IggOfficesActivity;


import com.ibralwembawogmail.corruptfreeuganda.AdminLogInActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final String LOG_TAG =" Civil";
    Button civilCase;
    Button criminalCases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        setContentView(R.layout.activity_main);

        CardView reportCardView = findViewById(R.id.cardViewReportCase);
        reportCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                View alertView = getLayoutInflater().inflate(R.layout.dialog_select_case_type,null);
                criminalCases =(Button)alertView.findViewById(R.id.crimeCases);

                criminalCases.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent  gotoCriminal= new Intent(MainActivity.this,TextReportingActivity.class);
                        startActivity(gotoCriminal);


                    }
                });
                civilCase = (Button)alertView.findViewById(R.id.civilCases);
                civilCase.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent gotoCivilReport = new Intent(MainActivity.this,TextReportingActivity.class);
                        startActivity(gotoCivilReport);

                    }
                });
                alertBuilder.setView(alertView);
                AlertDialog dialog = alertBuilder.create();
                dialog.show();*/

                Intent reportCases = new Intent(MainActivity.this,TextReportingActivity.class);
                startActivity(reportCases);
            }
        });

        CardView cardViewCourtCases = (CardView)findViewById(R.id.cardViewCourtCases);
        cardViewCourtCases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent courtCases = new Intent(MainActivity.this,CourtCasesFragment.class);
                startActivity(courtCases);
            }
        });

       /* CardView cardViewGoverntmentServices = (CardView)findViewById(R.id.cardViewGovServices);
        cardViewGoverntmentServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                View alertView = getLayoutInflater().inflate(R.layout.govert_new_ver,null);
                TextView oktxt =(TextView) alertView.findViewById(R.id.txtOk);
                      oktxt.setOnClickListener(new View.OnClickListener() {
                          @Override
                          public void onClick(View view) {
                              Intent governmentServices = new Intent(MainActivity.this,MainActivity.class);

                              startActivity(governmentServices);


                          }
                      });

                        alertBuilder.setView(alertView);
                        AlertDialog dialog = alertBuilder.create();
                        dialog.show();



            }
        });

        CardView cardViewInformation = (CardView)findViewById(R.id.cardViewInformation);
        cardViewInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new  AlertDialog.Builder(MainActivity.this);
                View alertView = getLayoutInflater().inflate(R.layout.info_new_ver,null);
                TextView okinfotxt =(TextView) alertView.findViewById(R.id.infotxtOk);
                okinfotxt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent information = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(information);

                    }
                });

                alertDialog.setView(alertView);
                AlertDialog dialog = alertDialog.create();
                dialog.show();


            }
        });*/


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent gotoIggOffices = new Intent(this,IggOfficesActivity.class);
            startActivity(gotoIggOffices);
        } else if (id == R.id.nav_gallery) {
            Intent gotoCivil = new Intent(MainActivity.this, CivilCaseFragment.class);

            Log.d(LOG_TAG,"This should go to Civil Case");
            startActivity(gotoCivil);


        }
        else if (id == R.id.nav_slideshow) {
           AdminLogInActivity a = new AdminLogInActivity();
            Intent gotoCases = new Intent(this,CasesActivity.class);
            startActivity(gotoCases);

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
