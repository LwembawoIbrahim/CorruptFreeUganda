package com.ibralwembawogmail.corruptfreeuganda.databaseclasses;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionContract.DATABASE_NAME;
import static com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionContract.DATABASE_VERSION;

/**
 * Created by LWEMBAWO on 3/14/2018.
 */

public class CorruptionDatabaseHelper extends SQLiteOpenHelper {


    //This method is called on creating of the database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    //This method is called you make a deletion of the database
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
  //This is the constructor for the CorruptionDatabaseHelper class
    public CorruptionDatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);

    }
}
