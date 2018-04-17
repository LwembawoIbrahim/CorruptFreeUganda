package com.ibralwembawogmail.corruptfreeuganda;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ibralwembawogmail.corruptfreeuganda.adapterClasses.CasesAdapter;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionContract;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionDatabaseHelper;

public class CasesActivity extends AppCompatActivity {
    RecyclerView casesRecyclerView;
    CasesAdapter casesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases);
        casesCursorDataRetrieval();
        casesRecyclerView =(RecyclerView)findViewById(R.id.casesRecyclerView);
        casesRecyclerView.setLayoutManager( new LinearLayoutManager(this));
        casesAdapter = new CasesAdapter(casesCursorDataRetrieval());
        casesRecyclerView.setAdapter(casesAdapter);


    }



    String[] CasesProjection = {
            CorruptionContract.CorruptionDataEntry._ID,
            CorruptionContract.CorruptionDataEntry.COLUMN_CIVIL_USER_NAME,
            CorruptionContract.CorruptionDataEntry.COLUMN_CIVIL_PHONE_NUMBER,
            CorruptionContract.CorruptionDataEntry.COLUMN_CIVIL_REPORT_TITLE,
            CorruptionContract.CorruptionDataEntry.COLUMN_CIVIL_REPORT_DESCRIPTION,
            CorruptionContract.CorruptionDataEntry.COLUMN_CIVIL_IMAGE_UPLOAD,
            CorruptionContract.CorruptionDataEntry.COLUMN_CIVIL_IMAGE_UPLOAD,
            CorruptionContract.CorruptionDataEntry.COLUMN_CIVIL_AUDIO_UPLOAD,
    };





    private Cursor casesCursorDataRetrieval() {
        CorruptionDatabaseHelper civilHelper = new CorruptionDatabaseHelper(this);
        SQLiteDatabase casesDb = civilHelper.getReadableDatabase();

        Cursor casesCursor =casesDb.query(
                CorruptionContract.CorruptionDataEntry.TABLE_CIVIL_CASES,
                CasesProjection,
                null,
                null,
                null,
                null,
                null,
                null


        );
        if(casesCursor!=null&& casesCursor.getCount()>0){
            return casesCursor;
        }
        else {
            Toast.makeText(this,"No data Retrieved",Toast.LENGTH_SHORT).show();
        }
        return null;

    }


}






