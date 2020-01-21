package com.example.rajiv.signupandregister;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

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

        id_lay=(TextInputLayout) findViewById(R.id.id_lay);
        txts= new TextInputEditText[]{id_txt};
        lays =new TextInputLayout[] {id_lay};

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
            register_api_class.getClient().forgotPassword(id_txt.getText().toString(),new Callback<login_pojo>() {
                @Override
                public void success(login_pojo login_pojo, Response response) {

                        Log.d("rr",login_pojo.getstatus_code()+"");
                        Toast t= Toast.makeText(forgetpwd.this,login_pojo.getMessage(),Toast.LENGTH_LONG);
                        t.setGravity(Gravity.CENTER,0,0);
                        t.show();
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d("rr",error.getMessage()+"");
                    Toast t= Toast.makeText(forgetpwd.this,error.getMessage(),Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER,0,0);
                    t.show();

                }
            });
        }

    }
}
