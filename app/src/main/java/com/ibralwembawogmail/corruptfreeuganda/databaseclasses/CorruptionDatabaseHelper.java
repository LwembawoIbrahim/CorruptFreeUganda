package com.ibralwembawogmail.corruptfreeuganda.databaseclasses;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionContract.CorruptionDataEntry;

/**
 * Created by LWEMBAWO on 3/14/2018.
 */

public class CorruptionDatabaseHelper extends SQLiteOpenHelper {


    //This is the initial database version
    public static  final int DATABASE_VERSION = 4;

    //This is the database name
    public static final String DATABASE_NAME =" Corruption.db ";

public static final String SQL_CREATE_TABLE_CORRUPTION_DATA = " CREATE TABLE " +
      CorruptionDataEntry.TABLE_CORRUPTION_DATA + "( "+ CorruptionDataEntry._ID + " INTEGER PRIMARY KEY,"+
        CorruptionDataEntry.COLUMN_USER_NAME +" TEXT,"
        +CorruptionDataEntry.COLUMN_PHONE_NUMBER + " TEXT,"
        /*CorruptionDataEntry.COLUMN_EMAIL+ " TEXT,"
        +CorruptionDataEntry.COLUMN_PASSWORD + " TEXT," */
        +CorruptionDataEntry.COLUMN_REPORT_TITLE +" TEXT,"
        + CorruptionDataEntry.COLUMN_REPORT_DESCRIPTION +" TEXT ,"
        +CorruptionDataEntry.COLUMN_IMAGE_UPLOAD + " BLOB, "
        + CorruptionDataEntry.COLUMN_VIDEO_UPLOAD + " BLOB, "
        +CorruptionDataEntry.COLUMN_AUDIO_UPLOAD + " BLOB )";
//These lines of codes deletes a table if exists in the database
private static final String SQL_DELETE_TABLE_CORRUPTION_DATA =
        "DROP TABLE IF EXISTS " + CorruptionDataEntry.TABLE_CORRUPTION_DATA;

//These are the columns in the database
    //public static final String IGG_OFFICE_DATABASE="IggOffices.db";
    public static final String SQL_CREATE_TABLE_IGG_OFFICES =" CREATE TABLE "+
            CorruptionDataEntry.TABLE_IGG_OFFICES +"("+CorruptionDataEntry._ID
            + " INTEGER PRIMARY KEY, "+
            CorruptionDataEntry.COLUMN_OFFICE_NAME +" TEXT, "+
            CorruptionDataEntry.COLUMN_OFFICE_ADDRESS+ " TEXT, "+
            CorruptionDataEntry.COLUMN_OFFICE_BOX_NUMBER + " TEXT,"+
            CorruptionDataEntry.COLUMN_OFFICE_NUMBER + " TEXT, "+
            CorruptionDataEntry.COLUMN_OFFICE_EMAIL + " TEXT )";

    public static final String SQL_DELETE_TABLE_IGG_OFFICES = " DROP TABLE IF EXISTS " +
            CorruptionDataEntry.TABLE_IGG_OFFICES;





    //This method is called on creating of the database
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_CORRUPTION_DATA);
        db.execSQL(SQL_CREATE_TABLE_IGG_OFFICES);


    }

    //This method is called you make a deletion of the database
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_TABLE_CORRUPTION_DATA);
        db.execSQL(SQL_DELETE_TABLE_IGG_OFFICES);
        onCreate(db);


    }
  //This is the constructor for the CorruptionDatabaseHelper class
    public CorruptionDatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        //super(context,IGG_OFFICE_DATABASE,null,DATABASE_VERSION);

    }
}
