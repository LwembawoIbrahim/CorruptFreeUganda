package com.ibralwembawogmail.corruptfreeuganda.adapterClasses;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ibralwembawogmail.corruptfreeuganda.R;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionContract.CorruptionDataEntry;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionDatabaseHelper;

/**
 * Created by LWEMBAWO on 3/25/2018.
 */

public class IggOfficesAdapter extends RecyclerView.Adapter<IggOfficesAdapter.ViewHolder> {
    Cursor officeCursor;
    Context mContext;

    public IggOfficesAdapter(Cursor cursor) {
        officeCursor = cursor;

    }

    //creating a view holder class

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView
                tvOfficeName, tvOfficeAddress, tvOfficeBoxNumber, tvTelephoneNumber, tvOfficeEmail;

        public ViewHolder(final View cardView) {
            super(cardView);
            tvOfficeName = (TextView) cardView.findViewById(R.id.igg_offices);
            tvOfficeAddress = (TextView) cardView.findViewById(R.id.OfficeAddress);
            tvOfficeBoxNumber = (TextView) cardView.findViewById(R.id.BoxNumber);
            tvTelephoneNumber = (TextView) cardView.findViewById(R.id.OfficeTelephoneNumber);
            tvOfficeEmail = (TextView) cardView.findViewById(R.id.OfficeEmail);
            /*cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent callIntent  = new Intent
                            (Intent.ACTION_DIAL, Uri.parse("tel:"+tvTelephoneNumber.getText()));
                    cardView.getContext().startActivity(callIntent);

                }
            });*/

            tvTelephoneNumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String phoneCall = tvTelephoneNumber.getText().toString();
                    Intent callIntent = new Intent
                            (Intent.ACTION_DIAL, Uri.parse("tel:" + phoneCall));
                    cardView.getContext().startActivity(callIntent);

                }
            });
            cardView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    String id = view.getTag().toString();
                    Log.d("Lwem", "The method worked and has tag: " + id);

                    Toast.makeText(cardView.getContext(), "You hav long Pressed the card", Toast.LENGTH_SHORT).show();


                    return false;
                }
            });

            /*cardView.onKeyLongPress(){
            }*/


        }
    }

    @Override
    public IggOfficesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new
                ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardiggoffices, parent, false));
    }

    @Override
    public void onBindViewHolder(IggOfficesAdapter.ViewHolder holder, int position) {

        officeCursor.moveToPosition(position);

        String offices = officeCursor.getString(officeCursor.
                getColumnIndex(CorruptionDataEntry.COLUMN_OFFICE_NAME));
        String address = officeCursor.getString(officeCursor.
                getColumnIndex(CorruptionDataEntry.COLUMN_OFFICE_ADDRESS));
        String boxNumber = officeCursor.getString(officeCursor.
                getColumnIndex(CorruptionDataEntry.COLUMN_OFFICE_BOX_NUMBER));
        String telephone = officeCursor.getString(officeCursor.
                getColumnIndex(CorruptionDataEntry.COLUMN_OFFICE_NUMBER));
        String email = officeCursor.getString(officeCursor.
                getColumnIndex(CorruptionDataEntry.COLUMN_OFFICE_EMAIL));

        holder.tvOfficeName.setText(offices);
        holder.tvOfficeAddress.setText(address);
        holder.tvOfficeBoxNumber.setText(boxNumber);
        holder.tvTelephoneNumber.setText(telephone);
        holder.tvOfficeEmail.setText(email);
        holder.itemView.setTag("1");


    }

    @Override
    public int getItemCount() {
        if (officeCursor != null) {
            return officeCursor.getCount();
        } else {
            return 0;
        }

    }

    private void deleteItem(String itemId) {
        CorruptionDatabaseHelper mHelper = new CorruptionDatabaseHelper(mContext);
        SQLiteDatabase db = mHelper.getWritableDatabase();
        String[] whereClauseValue = {itemId};
        String whereClause = CorruptionDataEntry._ID + " = ?";

        int result = db.delete(CorruptionDataEntry.TABLE_IGG_OFFICES, whereClause, whereClauseValue);
    }


}
