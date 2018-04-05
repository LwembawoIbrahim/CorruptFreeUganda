package com.ibralwembawogmail.corruptfreeuganda;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ibralwembawogmail.corruptfreeuganda.FragmentClasses.IggOfficesActivity;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionContract;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionDatabaseHelper;

public class AdminLogInActivity extends AppCompatActivity {
    private static final String LOG_TAG =  AdminLogInActivity.class.getSimpleName();
    String AdminUserName, AdminPassword;
    Button AdminLogInBtn;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_log_in);
        IggOfficesActivity iggOfficesActivity = new IggOfficesActivity();


    }

    public void LogIn(View view) {


        AdminLogInBtn = (Button) findViewById(R.id.AdminLogIn);
        AdminUserName = ((EditText) findViewById(R.id.AdminUserName)).getText().toString();
        AdminPassword = ((EditText) findViewById(R.id.AdminPassword)).getText().toString();
        if (AdminUserName.equals("I") && AdminPassword.equals("1")) {
            Intent gotoAddOffices = new Intent(this, AddOfficesActivity.class);
           // Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
            Log.e(LOG_TAG,"Why not displaying");

            startActivity(gotoAddOffices);
        } else {
            Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();

        }
    }

    private void deleteItem(String itemId) {
        CorruptionDatabaseHelper mHelper = new CorruptionDatabaseHelper(mContext);
        SQLiteDatabase db = mHelper.getWritableDatabase();
        String[] whereClauseValue = {itemId};
        String whereClause = CorruptionContract.CorruptionDataEntry._ID + " = ?";

        int result = db.delete(CorruptionContract.CorruptionDataEntry.TABLE_IGG_OFFICES, whereClause, whereClauseValue);

    }



}
