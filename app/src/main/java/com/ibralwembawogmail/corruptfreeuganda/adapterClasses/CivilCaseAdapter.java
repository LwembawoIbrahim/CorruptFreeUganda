package com.ibralwembawogmail.corruptfreeuganda.adapterClasses;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ibralwembawogmail.corruptfreeuganda.DetailedActivity;
import com.ibralwembawogmail.corruptfreeuganda.R;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionContract;

public class CivilCaseAdapter extends RecyclerView.Adapter<CivilCaseAdapter.ViewHolder> {
    Cursor civilCusor;
    String civilTitle;
    String civilDescription;

    public CivilCaseAdapter(Cursor cursor){
        civilCusor=cursor;

    }

    public  static final class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_civil_Title,tv_civil_description,tv_civilDetails;
        ImageView image_civil_share;

        public ViewHolder( final View cardView){
            super(cardView);

            tv_civil_Title = (TextView)cardView.findViewById(R.id.txtCivilCaseTitle);
            tv_civil_description =(TextView)cardView.findViewById(R.id.txtCivilCaseDescription);
            image_civil_share = (ImageView) cardView.findViewById(R.id.imgCivilShare);
            tv_civilDetails =(TextView)cardView.findViewById(R.id.txtCivilDetails);

            image_civil_share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent share = new Intent();
                    share.setAction(Intent.ACTION_SEND);
                    share.putExtra(Intent.EXTRA_TEXT,
                            tv_civil_description.getText());
                    share.setType("text/plain");
                    cardView.getContext().startActivity(share);

                }
            });

            tv_civilDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent goToDetails = new Intent(cardView.getContext(), DetailedActivity.class);
                   String civilTitle = tv_civilDetails.getText().toString();
                   String civilDescription = tv_civilDetails.getText().toString();

                   goToDetails.putExtra("civilTitle",tv_civil_Title.getText());
                  goToDetails.putExtra("civilDescription",tv_civil_description.getText());
                  cardView.getContext().startActivity(goToDetails);

                }
            });
        }
    }
    @Override
    public CivilCaseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.civil_case_card_view,parent,false));
    }

    @Override
    public void onBindViewHolder(CivilCaseAdapter.ViewHolder holder, int position) {
        civilCusor.moveToPosition(position);

        ContentValues contentValues = new ContentValues();

        String civil_report_title = civilCusor.getString(civilCusor.getColumnIndex
                (CorruptionContract.CorruptionDataEntry.COLUMN_CIVIL_REPORT_TITLE));

        String civil_report_description = civilCusor.getString(civilCusor.getColumnIndex
                (CorruptionContract.CorruptionDataEntry.COLUMN_CIVIL_REPORT_DESCRIPTION));

        holder.tv_civil_Title.setText(civil_report_title);
        holder.tv_civil_description.setText(civil_report_description);

    }

    @Override
    public int getItemCount()
    {
        if(civilCusor!=null){
            return civilCusor.getCount();
        }
        return 0;

    }



}
