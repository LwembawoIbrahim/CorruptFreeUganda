package com.ibralwembawogmail.corruptfreeuganda.FragmentClasses.criminal_cases;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibralwembawogmail.corruptfreeuganda.R;

public class ConcludedCasesFragment extends Fragment {
    public ConcludedCasesFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_concluded_cases);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.activity_concluded_cases,container,false);

        return view;
    }
}
