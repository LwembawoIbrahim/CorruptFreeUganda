package com.ibralwembawogmail.corruptfreeuganda.adapterClasses;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.ibralwembawogmail.corruptfreeuganda.DetailedActivity;
import com.ibralwembawogmail.corruptfreeuganda.FragmentClasses.CourtCasesActivity;
import com.ibralwembawogmail.corruptfreeuganda.R;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionContract.CorruptionDataEntry;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionDatabaseHelper;

/**
 * Created by LWEMBAWO on 3/12/2018.
 */

public class OnGoingCriminalCasesAdapter extends RecyclerView.Adapter<OnGoingCriminalCasesAdapter.MyViewHolder>{
 private Context mContext;
 //private List<OnGoingCriminalCases> criminalCasesList = new ArrayList<>();
    public  static final String extraTitle ="TileExtra";
    public static  final String extraDescription = "DescriptionExtra";
 Cursor crimeCursor;
 String tvOnGoingCaseCourtTitle;
    String tvGoingCriminalCaseDescription;



//A constructor for the OnGoingCaasesAdapter
    public  OnGoingCriminalCasesAdapter(Cursor cursor){
        crimeCursor = cursor;
        //this.criminalCasesList =casesList;

    }

    public static final class MyViewHolder  extends RecyclerView.ViewHolder {

        public TextView tvOnGoingCaseCourtTitle,tvOnGoingCourtCaseNo,
                tvGoingCriminalCaseDescription,tvShare,tvDetails;
        public MyViewHolder(final View cardView) {
            super(cardView);

            //These textViews references those on the card of OnGoingCriminalCourtCases
            tvOnGoingCaseCourtTitle = ((TextView)cardView.findViewById(R.id.txtCaseTitle));
            //tvOnGoingCourtCaseNo =((TextView)cardView.findViewById(R.id.txtCaseCourtNo));
            tvGoingCriminalCaseDescription = ((TextView)cardView.findViewById(R.id.txtCaseDescription));
            tvShare = ((TextView)cardView.findViewById(R.id.txtShare));
             tvShare.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {

                     Intent share = new Intent();
                     share.setAction(Intent.ACTION_SEND);
                     share.putExtra(Intent.EXTRA_TEXT,
                             tvGoingCriminalCaseDescription.getText());
                     share.setType("text/plain");
                     cardView.getContext().startActivity(share);



                 }
             });
             tvDetails = ((TextView)cardView.findViewById(R.id.txtDetails));
             tvDetails.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {

                     String titleDetails = tvDetails.getText().toString();
                     String Description = tvDetails.getText().toString();
                     Intent details = new Intent(cardView.getContext(),DetailedActivity.class);

                     details.putExtra(extraTitle,titleDetails);
                     details.putExtra(extraDescription,Description);
                     cardView.getContext().startActivity(details);

                 }
             });

        }
    }



    @Override
    public OnGoingCriminalCasesAdapter.MyViewHolder
    onCreateViewHolder(ViewGroup parent, int viewType) {

        return  new MyViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.cardongoingcriminalcases,parent,false));
       /* return new MyViewHolder((CardView) LayoutInflater.from(parent.getContext())
              .inflate(R.layout.cardongoingcriminalcases,parent,false));
                        //.inflate(R.layout.cardongoingcriminalcases,parent,false));*/


    }

    @Override
    public void onBindViewHolder(OnGoingCriminalCasesAdapter.MyViewHolder holder, int position) {

        //Here i bind the data to the textView on the card
        crimeCursor.moveToPosition(position);
        ContentValues contentValues = new ContentValues();
        String ReportTitle = crimeCursor.getString
                (crimeCursor.getColumnIndex(CorruptionDataEntry.COLUMN_REPORT_TITLE));
        String ReportDescription = crimeCursor.getString
                (crimeCursor.getColumnIndex(CorruptionDataEntry.COLUMN_REPORT_DESCRIPTION));

        holder.tvOnGoingCaseCourtTitle.setText(ReportTitle);
        holder.tvGoingCriminalCaseDescription.setText(ReportDescription);





    }

    @Override
    public int getItemCount() {
        if(crimeCursor!=null){
            return crimeCursor.getCount();
        }
        return  0;
    }
}
