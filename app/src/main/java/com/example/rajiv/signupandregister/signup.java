package com.example.rajiv.signupandregister;

import android.content.Intent;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


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
            register_api_class.getClient().login(tl2.getText().toString(), tl4.getText().toString(), new Callback<login_pojo>() {
                @Override
                public void success(login_pojo login_pojo, Response response) {
                    Log.i("retrosuccess",login_pojo.getstatus_code()+" "+login_pojo.getuser_name()+login_pojo.getuser_probe_id());
                    
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.i("retrofail1",error.getMessage());

                }
            });
            boolean login_status=true;
            if(login_status)
            {
                Intent i=new Intent(this,NavigationBar.class);
                startActivity(i);
            }
        }


    }

}