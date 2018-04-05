package com.ibralwembawogmail.corruptfreeuganda.adapterClasses;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ibralwembawogmail.corruptfreeuganda.R;

/**
 * Created by LWEMBAWO on 3/13/2018.
 */

public class ConcludedCriminalCasesAdapter extends RecyclerView.Adapter<ConcludedCriminalCasesAdapter.ViewHolder>{

    public ConcludedCriminalCasesAdapter(){

    }

    public  static final class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvConcludedCourtCaseTitle,
                tvConcludedCourtCaseDescription,tvCardId;

       // tvConcludedCourtCaseNo,

        public ViewHolder(CardView cardView) {
            super(cardView);

            tvConcludedCourtCaseTitle = (TextView)cardView.findViewById(R.id.txtConcludedCaseTitle);
            //tvConcludedCourtCaseNo = (TextView)cardView.findViewById(R.id.txtConcludedCaseCourtNo);
            tvConcludedCourtCaseDescription= (TextView)cardView.findViewById(R.id.txtConcludedCaseDescription);
            tvCardId = ((TextView)cardView.findViewById(R.id.txtCardId));



        }


    }



    @Override
    public ConcludedCriminalCasesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder((CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_concludedcriminalcases,parent,false));
    }

    @Override
    public void onBindViewHolder(ConcludedCriminalCasesAdapter.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

