package com.example.rajiv.signupandregister.schedule;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rajiv.signupandregister.R;
import com.example.rajiv.signupandregister.register_api_class;
import com.example.rajiv.signupandregister.schedule_pojo;
import com.example.rajiv.signupandregister.maprecycleclicklistener;


/**
 * A simple {@link Fragment} subclass.
 */
public class Day0 extends Fragment implements maprecycleclicklistener {


    public Day0() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        register_api_class.getClient().getevents(new Callback<schedule_pojo>() {
            @Override
            public void success(schedule_pojo schedule_pojo, Response response) {
                Log.i("test","test");
                Log.i(schedule_pojo.getStatusCode()+" ",schedule_pojo.getMessage().get(4).getName()+schedule_pojo.getMessage().get(4).getEventDesc()+schedule_pojo.getMessage().get(4).getEventContact()+schedule_pojo.getMessage().get(4).getEventDate());
            }

            @Override
            public void failure(RetrofitError error) {
                 Log.i("failedretro",error.getMessage());
            }
        });
        return inflater.inflate(R.layout.fragment_day0, container, false);
    }

    @Override
    public void recyclelistitemclick(int pos) {

    }
}
