package com.ibralwembawogmail.corruptfreeuganda.databaseclasses;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionContract.CorruptionDataEntry;

import java.sql.Struct;


/**
 * Created by LWEMBAWO on 3/14/2018.
 */

public class CorruptionContract  {

    //This is a corruptionContract constructor
   public CorruptionContract(){

   }

   public  static final class CorruptionDataEntry implements BaseColumns{

       //This is the table name
       public  static final  String TABLE_CORRUPTION_DATA = "CorruptionData";

  //These are the table columns
       public static  final String COLUMN_USER_NAME = "UserName";
       public static  final String COLUMN_PHONE_NUMBER="PhoneNumber";
      // public static  final String COLUMN_EMAIL = "Email";
      // public  static final String COLUMN_PASSWORD = "Password";
       public static final String COLUMN_REPORT_TITLE = "Report_title";
       public static final String COLUMN_REPORT_DESCRIPTION = "ReportDescription";
       public static final String COLUMN_IMAGE_UPLOAD ="Image_uploads";
       public  static final String COLUMN_VIDEO_UPLOAD ="Video_upload";
       public static final String COLUMN_AUDIO_UPLOAD = "Audio_upload";


       //Table name for Igg Offices
       public static final String TABLE_IGG_OFFICES = "IggOffices";

       //These are the table columns

       public static final String COLUMN_OFFICE_NAME="OfficeName";
       public static final String COLUMN_OFFICE_ADDRESS="OfficeAddress";
       public static final String COLUMN_OFFICE_BOX_NUMBER="BoxNumber";
       public static final String COLUMN_OFFICE_NUMBER="TelephoneNumber";
       public static final String COLUMN_OFFICE_EMAIL="OfficeEmail";

   }





}
