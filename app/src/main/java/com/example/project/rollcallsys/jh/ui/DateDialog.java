package com.example.project.rollcallsys.jh.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import com.example.project.rollcallsys.R;

import java.util.Calendar;


public class DateDialog extends Dialog implements View.OnClickListener {

    Button btn_check;
    Context mContext;
    CalendarView cv_date;
    OnCheckClickListener mListener;
    int mYear=Calendar.getInstance().get(Calendar.YEAR),mMonth=Calendar.getInstance().get(Calendar.MONTH)+1,mDay=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

    public DateDialog(@NonNull Context context, OnCheckClickListener listener) {
        super(context);
        mContext = context;
        mListener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_dialog);
        cv_date = findViewById(R.id.cv_date);
        cv_date.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                mYear=year;
                mMonth = month+1;
                mDay=dayOfMonth;
            }
        });

        btn_check = findViewById(R.id.btn_check);
        btn_check.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_check:
                mListener.getDate(mYear,mMonth,mDay);
                dismiss();
                break;
        }
    }

    public interface OnCheckClickListener {
        void getDate(int year,int month,int day);
    }
}
