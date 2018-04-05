package com.ibralwembawogmail.corruptfreeuganda.FragmentClasses.civil_cases;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ibralwembawogmail.corruptfreeuganda.R;
import com.ibralwembawogmail.corruptfreeuganda.adapterClasses.CivilCaseAdapter;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionContract.CorruptionDataEntry;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionDatabaseHelper;

public class OnGoingCivilCaseFragment extends Fragment {
    RecyclerView civilCaseRecycler;
    CivilCaseAdapter civilCaseAdapter;


    public OnGoingCivilCaseFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_on_going_civil_case_fragment);
    }
    String[] civilCaseProjection = {
            CorruptionDataEntry._ID,
            CorruptionDataEntry.COLUMN_CIVIL_USER_NAME,
            CorruptionDataEntry.COLUMN_CIVIL_PHONE_NUMBER,
            CorruptionDataEntry.COLUMN_CIVIL_REPORT_TITLE,
            CorruptionDataEntry.COLUMN_CIVIL_REPORT_DESCRIPTION,
            CorruptionDataEntry.COLUMN_CIVIL_IMAGE_UPLOAD,
            CorruptionDataEntry.COLUMN_CIVIL_IMAGE_UPLOAD,
            CorruptionDataEntry.COLUMN_CIVIL_AUDIO_UPLOAD,
    };
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savesInstanceState) {
        final View view = inflater.inflate(R.layout.activity_on_going_civil_case_fragment, container, false);
        civilCursorDataRetrieval();
        civilCaseRecycler = view.findViewById(R.id.OnGoingCivilCasesRecyclerView);
        civilCaseRecycler.setLayoutManager( new LinearLayoutManager(this.getContext()));
        civilCaseAdapter = new CivilCaseAdapter(civilCursorDataRetrieval());
        civilCaseRecycler.setAdapter(civilCaseAdapter);
        return view;

    }

    private Cursor civilCursorDataRetrieval() {
        CorruptionDatabaseHelper civilHelper = new CorruptionDatabaseHelper(this.getContext());
        SQLiteDatabase civilDb = civilHelper.getReadableDatabase();

     Cursor civilCursor =civilDb.query(
             CorruptionDataEntry.TABLE_CIVIL_CASES,
            civilCaseProjection,
            null,
            null,
             null,
             null,
             null,
             null


     );
     if(civilCursor!=null&& civilCursor.getCount()>0){
         return civilCursor;
     }
     else {
         Toast.makeText(this.getContext(),"No data Retrieved",Toast.LENGTH_SHORT).show();
     }
     return null;

    }

}

