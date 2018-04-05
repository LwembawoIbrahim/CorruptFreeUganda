package com.ibralwembawogmail.corruptfreeuganda.adapterClasses;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ibralwembawogmail.corruptfreeuganda.R;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionContract;

public class CasesAdapter extends RecyclerView.Adapter<CasesAdapter.CaseView> {
    Cursor casesCursor;
    public CasesAdapter( Cursor cursor){
        casesCursor = cursor;
    }

    public static final class CaseView extends RecyclerView.ViewHolder{
        public TextView tvCaseTitle,tvCaseDescription,tvEditCase,tvDeleteCase;
        public ImageView cases_images;
        public CaseView(View cardView){
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

        }
    }
    @Override
    public CasesAdapter.CaseView onCreateViewHolder(ViewGroup parent, int viewType) {
        return
                new CaseView(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.cases_card,parent,false));
    }

    @Override
    public void onBindViewHolder(CasesAdapter.CaseView holder, int position) {
      casesCursor.moveToPosition(position);
      String caseTitle = casesCursor.getString(casesCursor.getColumnIndex
              (CorruptionContract.CorruptionDataEntry.COLUMN_CIVIL_REPORT_TITLE));
      String image_case = casesCursor.getString(casesCursor.getColumnIndex
              (CorruptionContract.CorruptionDataEntry.COLUMN_CIVIL_IMAGE_UPLOAD));

      String caseDescription = casesCursor.getString(casesCursor.getColumnIndex
              (CorruptionContract.CorruptionDataEntry.COLUMN_CIVIL_REPORT_DESCRIPTION));

      holder.tvCaseTitle.setText(caseTitle);
      //holder.cases_images.setImageURI();
      holder.tvCaseDescription.setText(caseDescription);

    }

    @Override
    public int getItemCount() {
        if(casesCursor!=null){
            return casesCursor.getCount();
        }
        return 0;
    }
}
