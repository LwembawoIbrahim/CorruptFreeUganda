package com.ibralwembawogmail.corruptfreeuganda.FragmentClasses;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ibralwembawogmail.corruptfreeuganda.adapterClasses.OnGoingCriminalCasesAdapter;
import com.ibralwembawogmail.corruptfreeuganda.R;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionContract.CorruptionDataEntry;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionDatabaseHelper;

public class OnGoingCasesActivity extends Fragment{

    RecyclerView  OnGoingCriminalCasesRecyclerView;
    OnGoingCriminalCasesAdapter criminalCasesAdapter;
   // List<OnGoingCriminalCases> criminalCasesList = new ArrayList<>();
    public OnGoingCasesActivity(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_on_going_cases);

    }
    String [] OngoingCriminalCasesProjection ={
    CorruptionDataEntry._ID,
            CorruptionDataEntry.COLUMN_USER_NAME,
            CorruptionDataEntry.COLUMN_PHONE_NUMBER,
            CorruptionDataEntry.COLUMN_EMAIL,
            CorruptionDataEntry.COLUMN_PASSWORD,
            CorruptionDataEntry.COLUMN_REPORT_TITLE,
            CorruptionDataEntry.COLUMN_REPORT_DESCRIPTION,
            CorruptionDataEntry.COLUMN_IMAGE_UPLOAD,
            CorruptionDataEntry.COLUMN_VIDEO_UPLOAD,
            CorruptionDataEntry.COLUMN_AUDIO_UPLOAD

    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.activity_on_going_cases,container,false);
        CriminalCaseDataRetrieval();
  OnGoingCriminalCasesRecyclerView = (RecyclerView)view.findViewById(R.id.OnGoingCriminalCasesRecyclerView);
 OnGoingCriminalCasesRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
  criminalCasesAdapter = new OnGoingCriminalCasesAdapter(CriminalCaseDataRetrieval());
        OnGoingCriminalCasesRecyclerView.setAdapter(criminalCasesAdapter);

    return view;

    }
    private Cursor CriminalCaseDataRetrieval(){
        CorruptionDatabaseHelper corruptionDatabaseHelper = new CorruptionDatabaseHelper(this.getContext());
        SQLiteDatabase crimeData = corruptionDatabaseHelper.getReadableDatabase();
        Cursor crimeCursor = crimeData.query(
                CorruptionDataEntry.TABLE_CORRUPTION_DATA,
                OngoingCriminalCasesProjection,
                null,
                null,
                null,
                null,
                null

        );
        if(crimeCursor!=null && crimeCursor.getCount()>0){
            return crimeCursor;
        }
        else {
            Toast.makeText(this.getContext(),"No data Retrieved",Toast.LENGTH_SHORT).show();
        }
        return null;
    }









}
