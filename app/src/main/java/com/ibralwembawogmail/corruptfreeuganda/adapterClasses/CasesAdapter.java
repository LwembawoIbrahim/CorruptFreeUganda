package com.ibralwembawogmail.corruptfreeuganda.adapterClasses;

import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ibralwembawogmail.corruptfreeuganda.CasesActivity;
import com.ibralwembawogmail.corruptfreeuganda.MainActivity;
import com.ibralwembawogmail.corruptfreeuganda.R;
import com.ibralwembawogmail.corruptfreeuganda.TextReportingActivity;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionContract;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionContract.CorruptionDataEntry;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionDatabaseHelper;
import com.squareup.picasso.Picasso;

public class CasesAdapter extends RecyclerView.Adapter<CasesAdapter.CaseView> {
    Cursor casesCursor;
    Context caseContext;
    public CasesAdapter( Cursor cursor){

      casesCursor = cursor;
    }

    public static final class CaseView extends RecyclerView.ViewHolder{
        public TextView tvCaseTitle,tvCaseDescription,tvEditCase,tvDeleteCase,tvMove;
        public ImageView cases_images;
        public CaseView(final View cardView){
            super(cardView);
            tvCaseTitle = cardView.findViewById(R.id.txtCasesTitle);
            tvCaseDescription = cardView.findViewById(R.id.txtCasesDescription);
            cases_images = cardView.findViewById(R.id.img_cases);
            tvDeleteCase= cardView.findViewById(R.id.txtDeleteCase);
            tvDeleteCase.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            tvEditCase = cardView.findViewById(R.id.txtEditCase);
            tvEditCase.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            tvMove = cardView.findViewById(R.id.txtMoveCaseTo);
            tvMove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                }
            });

        }
    }
    @Override
    public CasesAdapter.CaseView onCreateViewHolder(ViewGroup parent, int viewType) {
        return
                new CaseView(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.cases_card,parent,false));
    }

    @Override
    public void onBindViewHolder(final CasesAdapter.CaseView holder, final int position) {

        casesCursor.moveToPosition(position);


        final String caseTitle = casesCursor.getString(casesCursor.getColumnIndex
              (CorruptionContract.CorruptionDataEntry.COLUMN_CIVIL_REPORT_TITLE));
      String image_case = casesCursor.getString(casesCursor.getColumnIndex
              (CorruptionContract.CorruptionDataEntry.COLUMN_CIVIL_IMAGE_UPLOAD));

      final String caseDescription = casesCursor.getString(casesCursor.getColumnIndex
              (CorruptionContract.CorruptionDataEntry.COLUMN_CIVIL_REPORT_DESCRIPTION));

      holder.tvCaseTitle.setText(caseTitle);
      //holder.cases_images.setImageURI();
      holder.tvCaseDescription.setText(caseDescription);

       holder.tvMove.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {





                         }
       });
    }

    @Override
    public int getItemCount() {
        if(casesCursor!=null){
            return casesCursor.getCount();
        }
        return 0;
    }
}
