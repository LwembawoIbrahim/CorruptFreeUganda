package com.ibralwembawogmail.corruptfreeuganda.FragmentClasses;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibralwembawogmail.corruptfreeuganda.R;

public class AppealedCasesActivity extends Fragment {
    public AppealedCasesActivity(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_appealed_cases);
    }
    public View onCreateView (LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.activity_appealed_cases,container,false);
        return view;
    }

}
