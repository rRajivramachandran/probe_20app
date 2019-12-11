package com.example.rajiv.signupandregister;

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
        tl1=(TextInputLayout) findViewById(R.id.prb1);
        tl2=(TextInputEditText) findViewById(R.id.prb2);
        tl3=(TextInputLayout) findViewById(R.id.prb3);
        tl4=(TextInputEditText) findViewById(R.id.prb4);
        tl2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().isEmpty())
                    tl1.setDefaultHintTextColor(ColorStateList.valueOf(Color.rgb(0,0,0)));
                else
                    tl1.setDefaultHintTextColor(ColorStateList.valueOf(Color.rgb(255,255,255)));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        tl4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.toString().isEmpty())
                    tl3.setDefaultHintTextColor(ColorStateList.valueOf(Color.rgb(0,0,0)));
                else
                    tl3.setDefaultHintTextColor(ColorStateList.valueOf(Color.rgb(255,255,255)));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }
    public void pwdfgtfn(View view)
    {
        Log.i("ck","dcnk");
    }
    public void regfn(View view)
    {
        Log.i("knc","csmk");
    }
    public void signinfn(View view)
    {
        Log.i("knc","csmk");
    }

}
