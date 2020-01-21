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
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;


public class signup extends AppCompatActivity {
    TextInputEditText tl2,tl4;
    TextInputLayout tl1,tl3;
    Button but;
    boolean login_status;
    ProgressBar spinner;
    String u_name,probe_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //getSupportActionBar().setHomeButtonEnabled(true);
        spinner =(ProgressBar) findViewById(R.id.wait_spinner);
        tl1=(TextInputLayout) findViewById(R.id.prb1);
        tl2=(TextInputEditText) findViewById(R.id.prb2);
        tl3=(TextInputLayout) findViewById(R.id.prb3);
        tl4=(TextInputEditText) findViewById(R.id.prb4);
        but=(Button) findViewById(R.id.signinbutton);
        tl2.setOnFocusChangeListener(new custom_focus_change_listen(tl1,tl2));
        tl4.setOnFocusChangeListener(new custom_focus_change_listen(tl3,tl4));
        tl2.setText("");
        tl4.setText("");
        tl2.addTextChangedListener(new clr_err(tl1,tl2));
        tl4.addTextChangedListener(new clr_err(tl3,tl4));
        spinner.setVisibility(View.INVISIBLE);


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
            spinner.setVisibility(View.VISIBLE);
            but.setVisibility(View.INVISIBLE);
            //login_status=false;
            //remove next 4 lines
           // Intent i=new Intent(signup.this,NavigationBar.class);

            //i.putExtra("u_name","dd");
            //i.putExtra("probe_id","fie");
            //startActivity(i);
            register_api_class.getClient().login(tl2.getText().toString(), tl4.getText().toString(), new Callback<login_pojo>() {
                @Override
                public void success(login_pojo login_pojo, Response response) {

                    Log.i("retrosuccess",login_pojo.getstatus_code()+":: "+login_pojo.getMessage());
                    if(login_pojo.getstatus_code()==200)
                    {
                        Log.i("retrosuccess",login_pojo.getMessage());
                        u_name=login_pojo.getMessage().split(":",2)[0];
                        probe_id=login_pojo.getMessage().split(":",2)[1];
                      //  login_status=true;
                        Intent i=new Intent(signup.this,NavigationBar.class);

                        i.putExtra("u_name",u_name);
                        i.putExtra("probe_id",probe_id);
                        startActivity(i);
                        //Log.i("f",u_name+"d"+probe_id);
                    }
                    else
                    {
                        Toast t = Toast.makeText(signup.this,login_pojo.getMessage(),Toast.LENGTH_LONG);
                        t.setGravity(Gravity.CENTER,0,0);
                        //Log.i("retrosuccess"+login_pojo.getMessage()+" "+signUpResponse.getStatus());
                        t.show();
                        //login_status=false;
                    }
                    but.setVisibility(View.VISIBLE);
                    spinner.setVisibility(View.INVISIBLE);
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.i("retrofail1",error.getMessage());
                    but.setVisibility(View.VISIBLE);
                    spinner.setVisibility(View.INVISIBLE);
                    //login_status=false;
                    //Remove these four lines
                    Intent i=new Intent(signup.this,NavigationBar.class);

                    i.putExtra("u_name","rr");
                    i.putExtra("probe_id","test");
                    startActivity(i);
                }
            });


        }


    }

}