package com.ibralwembawogmail.corruptfreeuganda.FragmentClasses;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibralwembawogmail.corruptfreeuganda.OnGoingCriminalCases;
import com.ibralwembawogmail.corruptfreeuganda.adapterClasses.OnGoingCriminalCasesAdapter;
import com.ibralwembawogmail.corruptfreeuganda.R;

import java.util.ArrayList;
import java.util.List;

public class OnGoingCasesActivity extends Fragment{

    RecyclerView  OnGoingCriminalCasesRecyclerView;
    OnGoingCriminalCasesAdapter criminalCasesAdapter;
    List<OnGoingCriminalCases> criminalCasesList = new ArrayList<>();
    public OnGoingCasesActivity(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_on_going_cases);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        final View view = inflater.inflate(R.layout.activity_on_going_cases,container,false);
  OnGoingCriminalCasesRecyclerView = (RecyclerView)view.findViewById(R.id.OnGoingCriminalCasesRecyclerView);
 OnGoingCriminalCasesRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        OnGoingCriminalCasesRecyclerView.setAdapter(criminalCasesAdapter);
  criminalCasesAdapter = new OnGoingCriminalCasesAdapter(getContext(),criminalCasesList);

    return view;



    }





}
