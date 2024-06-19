package com.example.login_page3;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class sign_up extends AppCompatActivity {


    TextView sign_to_login;
    Button signip_btn;
    EditText sign_email,sign_password,sign_repassword;
    ConstraintLayout top_main;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        sign_to_login = findViewById(R.id.sign_to_login);
        top_main = findViewById(R.id.sign_top_main);
        signip_btn = findViewById(R.id.signip_btn);
        sign_email = findViewById(R.id.sign_email);
        sign_password = findViewById(R.id.sign_password);
        sign_repassword = findViewById(R.id.sign_repassword);

        db = new DBHelper(this);


        AnimationDrawable animationDrawable = (AnimationDrawable) top_main.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();


        sign_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(sign_up.this,log_in.class);
                startActivity(i1);

            }
        });

        signip_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eml = sign_email.getText().toString();
                String pas = sign_password.getText().toString();
                String repas = sign_repassword.getText().toString();

                if(eml.isEmpty() || pas.isEmpty() || repas.isEmpty()){
                    Toast.makeText(sign_up.this,"All Fields are Empty..",Toast.LENGTH_LONG).show();
                }
                else
                {
                    if(pas.equals(repas))
                    {
                        Boolean checkemail = db.checkemail(eml);
                        if (checkemail==false)
                        {
                            Boolean insert  = db.insertData(eml,pas);
                            if(insert==true)
                            {
                                Toast.makeText(sign_up.this, "Registered Successfully Please Log In here..", Toast.LENGTH_LONG).show();
                                Intent i1 = new Intent(sign_up.this,log_in.class);
                                startActivity(i1);
                            }
                            else {
                                Toast.makeText(sign_up.this, "Registeration Failed..", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(sign_up.this, "User Already Exists! Please Sign In", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(sign_up.this, "Password Not Matching ", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}