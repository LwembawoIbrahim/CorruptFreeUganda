package com.ibralwembawogmail.corruptfreeuganda;

import android.app.ProgressDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.reflect.TypeToken;
import com.ibralwembawogmail.corruptfreeuganda.adapterClasses.CasesAdapter;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionContract;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionDatabaseHelper;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CasesActivity extends AppCompatActivity {
    RecyclerView casesRecyclerView;
    CasesAdapter casesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases);
        casesCursorDataRetrieval();
        casesRecyclerView = (RecyclerView) findViewById(R.id.casesRecyclerView);
        casesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        casesAdapter = new CasesAdapter(casesCursorDataRetrieval());
        casesRecyclerView.setAdapter(casesAdapter);


    }


    String[] CasesProjection = {
            CorruptionContract.CorruptionDataEntry._ID,
            CorruptionContract.CorruptionDataEntry.COLUMN_USER_NAME,
            CorruptionContract.CorruptionDataEntry.COLUMN_PHONE_NUMBER,
            CorruptionContract.CorruptionDataEntry.COLUMN_REPORT_TITLE,
            CorruptionContract.CorruptionDataEntry.COLUMN_REPORT_DESCRIPTION,
            CorruptionContract.CorruptionDataEntry.COLUMN_IMAGE_UPLOAD,
            CorruptionContract.CorruptionDataEntry.COLUMN_VIDEO_UPLOAD,
            CorruptionContract.CorruptionDataEntry.COLUMN_AUDIO_UPLOAD,
    };


    private Cursor casesCursorDataRetrieval() {
        CorruptionDatabaseHelper civilHelper = new CorruptionDatabaseHelper(this);
        SQLiteDatabase casesDb = civilHelper.getReadableDatabase();

        Cursor casesCursor = casesDb.query(
                CorruptionContract.CorruptionDataEntry.TABLE_CORRUPTION_DATA,
                CasesProjection,
                null,
                null,
                null,
                null,
                null,
                null


        );
        if (casesCursor != null && casesCursor.getCount() > 0) {
            return casesCursor;
        } else {
            Toast.makeText(this, "No data Retrieved", Toast.LENGTH_SHORT).show();
        }
        return null;

    }

    /*public void DisplayCategoryData(){
        final ProgressDialog pd;
        pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.setCancelable(false);
        pd.show();*/
    //wifi for ict workshop 10.16.1.194
    // String url = Uri.parse("http://10.16.1.194 :8000/CategoryList.aspx").buildUpon().build().toString();
    //String url = Uri.parse("http://10.0.0.15 :8000/CategoryList.aspx").buildUpon().build().toString();

    //String url = Uri.parse("http://10.11.1.55:8000/CategoryList.aspx").buildUpon().build().toString();
    //String url = Uri.parse("http://10.11.1.139:8000/CategoryList.aspx").buildUpon().build().toString();
    //Android Virtual device ip addresses
    //IP : 127.0.0.1, 10.0.0.2 or 10.0.0.15
       /* Ion.with(getBaseContext()).load(url).progressDialog(pd).as(new  TypeToken<List<CasesAdapter>>() {
        }).setCallback(new FutureCallback <CasesAdapter>() {
            @Override
            public void onCompleted(Exception e, CasesAdapter result) {

            }

            @Override
            public void onCompleted(Exception e, List<CategoryList> CategoryList) {


                //Log.e("Lwembawo", "The number of items in an array"+ CategoryList.size());
            }
        });*/




}






