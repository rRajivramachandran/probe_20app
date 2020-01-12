package com.example.rajiv.signupandregister;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.Arrays;

public class register extends AppCompatActivity {

    TextInputEditText name_txt,email_txt,pwd_txt,cnf_pwd_txt,yr_of_study_txt,dept_name_txt,clg_name_txt,ph_no_txt;
    TextInputLayout name_lay,email_lay,pwd_lay,cnf_pwd_lay,yr_of_study_lay,dept_name_lay,clg_name_lay,ph_no_lay;
    RadioGroup gender_txt,acco_txt;
    CheckBox male_txt,female_txt,other_txt,acco_y_txt,acco_n_txt;
    ArrayList<ArrayList<CheckBox>>  cboxs=new ArrayList<ArrayList<CheckBox>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name_txt = (TextInputEditText) findViewById(R.id.nametxt);
        email_txt = (TextInputEditText) findViewById(R.id.emailtext);
        pwd_txt = (TextInputEditText) findViewById(R.id.pwdtext);
        cnf_pwd_txt = (TextInputEditText) findViewById(R.id.cnfpwdtext);
        yr_of_study_txt = (TextInputEditText) findViewById(R.id.yearofstudytext);
        dept_name_txt = (TextInputEditText) findViewById(R.id.depttext);
        clg_name_txt = (TextInputEditText) findViewById(R.id.clgtext);
        ph_no_txt = (TextInputEditText) findViewById(R.id.phnotext);
        male_txt = (CheckBox) findViewById(R.id.genbox1);
        female_txt = (CheckBox) findViewById(R.id.genbox2);
        other_txt = (CheckBox) findViewById(R.id.genbox3);
        acco_y_txt = (CheckBox) findViewById(R.id.accobox1);
        acco_n_txt = (CheckBox) findViewById(R.id.accobox2);
        gender_txt = (RadioGroup) findViewById(R.id.genderradgrp);
        acco_txt = (RadioGroup) findViewById(R.id.accordgrp);

        name_lay = (TextInputLayout) findViewById(R.id.namelayout);
        email_lay = (TextInputLayout) findViewById(R.id.emaillayout);
        pwd_lay = (TextInputLayout) findViewById(R.id.pwdlayout);
        cnf_pwd_lay = (TextInputLayout) findViewById(R.id.cnfpwdlayout);
        yr_of_study_lay = (TextInputLayout) findViewById(R.id.yearofstudylayout);
        dept_name_lay = (TextInputLayout) findViewById(R.id.deptlayout);
        clg_name_lay = (TextInputLayout) findViewById(R.id.clglayout);
        ph_no_lay = (TextInputLayout) findViewById(R.id.phnolayout);

        name_txt.setOnFocusChangeListener(new custom_focus_change_listen(name_lay, name_txt));
        email_txt.setOnFocusChangeListener(new custom_focus_change_listen(email_lay, email_txt));
        pwd_txt.setOnFocusChangeListener(new custom_focus_change_listen(pwd_lay, pwd_txt));
        cnf_pwd_txt.setOnFocusChangeListener(new custom_focus_change_listen(cnf_pwd_lay,cnf_pwd_txt));
        yr_of_study_txt.setOnFocusChangeListener(new custom_focus_change_listen(yr_of_study_lay,yr_of_study_txt));
        dept_name_txt.setOnFocusChangeListener(new custom_focus_change_listen(dept_name_lay,dept_name_txt));
        clg_name_txt.setOnFocusChangeListener(new custom_focus_change_listen(clg_name_lay,clg_name_txt));
        ph_no_txt.setOnFocusChangeListener(new custom_focus_change_listen(ph_no_lay,ph_no_txt));

        name_txt.addTextChangedListener(new clr_err(name_lay,name_txt));
        email_txt.addTextChangedListener(new clr_err(email_lay,email_txt));
        pwd_txt.addTextChangedListener(new clr_err(pwd_lay,pwd_txt));
        cnf_pwd_txt.addTextChangedListener(new clr_err(cnf_pwd_lay,cnf_pwd_txt));
        yr_of_study_txt.addTextChangedListener(new clr_err(yr_of_study_lay,yr_of_study_txt));
        dept_name_txt.addTextChangedListener(new clr_err(dept_name_lay,dept_name_txt));
        clg_name_txt.addTextChangedListener(new clr_err(clg_name_lay,clg_name_txt));
        ph_no_txt.addTextChangedListener(new clr_err(ph_no_lay,ph_no_txt));

        cboxs.add(new ArrayList<CheckBox> (Arrays.asList(new CheckBox[] {male_txt,female_txt,other_txt})));
        cboxs.add(new ArrayList<CheckBox> (Arrays.asList(new CheckBox[] {acco_y_txt,acco_n_txt})));

        for(ArrayList<CheckBox> cb:cboxs)
        {
            for(CheckBox cx:cb)
            {
                ArrayList<CheckBox> cblis=new ArrayList<CheckBox>(cb);
                cblis.remove(cx);
                cx.setOnCheckedChangeListener(new checkboxlistener(cblis,cx));

            }
        }


    }



    public class checkboxlistener implements CompoundButton.OnCheckedChangeListener{
        ArrayList<CheckBox> boxes;
        CheckBox m_curbox;
        public checkboxlistener(ArrayList<CheckBox> p,CheckBox cur_box)
        {
            boxes=p;
            m_curbox=cur_box;
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(b)
            {
                for(CheckBox box:boxes)
                {
                    box.setChecked(false);
                    box.setError(null);
                }
                m_curbox.setError(null);
            }

        }
    }
    public void registerfn(View view)
    {
        TextInputLayout[] lays={name_lay,email_lay,pwd_lay,cnf_pwd_lay,yr_of_study_lay,dept_name_lay,clg_name_lay,ph_no_lay};
        TextInputEditText[] txts={name_txt,email_txt,pwd_txt,cnf_pwd_txt,yr_of_study_txt,dept_name_txt,clg_name_txt,ph_no_txt};
        //CheckBox[] ch1={male_txt,female_txt,other_txt},ch2={acco_n_txt,acco_y_txt};
        boolean p=true;
        for(int i=0;i<lays.length;i++)
            if(!checkemptyfield(txts[i]))
                p=false;
        for(ArrayList<CheckBox> box: cboxs)
            if(!checkischecked(box))
                p=false;
        if(!pwd_txt.getEditableText().toString().equals(cnf_pwd_txt.getEditableText().toString()))
        {
            cnf_pwd_txt.setError("Password and Confirm pwd dont match");
            p=false;
        }
        if(p)
        {
            Intent success_reg=new Intent(this,success_reg.class);
            startActivity(success_reg);
        }

    }
    public boolean checkemptyfield(TextInputEditText txt)
    {
        boolean k=true;
        if(txt.getEditableText().toString().isEmpty())
        {
            txt.setError("This field is compulsory");
            txt.setBackgroundResource(R.drawable.round_corner_button_error);
            k=false;
        }
        return k;
    }
    public boolean checkischecked(ArrayList<CheckBox> p)
    {
        boolean any=false;
        for(CheckBox box: p)
            if(box.isChecked())
            {
                any=true;
                break;
            }
        if(!any)
        {
           p.get(p.size()-1).setError("Compulsory question");

        }
        return any;
    }
}
