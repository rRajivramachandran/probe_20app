package com.example.rajiv.signupandregister;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.View;

public class custom_focus_change_listen implements View.OnFocusChangeListener{
    TextInputLayout m_lay;
    TextInputEditText m_txt;
    public custom_focus_change_listen(TextInputLayout lay,TextInputEditText txt)
    {
        m_lay=lay;
        m_txt=txt;

    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if(!b && m_txt.getEditableText().toString().isEmpty())
        {
            m_lay.setDefaultHintTextColor(ColorStateList.valueOf(Color.rgb(0,0,0)));
            Log.i("deb","1");
        }
        else if(b)
        {
            m_lay.setDefaultHintTextColor(ColorStateList.valueOf(Color.rgb(255,255,255)));
            Log.i("deb","2");
        }


    }
}