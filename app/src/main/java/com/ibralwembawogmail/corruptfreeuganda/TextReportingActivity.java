package com.ibralwembawogmail.corruptfreeuganda;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ibralwembawogmail.corruptfreeuganda.FragmentClasses.CourtCasesActivity;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionDatabaseHelper;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionContract.CorruptionDataEntry;

public class TextReportingActivity extends AppCompatActivity {

    String UserName;
    String PhoneNumber;
    String Email;
    String Password;
    String ReportTitle;
    String ReportDescription;
    String UploadImage;
    String UploadVideo;
    String UploadAudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_reporting);
        final EditText uploadImage = ((EditText) findViewById(R.id.ed_report_upload_image));
        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /* AlertDialog.Builder imageBuilder = new AlertDialog.Builder(TextReportingActivity.this);
            View imgView = getLayoutInflater().inflate(R.layout.dialog_upload_image,null);
             final CardView img_take_photo = (CardView)imgView.findViewById(R.id.cardTakePhoto);
             final CardView img_get_gallery = (CardView)imgView.findViewById(R.id.cardUpChooseFromGallery);
             final Button dialog_cancel = (Button)imgView.findViewById(R.id.btn_cancel);

             imageBuilder.setView(imgView);
             AlertDialog dialog = imageBuilder.create();
             dialog.show();*/
                //Using an image intent to put images from gallery
                Intent imageChooser = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivity(imageChooser);






                //previewing an image
               /*  AlertDialog.Builder imageBuilder = new AlertDialog.Builder(TextReportingActivity.this);
            View imgView = getLayoutInflater().inflate(R.layout.dialog_upload_image,null);
             final ImageView img_take_photo = imgView.findViewById(R.id.upLoadImage);
             //final CardView img_get_gallery = (CardView)imgView.findViewById(R.id.cardUpChooseFromGallery);
            // final Button dialog_cancel = (Button)imgView.findViewById(R.id.btn_cancel);



             imageBuilder.setView(imgView);
             AlertDialog dialog = imageBuilder.create();
             dialog.show();*/

               // previewImage.setImageURI(imageChooser.getData());





                            }



        });

        EditText uploadVideo = ((EditText) findViewById(R.id.ed_report_upload_video));
        uploadVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*AlertDialog.Builder videoAlertDialog = new AlertDialog.Builder(TextReportingActivity.this);
              View videoView = getLayoutInflater().inflate(R.layout.dialog_upload_video,null);
             final CardView record_video = (CardView)videoView.findViewById(R.id.cardRecordVideo);
             final CardView chooseVideoFromGallery = (CardView)videoView.findViewById(R.id.cardUpChooseFromGallery);
             Button video_upload = (Button)videoView.findViewById(R.id.btn_Video_cancel);
             video_upload.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {

                 }
             });
             videoAlertDialog.setView(videoView);
             AlertDialog dialog = videoAlertDialog.create();
             dialog.show();*/
                //This intent picks a video from the gallery
                Intent videoPicker = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                startActivity(videoPicker);
            }


        });
        EditText audioSelector = ((EditText) findViewById(R.id.ed_report_upload_audio));
        audioSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent audioSelector = new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                startActivity(audioSelector);
            }
        });
    }
    public  void OnSaving(View view){
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.send_fab);

                UserName = ((EditText)findViewById(R.id.ed_user_name)).getText().toString();
                PhoneNumber = ((EditText)findViewById(R.id.ed_contact)).getText().toString();
               // Email = ((EditText)findViewById(R.id.ed_email)).getText().toString();
               // Password = ((EditText)findViewById(R.id.ed_password)).getText().toString();
                ReportTitle =((EditText)findViewById(R.id.ed_report_title)).getText().toString();
                ReportDescription =((EditText)findViewById(R.id.ed_report_description)).getText().toString();
               /* UploadImage =((EditText)findViewById(R.id.ed_report_upload_image))
                UploadVideo = ((EditText)findViewById(R.id.ed_report_upload_video)).getResources().toString();
                UploadAudio = ((EditText)findViewById(R.id.ed_report_upload_audio)).getResources().toString();*/

                if(!UserName.equals("")
                        &&!PhoneNumber.equals("")
                       // &&!Email.equals("")
                        //&&!Password.equals("")
                        &&!ReportTitle.equals("")
                        &&!ReportDescription.equals("")){

                    //Instantiate the database helper class in order to access the database columns
                    CorruptionDatabaseHelper corruptionDatabaseHelper = new CorruptionDatabaseHelper(getApplicationContext());
                    //Put the data in write model
                    SQLiteDatabase corruptionDb = corruptionDatabaseHelper.getWritableDatabase();

                    ContentValues contentValues = new ContentValues();

                    contentValues.put(CorruptionDataEntry.COLUMN_USER_NAME,UserName);
                    contentValues.put(CorruptionDataEntry.COLUMN_PHONE_NUMBER,PhoneNumber);
                   /* contentValues.put(CorruptionDataEntry.COLUMN_EMAIL,Email);
                    contentValues.put(CorruptionDataEntry.COLUMN_PASSWORD,Password);*/
                    contentValues.put(CorruptionDataEntry.COLUMN_REPORT_TITLE,ReportTitle);
                    contentValues.put(CorruptionDataEntry.COLUMN_REPORT_DESCRIPTION,ReportDescription);

                    /*
                    Inserting new rows returning primary key value

                    */

                    long corruptId = corruptionDb.insert(CorruptionDataEntry.TABLE_CORRUPTION_DATA,
                            null,contentValues);
                        if(corruptId>0){
                            Toast.makeText(getApplicationContext(),"Thank you " +  UserName,
                                    Toast.LENGTH_SHORT).show();
                            Intent gotoCourtCases = new Intent(TextReportingActivity.this,MainActivity.class);
                            startActivity(gotoCourtCases);

                        }
                        else {
                            Toast.makeText(getApplicationContext(),"No data Inserted",Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(getApplicationContext(),"Fill all the first four inputs",Toast.LENGTH_SHORT).show();
                }



    }




    Intent intent = getIntent();
}
