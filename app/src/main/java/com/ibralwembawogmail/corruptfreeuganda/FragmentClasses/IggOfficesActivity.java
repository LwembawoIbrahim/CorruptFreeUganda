package com.ibralwembawogmail.corruptfreeuganda.FragmentClasses;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.ibralwembawogmail.corruptfreeuganda.AdminLogInActivity;
import com.ibralwembawogmail.corruptfreeuganda.R;
import com.ibralwembawogmail.corruptfreeuganda.adapterClasses.IggOfficesAdapter;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionContract.CorruptionDataEntry;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionDatabaseHelper;

public class IggOfficesActivity extends AppCompatActivity {
    RecyclerView iggRecyclerView;

    String[] iggOfficesProjection={
    CorruptionDataEntry._ID,
            CorruptionDataEntry.COLUMN_OFFICE_NAME,
            CorruptionDataEntry.COLUMN_OFFICE_ADDRESS,
            CorruptionDataEntry.COLUMN_OFFICE_BOX_NUMBER,
            CorruptionDataEntry.COLUMN_OFFICE_NUMBER,
            CorruptionDataEntry.COLUMN_OFFICE_EMAIL,
            CorruptionDataEntry.COLUMN_OFFICE_FAX


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igg_offices);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        IggOfficeDataRetrieval();

        iggRecyclerView = (RecyclerView)findViewById(R.id.igg_offices_recyclerView);
        iggRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        IggOfficesAdapter officesAdapter = new IggOfficesAdapter(IggOfficeDataRetrieval());
        iggRecyclerView.setAdapter(officesAdapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent gotoLogin = new Intent(IggOfficesActivity.this,AdminLogInActivity.class);
                startActivity(gotoLogin);

            }
        });


    }
    private Cursor IggOfficeDataRetrieval() {

        CorruptionDatabaseHelper corruptionDatabaseHelper = new CorruptionDatabaseHelper(this);
        SQLiteDatabase fDb = corruptionDatabaseHelper.getReadableDatabase();

        Cursor iggOfficeCursor = fDb.query(
                CorruptionDataEntry.TABLE_IGG_OFFICES,
                iggOfficesProjection,
                null,
                null,
                null,
                null,
                null
        );
        if (iggOfficeCursor != null) {
            return iggOfficeCursor;
        } else
            Toast.makeText(this, "No data inserted", Toast.LENGTH_SHORT).show();
        return null;

    }





}
