package com.example.project.rollcallsys.jh.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.project.rollcallsys.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CheckFragment extends Fragment {

    Spinner time,classes;


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

        time=getActivity().findViewById(R.id.s_time);
        classes=getActivity().findViewById(R.id.s_classes);
        String[] arr = {"Class 1","Class 2","Class 3" };
        ArrayAdapter<String> classAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,arr);
        classes.setAdapter(classAdapter);
        String[] times ={"11:30-12:30","22:30 - 23:30"};
        ArrayAdapter<String> timeAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,times);
        time.setAdapter(timeAdapter);

    }
}
