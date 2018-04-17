package com.ibralwembawogmail.corruptfreeuganda;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionContract.CorruptionDataEntry;
import com.ibralwembawogmail.corruptfreeuganda.databaseclasses.CorruptionDatabaseHelper;

public class AddOfficesActivity extends AppCompatActivity {
    String officeName,OfficeAddress,officeBoxNumber,OfficeTelephoneNumber,OfficeEmailAddress,
    officeFaxNumber;
    Button submitOfficeDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_offices);
        submitOfficeDetails = (Button)findViewById(R.id.submitOfficeDetails);
        submitOfficeDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                officeName =((EditText)findViewById(R.id.ed_Office_name)).getText().toString();
                OfficeAddress = ((EditText)findViewById(R.id.ed_office_address)).getText().toString();
                officeBoxNumber=((EditText)findViewById(R.id.ed_box_number)).getText().toString();
                OfficeTelephoneNumber =((EditText)findViewById(R.id.ed_telephone_number)).getText().toString();
                OfficeEmailAddress =((EditText)findViewById(R.id.ed_office_email)).getText().toString();
                officeFaxNumber   =((EditText)findViewById(R.id.ed_office_fax_number)).getText().toString();
                if(!officeName.equals("")
                        &&!OfficeAddress.equals("")
                        &&!officeBoxNumber.equals("")
                        &&!OfficeTelephoneNumber.equals("")
                        &&!OfficeEmailAddress.equals("")
                        &&!officeFaxNumber.equals("")){

                    //Access the tha database
                    CorruptionDatabaseHelper iggOffice = new CorruptionDatabaseHelper(AddOfficesActivity.this);
                    SQLiteDatabase officeDb = iggOffice.getWritableDatabase();
                    //Creating new value

                    ContentValues officeValues = new ContentValues();
                    //inserting values to the igg database

                    officeValues.put(CorruptionDataEntry.COLUMN_OFFICE_NAME,officeName);
                    officeValues.put(CorruptionDataEntry.COLUMN_OFFICE_ADDRESS,OfficeAddress);
                    officeValues.put(CorruptionDataEntry.COLUMN_OFFICE_BOX_NUMBER,officeBoxNumber);
                    officeValues.put(CorruptionDataEntry.COLUMN_OFFICE_NUMBER,OfficeTelephoneNumber);
                    officeValues.put(CorruptionDataEntry.COLUMN_OFFICE_EMAIL,OfficeEmailAddress);

                    //Inserting new rows returning the id

                    long addOfficeId = officeDb.insert(CorruptionDataEntry.TABLE_IGG_OFFICES,null,officeValues);
                    if(addOfficeId>0){
                        Toast.makeText(getApplicationContext(),"Office Added",Toast.LENGTH_SHORT).show();
                        Intent mainActivity = new Intent(AddOfficesActivity.this,MainActivity.class);
                        startActivity(mainActivity);

                    }
                    else {
                        Toast.makeText(getApplicationContext(),"No data Inserted",Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(getApplicationContext(),"Please insert data",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }






    Intent intent = getIntent();
}
