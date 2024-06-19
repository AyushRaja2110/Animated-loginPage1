package com.example.login_page3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class log_in extends AppCompatActivity {


    ConstraintLayout top_main;
    TextView log_register;
    Button login_btn;
    EditText login_email,login_password;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        top_main = findViewById(R.id.log_top_main);
        log_register = findViewById(R.id.log_register);
        login_btn  =findViewById(R.id.login_btn);
        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);

        db = new DBHelper(this);


        AnimationDrawable animationDrawable = (AnimationDrawable) top_main.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();

        log_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(log_in.this,sign_up.class);
                startActivity(i1);

            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String eml = login_email.getText().toString();
                String pas = login_password.getText().toString();

                if (login_email.equals("") | login_password.equals(""))
                {
                    Toast.makeText(log_in.this, "All fields are empty", Toast.LENGTH_SHORT).show();
                }

                else if(login_email.getText().toString().equals("ayush21@gmail.com") && login_password.getText().toString().equals("2222"))
                {
                    Intent i2 = new Intent(log_in.this,Admin.class);
                    startActivity(i2);
                }

                else if (eml.isEmpty() || pas.isEmpty())
                {
                    Toast.makeText(log_in.this,"Please Enter All the Fields",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Boolean checkemlpass = db.checkemailpassword(eml,pas);
                    if (checkemlpass==true){
                        Toast.makeText(log_in.this, "Log in Successfully", Toast.LENGTH_SHORT).show();
                        Intent i1 = new Intent(log_in.this,MainActivity.class);
                        startActivity(i1);
                    }
                    else {
                        Toast.makeText(log_in.this, "Invalid.. Please Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}