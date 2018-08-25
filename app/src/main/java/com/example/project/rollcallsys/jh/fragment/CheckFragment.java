package com.example.project.rollcallsys.jh.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.project.rollcallsys.R;
import com.example.project.rollcallsys.jh.ui.DateDialog;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class CheckFragment extends Fragment implements View.OnClickListener {

    Button btn_search,btn_date;
    Spinner time, classes;
    Date mdate;

    public CheckFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_check, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {

        btn_search=getActivity().findViewById(R.id.btn_search);
        btn_search.setOnClickListener(this);
        btn_date=getActivity().findViewById(R.id.btn_date);
        btn_date.setOnClickListener(this);

        time = getActivity().findViewById(R.id.s_time);
        classes = getActivity().findViewById(R.id.s_classes);
        String[] arr = {"Class 1", "Class 2", "Class 3"};
        ArrayAdapter<String> classAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, arr);
        classes.setAdapter(classAdapter);
        String[] times = {"11:30-12:30", "22:30 - 23:30"};
        ArrayAdapter<String> timeAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, times);
        time.setAdapter(timeAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_search:

                break;
            case R.id.btn_date:
                new DateDialog(getActivity(), new DateDialog.OnCheckClickListener() {
                    @Override
                    public void getDate(int year, int month, int day) {
                        String string=year+"年"+month+"月"+day+"日";
                        btn_date.setText(string);
                    }
                }).show();
                break;
        }
    }
}
