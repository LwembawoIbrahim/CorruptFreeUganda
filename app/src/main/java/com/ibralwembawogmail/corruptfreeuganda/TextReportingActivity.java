package com.ibralwembawogmail.corruptfreeuganda;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class TextReportingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_reporting);
        EditText uploadImage = ((EditText)findViewById(R.id.ed_report_upload_image));
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

                      }


     });

     EditText uploadVideo = ((EditText)findViewById(R.id.ed_report_upload_video));
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
             Intent videoPicker = new Intent(Intent.ACTION_PICK,MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
             startActivity(videoPicker);
         }


     });
        EditText audioSelector= ((EditText)findViewById(R.id.ed_report_upload_audio));
        audioSelector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent audioSelector = new Intent(Intent.ACTION_PICK,MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                startActivity(audioSelector);
            }
        });

    }



    Intent intent = getIntent();
}
