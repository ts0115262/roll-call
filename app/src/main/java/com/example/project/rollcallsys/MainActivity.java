package com.example.project.rollcallsys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.project.rollcallsys.inerfaces.student.LoginAsStudent;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_login;
    RadioGroup rg_character;
    EditText et_passowrd;
    EditText et_username;
    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg_character = findViewById(R.id.rg_character);
        btn_login = findViewById(R.id.btn_login);
        et_passowrd = findViewById(R.id.et_psw);
        et_username = findViewById(R.id.et_psw);


        rg_character.check(R.id.rb_teacher);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:




                login();
        }
    }

    private void login() {
        int character = rg_character.getCheckedRadioButtonId();
        username = et_username.getText().toString();
        password = et_passowrd.getText().toString();
        if (character == R.id.rb_student) {
            LoginAsStudent loginAsStudent = new LoginAsStudent() {
                @Override
                public boolean login(String userName, String password) {
                    return true;
                }
            };
            if (loginAsStudent.login(username, password)){

            }
        }
    }
}
