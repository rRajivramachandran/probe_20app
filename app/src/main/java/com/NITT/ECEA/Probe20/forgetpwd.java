package com.NITT.ECEA.Probe20;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class forgetpwd extends AppCompatActivity {
    TextInputEditText id_txt,pwd_txt,cnfpwd_txt;
    TextInputLayout id_lay,pwd_lay,cnfpwd_lay;
    TextInputEditText[] txts={};
    TextInputLayout[] lays={};
    Button change_button;
    ProgressBar prog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_forgetpwd);
        change_button=(Button) findViewById(R.id.changebutton);
        prog =(ProgressBar) findViewById(R.id.progbar);
        id_txt=(TextInputEditText) findViewById(R.id.id_txt);

        id_lay=(TextInputLayout) findViewById(R.id.id_lay);
        txts= new TextInputEditText[]{id_txt};
        lays =new TextInputLayout[] {id_lay};
        prog.setVisibility(View.INVISIBLE);
        for(int i=0;i<txts.length;i++)
        {
            txts[i].setOnFocusChangeListener(new custom_focus_change_listen(lays[i],txts[i]));
            txts[i].addTextChangedListener(new clr_err(lays[i],txts[i]));
        }

    }
    public void forgetpwdentry(View view)
    {
        boolean valid_fields=true;
        for(int i=0;i< txts.length;i++)
            if(txts[i].getEditableText().toString().isEmpty())
            {
                txts[i].setError("Compulsory field");
                valid_fields=false;
                txts[i].setBackgroundResource(R.drawable.round_corner_button_error);
            }

        if(valid_fields)
        {
            prog.setVisibility(View.VISIBLE);
            change_button.setVisibility(View.INVISIBLE);
            register_api_class.getClient().forgotPassword(id_txt.getText().toString(),new Callback<login_pojo>() {
                @Override
                public void success(login_pojo login_pojo, Response response) {

                        Log.d("rr",login_pojo.getstatus_code()+"");
                        Toast t= Toast.makeText(forgetpwd.this,login_pojo.getMessage(),Toast.LENGTH_LONG);
                        t.setGravity(Gravity.CENTER,0,0);
                        t.show();
                        if(login_pojo.getstatus_code()==200)
                            finish();
                    prog.setVisibility(View.INVISIBLE);
                    change_button.setVisibility(View.VISIBLE);
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d("rr",error.getMessage()+"");
                    if(checkconnectivity()) {
                        Toast t = Toast.makeText(forgetpwd.this, error.getMessage(), Toast.LENGTH_LONG);
                        t.setGravity(Gravity.CENTER, 0, 0);
                        t.show();
                    }
                    prog.setVisibility(View.INVISIBLE);
                    change_button.setVisibility(View.VISIBLE);

                }
            });
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
}
