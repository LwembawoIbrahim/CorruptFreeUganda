package com.ibralwembawogmail.corruptfreeuganda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogInActivity extends AppCompatActivity {
    String AdminUserName,AdminPassword;
    Button AdminLogInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_log_in);


    }

    public void LogIn(View view){
        AdminLogInBtn = (Button)findViewById(R.id.AdminLogIn);
        AdminUserName = ((EditText)findViewById(R.id.AdminUserName)).getText().toString();
        AdminPassword = ((EditText)findViewById(R.id.AdminPassword)).getText().toString();
        if(AdminUserName.equals("igg")&&AdminPassword.equals("123")) {
            Intent gotoAddOffices = new Intent(this,AddOfficesActivity.class);
            Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_SHORT).show();
            startActivity(gotoAddOffices);
        }
        else {
            Toast.makeText(getApplicationContext(),"Wrong Cridentials",Toast.LENGTH_SHORT).show();

        }
    }
}
