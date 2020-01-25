package com.NITT.ECEA.Probe20;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class success_reg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_reg);
    }
    public void sgninfn(View view)
    {
        Intent sgnin=new Intent(this,signup.class);
        startActivity(sgnin);
    }
}
