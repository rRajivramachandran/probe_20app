package com.example.rajiv.signupandregister;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;



public class signup extends AppCompatActivity {
    TextInputEditText tl2,tl4;
    TextInputLayout tl1,tl3;
    Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //getSupportActionBar().setHomeButtonEnabled(true);

        tl1=(TextInputLayout) findViewById(R.id.prb1);
        tl2=(TextInputEditText) findViewById(R.id.prb2);
        tl3=(TextInputLayout) findViewById(R.id.prb3);
        tl4=(TextInputEditText) findViewById(R.id.prb4);

        tl2.setOnFocusChangeListener(new custom_focus_change_listen(tl1,tl2));
        tl4.setOnFocusChangeListener(new custom_focus_change_listen(tl3,tl4));

        tl2.addTextChangedListener(new clr_err(tl1,tl2));
        tl4.addTextChangedListener(new clr_err(tl3,tl4));
    }
    public void pwdfgtfn(View view)
    {
        Intent fgt_pwd=new Intent(this,forgetpwd.class);
        startActivity(fgt_pwd);
    }
    public void regfn(View view)
    {
        Intent gotoreg=new Intent(this,register.class);
        startActivity(gotoreg);
    }
    public void signinfn(View view)
    {
        Log.i("knc","csmk");
        //Call to API to check user id and password

        if(tl2.getText().toString().isEmpty())
        {
            tl2.setError("Compulsory Field");
            tl2.setBackgroundResource(R.drawable.round_corner_button_error);
        }
        else if(tl4.getText().toString().isEmpty())
        {
            tl4.setError("Compulsory Field");
            tl4.setBackgroundResource(R.drawable.round_corner_button_error);
        }
        else
        {
            boolean login_status=true;
            if(login_status)
            {
                Intent i=new Intent(this,NavigationBar.class);
                startActivity(i);
            }
        }

    }

}