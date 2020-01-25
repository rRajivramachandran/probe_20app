package com.NITT.ECEA.Probe20;

import android.Manifest;
import android.content.Context;
import android.content.Intent;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
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
        String [] perms={Manifest.permission.ACCESS_NETWORK_STATE};
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_DENIED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(perms, 2500);
            }
        }

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
            //Intent i=new Intent(signup.this,NavigationBar.class);

            //i.putExtra("u_name","rr");
            //i.putExtra("probe_id","test");
            //startActivity(i);
            register_api_class.getClient().login(tl2.getText().toString(), tl4.getText().toString(), new Callback<login_pojo>() {
                @Override
                public void success(login_pojo login_pojo, Response response) {

                    Log.i("retrosuccess",login_pojo.getstatus_code()+":: "+login_pojo.getMessage());
                    if(login_pojo.getstatus_code()==200)
                    {
                        Log.i("retrosuccess",login_pojo.getMessage());
                        u_name=login_pojo.getMessage().split(":",4)[0];
                        probe_id=login_pojo.getMessage().split(":",4)[1];
                        String clg=login_pojo.getMessage().split(":",4)[2];
                        String dept=login_pojo.getMessage().split(":",4)[3];

                        //  login_status=true;
                        Intent i=new Intent(signup.this,NavigationBar.class);

                        i.putExtra("u_name",u_name);
                        i.putExtra("probe_id",probe_id);
                        i.putExtra("clg",clg);
                        i.putExtra("dept",dept);
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
                    if(checkconnectivity()) {
                        Log.i("retrofail1", error.getMessage());
                        Toast t = Toast.makeText(signup.this, error.getMessage(), Toast.LENGTH_LONG);
                        t.setGravity(Gravity.CENTER, 0, 0);
                        //Log.i("retrosuccess"+login_pojo.getMessage()+" "+signUpResponse.getStatus());
                        t.show();
                    }
                    but.setVisibility(View.VISIBLE);
                    spinner.setVisibility(View.INVISIBLE);
                    //login_status=false;
                    //Remove these four lines

                }
            });


        }


    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {

        if(ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_NETWORK_STATE)==PackageManager.PERMISSION_GRANTED)
        {


          checkconnectivity();

        }



        else
        {
            Toast map_perm_denied=Toast.makeText(this,"Cannot proceed without permission",Toast.LENGTH_SHORT);
            map_perm_denied.setGravity(Gravity.CENTER,0,0);
            map_perm_denied.show();

        }

    }
    public boolean checkconnectivity()
    {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
       if(! (activeNetworkInfo != null && activeNetworkInfo.isConnected()))
       {
           Toast nw=Toast.makeText(this,"App requires internet connectivity",Toast.LENGTH_SHORT);
           nw.setGravity(Gravity.CENTER,0,0);
           nw.show();
       }
        return (activeNetworkInfo != null && activeNetworkInfo.isConnected());
    }
    @Override
    public void onBackPressed()
    {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }

}