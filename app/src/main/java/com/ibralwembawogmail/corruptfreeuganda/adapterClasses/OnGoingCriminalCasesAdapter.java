package com.ibralwembawogmail.corruptfreeuganda.adapterClasses;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ibralwembawogmail.corruptfreeuganda.OnGoingCriminalCases;
import com.ibralwembawogmail.corruptfreeuganda.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LWEMBAWO on 3/12/2018.
 */

public class OnGoingCriminalCasesAdapter extends RecyclerView.Adapter<OnGoingCriminalCasesAdapter.MyViewHolder>{
 private Context context;
 private List<OnGoingCriminalCases> criminalCasesList = new ArrayList<>();


//A constructor for the OnGoingCaasesAdapter
    public  OnGoingCriminalCasesAdapter(Context context,List<OnGoingCriminalCases>casesList){
        this.context = context;
        this.criminalCasesList =casesList;

    }

    public static final class MyViewHolder  extends RecyclerView.ViewHolder {

        public TextView tvOnGoingCaseCourtTitle,tvOnGoingCourtCaseNo,tvGoingCriminalCaseDescription;
        public MyViewHolder(CardView cardView) {
            super(cardView);
            //These textViews references those on the card of OnGoingCriminalCourtCases
            tvOnGoingCaseCourtTitle = ((TextView)cardView.findViewById(R.id.txtCaseTitle));
            tvOnGoingCourtCaseNo =((TextView)cardView.findViewById(R.id.txtCaseCourtNo));
            tvGoingCriminalCaseDescription = ((TextView)cardView.findViewById(R.id.txtCaseDescription));

        }
    }



    @Override
    public OnGoingCriminalCasesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return
                new MyViewHolder((CardView) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.cardongoingcriminalcases,parent,false));
    }

    @Override
    public void onBindViewHolder(OnGoingCriminalCasesAdapter.MyViewHolder holder, int position) {

        //Here i bind the data to the textView on the card





    }

    @Override
    public int getItemCount() {
        return
                0;
    }
}
