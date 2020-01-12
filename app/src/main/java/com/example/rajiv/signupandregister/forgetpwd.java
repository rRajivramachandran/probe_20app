package com.example.rajiv.signupandregister;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class forgetpwd extends AppCompatActivity {
    TextInputEditText id_txt,pwd_txt,cnfpwd_txt;
    TextInputLayout id_lay,pwd_lay,cnfpwd_lay;
    TextInputEditText[] txts={};
    TextInputLayout[] lays={};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpwd);
        id_txt=(TextInputEditText) findViewById(R.id.id_txt);
        pwd_txt=(TextInputEditText) findViewById(R.id.pwd_text);
        cnfpwd_txt=(TextInputEditText) findViewById(R.id.cnfpwd_text);
        id_lay=(TextInputLayout) findViewById(R.id.id_lay);
        pwd_lay=(TextInputLayout) findViewById(R.id.pwd_layout);
        cnfpwd_lay=(TextInputLayout) findViewById(R.id.cnfpwd_layout);
        txts= new TextInputEditText[]{id_txt, pwd_txt, cnfpwd_txt};
        lays =new TextInputLayout[] {id_lay,pwd_lay,cnfpwd_lay};

        for(int i=0;i<txts.length;i++)
        {
            txts[i].setOnFocusChangeListener(new custom_focus_change_listen(lays[i],txts[i]));
            txts[i].addTextChangedListener(new clr_err(lays[i],txts[i]));
        }

    }
    public void forgetpwdentry(View view)
    {
        for(int i=0;i< txts.length;i++)
            if(txts[i].getEditableText().toString().isEmpty())
            {
                txts[i].setError("Compulsory field");
                txts[i].setBackgroundResource(R.drawable.round_corner_button_error);
            }
        if(!pwd_txt.getEditableText().toString().equals(cnfpwd_txt.getEditableText().toString()))
        {
            cnfpwd_txt.setError("Password and Confirm pwd dont match");
        }

    }
}
