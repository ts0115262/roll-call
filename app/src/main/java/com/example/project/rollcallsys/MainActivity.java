package com.example.project.rollcallsys;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.project.rollcallsys.jh.ui.TeacherMainActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_login;
    RadioGroup rg_character;
    TextInputLayout et_password;
    TextInputLayout et_username;
    String username;
    String password;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rg_character = findViewById(R.id.rg_character);
        btn_login = findViewById(R.id.btn_login);
        et_password = findViewById(R.id.tl_psw);
        et_username = findViewById(R.id.tl_username);


        rg_character.check(R.id.rb_teacher);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("");
                progressDialog.setCancelable(false);
                progressDialog.setMessage("正在登陆...");
                progressDialog.show();

                int character = rg_character.getCheckedRadioButtonId();
                username = et_username.getEditText().getText().toString();
                password = et_password.getEditText().getText().toString();

                Log.d("TAG", "username=" + username);
                if (username.equals("Wrong")) {
                    progressDialog.cancel();
                    TextInputLayout textInputLayout = findViewById(R.id.tl_username);
                    textInputLayout.setErrorEnabled(true);
                    textInputLayout.setError("请输入正确的用户名和密码");
                }
                if (username.equals("teacher")) {
                    startActivity(new Intent(this, TeacherMainActivity.class));
                }
        }

    }
}

