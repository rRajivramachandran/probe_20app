package com.example.rajiv.signupandregister;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;

public class clr_err implements TextWatcher {
    TextInputLayout m_lay;
    TextInputEditText m_txt;
    public clr_err(TextInputLayout lay,TextInputEditText txt)
    {
        m_lay=lay;
        m_txt=txt;
    }
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if(!charSequence.toString().isEmpty())
        {
            m_lay.setError(null);
            m_txt.setBackgroundResource(R.drawable.roundcornerbutton);

        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}

