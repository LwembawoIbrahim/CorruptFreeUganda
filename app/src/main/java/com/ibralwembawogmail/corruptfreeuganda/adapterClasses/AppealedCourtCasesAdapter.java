package com.ibralwembawogmail.corruptfreeuganda.adapterClasses;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ibralwembawogmail.corruptfreeuganda.R;

/**
 * Created by LWEMBAWO on 3/13/2018.
 */

public class AppealedCourtCasesAdapter extends RecyclerView.Adapter<AppealedCourtCasesAdapter.ViewHolder> {
    public AppealedCourtCasesAdapter() {

    }

    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvAppealedCaseTitle, tvAppealedCasesCourtNo, tvAppealedCourCaseDescription;

        public ViewHolder(CardView cardView) {

            super(cardView);

            tvAppealedCaseTitle =(TextView)cardView.findViewById(R.id.txtAppealedCaseTitle);
            tvAppealedCasesCourtNo =(TextView)cardView.findViewById(R.id.txtAppealedCaseCourtNo);
            tvAppealedCourCaseDescription = (TextView)cardView.findViewById(R.id.txtAppealedCaseDescription);

        }
    }

    @Override
    public AppealedCourtCasesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return
                new ViewHolder((CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_appealed_criminal_cases,parent,false));
    }

    @Override
    public void onBindViewHolder(AppealedCourtCasesAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
