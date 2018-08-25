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
import android.widget.CheckBox;
import android.widget.RadioGroup;

import com.example.project.rollcallsys.jh.ui.TeacherMainActivity;
import com.example.project.rollcallsys.jh.utils.ShareUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_login;
    RadioGroup rg_character;
    TextInputLayout et_password;
    TextInputLayout et_username;
    String username;
    String password;
    ProgressDialog progressDialog;
    CheckBox cb_remember;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rg_character = findViewById(R.id.rg_character);
        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        et_password = findViewById(R.id.tl_psw);
        et_username = findViewById(R.id.tl_username);
        cb_remember = findViewById(R.id.cb_remember);

        rg_character.check(R.id.rb_teacher);

        getRemembered();
    }

    private void getRemembered() {
        int character = ShareUtils.getInt(this, "character", 0);
        if (character != 0) {
            if (character == 1)
                rg_character.check(R.id.rb_teacher);
            else
                rg_character.check(R.id.rb_student);
        }
        et_username.getEditText().setText(ShareUtils.getString(this, "username", ""));
        et_username.getEditText().setSelection(ShareUtils.getString(this, "username", "").length());
        et_password.getEditText().setText(ShareUtils.getString(this, "password", ""));
        et_password.getEditText().setSelection(ShareUtils.getString(this, "password", "").length());
        cb_remember.setChecked(ShareUtils.getBoolean(this, "remember", false));
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
                    progressDialog.dismiss();
                }
                setRemembered();
                break;
        }
    }

    private void setRemembered() {
        if (cb_remember.isChecked()) {
            if (rg_character.getCheckedRadioButtonId() == R.id.rb_teacher)
                ShareUtils.putInt(this, "character", 1);
            else
                ShareUtils.putInt(this, "character", 2);
            ShareUtils.putString(this, "username", username);
            ShareUtils.putString(this, "password", password);
            ShareUtils.putBoolean(this, "remember", true);
        }else {
            ShareUtils.putInt(this, "character", 0);
            ShareUtils.putString(this, "username", null);
            ShareUtils.putString(this, "password", null);
            ShareUtils.putBoolean(this, "remember", false);
        }
    }
}

