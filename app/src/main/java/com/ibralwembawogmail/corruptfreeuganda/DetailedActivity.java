package com.ibralwembawogmail.corruptfreeuganda;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.ibralwembawogmail.corruptfreeuganda.adapterClasses.OnGoingCriminalCasesAdapter;
import  com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionContract.CorruptionDataEntry;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionDatabaseHelper;


public class DetailedActivity extends AppCompatActivity {
    String DetailTitle;
    String DetailDescription;
    String tvOnGoingCaseCourtTitle;
    String tvGoingCriminalCaseDescription;
   String extraTitle ;
   String extraDescription ;

   String[] DetailsProjection ={
           CorruptionDataEntry._ID,
           CorruptionDataEntry.COLUMN_USER_NAME,
           CorruptionDataEntry.COLUMN_PHONE_NUMBER,
           CorruptionDataEntry.COLUMN_REPORT_TITLE,
           CorruptionDataEntry.COLUMN_REPORT_DESCRIPTION
   };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
      DetailTitle = ((TextView)findViewById(R.id.txtDetailedCaseTitle)).toString();
      DetailDescription = ((TextView)findViewById(R.id.txtDetailsCaseDescription)).toString();
        //tvGoingCriminalCaseDescription = ((TextView)findViewById(R.id.txtCaseDescription)).getText().toString();
        Intent getIntent = getIntent();
        extraTitle = getIntent.getStringExtra(OnGoingCriminalCasesAdapter.extraTitle);

        extraDescription = getIntent.getStringExtra(OnGoingCriminalCasesAdapter.extraDescription);

    }

    public  void DisplayDataFromOnGoingCriminalCases(Cursor Details){
        Details.moveToFirst();
        ((TextView)findViewById(R.id.txtDetailedCaseTitle))
                .setText(Details.getString(Details.getColumnIndex(CorruptionDataEntry.COLUMN_REPORT_TITLE)));
        ((TextView)findViewById(R.id.txtDetailedCaseTitle))
                .setText(Details.getString(Details.getColumnIndex(CorruptionDataEntry.COLUMN_REPORT_DESCRIPTION)));
        DisplayDataFromOnGoingCriminalCases(DataRetrieval());
    }

    private Cursor DataRetrieval(){
        CorruptionDatabaseHelper cDataHelper = new CorruptionDatabaseHelper(this.getApplicationContext());
        SQLiteDatabase detailsDb = cDataHelper.getReadableDatabase();
        String selection  = CorruptionDataEntry._ID + " = ?";
        String[] selectionArgs ={
                extraTitle,extraDescription

        };
        Cursor detailCursor = detailsDb.query(
                CorruptionDataEntry.TABLE_CORRUPTION_DATA,
               DetailsProjection,
                selection,
                selectionArgs,
                null,null,null

        );
        if(detailCursor !=null &&detailCursor.getCount()>0){
            return  detailCursor;
        }
        else {
            Toast.makeText(getApplicationContext(),"No data to display",Toast.LENGTH_SHORT).show();
        }
        return null;

    }









    Intent intent = getIntent();


}
