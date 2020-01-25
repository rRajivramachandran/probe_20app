package com.NITT.ECEA.Probe20;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutUsFragment extends Fragment {


    public AboutUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_about_us, container, false);
        v.findViewById(R.id.aboutUS_Img1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.facebook.com/Probe.NITT/"));
                startActivity(viewIntent);
            }
        });
        v.findViewById(R.id.aboutUS_Img2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.linkedin.com/company/probe-nit-trichy/"));
                startActivity(viewIntent);
            }
        });
        v.findViewById(R.id.aboutUS_Img3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://www.instagram.com/probe.nitt/"));
                startActivity(viewIntent);

            }
        });
        v.findViewById(R.id.aboutUS_Img4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://probe.org.in/"));
                startActivity(viewIntent);
            }
        });

        return v;

    }

}

