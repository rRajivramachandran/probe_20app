package com.example.rajiv.signupandregister.schedule;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rajiv.signupandregister.R;
import com.example.rajiv.signupandregister.Schedule_RecyclerAdapter;
import com.example.rajiv.signupandregister.register_api_class;
import com.example.rajiv.signupandregister.schedule_list_element;
import com.example.rajiv.signupandregister.schedule_pojo;
import com.example.rajiv.signupandregister.maprecycleclicklistener;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Day0 extends Fragment implements maprecycleclicklistener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    List<schedule_list_element> list;
    Schedule_RecyclerAdapter recyclerAdapter;

    public Day0() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_day0, container, false);

        recyclerView = view.findViewById(R.id.schedule_recycler_view);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        register_api_class.getClient().getevents(new Callback<schedule_pojo>() {
            @Override
            public void success(schedule_pojo schedule_pojo, Response response) {
                Log.i("test","test");
                Log.i(schedule_pojo.getStatusCode()+" ",schedule_pojo.getMessage().get(4).getName()+schedule_pojo.getMessage().get(4).getEventDesc()+schedule_pojo.getMessage().get(4).getEventContact()+schedule_pojo.getMessage().get(4).getEventDate());

                list = schedule_pojo.getMessage();
                Log.i("message",""+list.size());
                //Toast.makeText(getContext(),""+list.size(),Toast.LENGTH_SHORT).show();
                recyclerAdapter = new Schedule_RecyclerAdapter(schedule_pojo.getMessage(),getContext());
                recyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void failure(RetrofitError error) {
                 Log.i("failedretro",error.getMessage());
            }
        });
        return view;
    }

    @Override
    public void recyclelistitemclick(int pos) {

    }
}
