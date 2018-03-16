package com.ibralwembawogmail.corruptfreeuganda.databaseclasses;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by LWEMBAWO on 3/14/2018.
 */

public class CorruptionContract implements BaseColumns {

    //This is the initial database version
     public static  final int DATABASE_VERSION = 1;

      //This is the database name
    public static final String DATABASE_NAME =" Corruption.db ";
}
