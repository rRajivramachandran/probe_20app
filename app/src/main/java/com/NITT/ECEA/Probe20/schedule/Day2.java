package com.NITT.ECEA.Probe20.schedule;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.NITT.ECEA.Probe20.R;
import com.NITT.ECEA.Probe20.Schedule_RecyclerAdapter;
import com.NITT.ECEA.Probe20.maprecycleclicklistener;
import com.NITT.ECEA.Probe20.register_api_class;
import com.NITT.ECEA.Probe20.schedule_list_element;
import com.NITT.ECEA.Probe20.schedule_pojo;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;

/**
 * A simple {@link Fragment} subclass.
 */
public class Day2 extends Fragment implements maprecycleclicklistener {

    String permission_str[]={Manifest.permission.CALL_PHONE};
    RecyclerView rc;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    List<schedule_list_element> day1_lis=new ArrayList<>();
    ProgressBar prog;
    TextView txt;
    public Day2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View RootView=inflater.inflate(R.layout.fragment_day1, container, false);
        prog=(ProgressBar) RootView.findViewById(R.id.prog1);
        txt=RootView.findViewById(R.id.txt_none);
        rc=(RecyclerView) RootView.findViewById(R.id.rec_cards1);
        layoutManager = new LinearLayoutManager(getContext());
        rc.setLayoutManager(layoutManager);
        rc.setVisibility(View.INVISIBLE);
        txt.setVisibility(GONE);
        // specify an adapter (see also next example)
        adapter = new Schedule_RecyclerAdapter(day1_lis,this);
        rc.setAdapter(adapter);

        register_api_class.getClient().getevents(new Callback<schedule_pojo>() {
            @Override
            public void success(schedule_pojo schedule_pojo, Response response) {
                Log.i("test","test");
                Day1.filtered_list(2,schedule_pojo.getMessage(),day1_lis);
                //Log.i("pojo",day1_lis.get(0).getName());
                //day0_lis.add(schedule_pojo.getMessage().get(4));
                //day0_lis.add(schedule_pojo.getMessage().get(5));
                //day0_lis.add(schedule_pojo.getMessage().get(3));
                adapter.notifyDataSetChanged();
                prog.setVisibility(GONE);
                if(day1_lis.size()==0)
                {
                    txt.setVisibility(View.VISIBLE);
                }
                rc.setVisibility(View.VISIBLE);

            }

            @Override
            public void failure(RetrofitError error) {
                Log.i("failedretro",error.getMessage());
                prog.setVisibility(View.GONE);
                if(checkconnectivity()) {
                    Toast t = Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG);
                    t.setGravity(Gravity.CENTER, 0, 0);
                    t.show();
                }
            }
        });


        return RootView;
    }

    @Override
    public void recyclelistitemclick(int pos) {String phone = day1_lis.get(pos).getEventContact().toString();
        String s = "tel:"+phone;


        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse(s));
        if(ContextCompat.checkSelfPermission(getContext(),Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED)
            startActivity(intent);
        else
        {
            requestPermissions(permission_str,2000);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {

        if(ContextCompat.checkSelfPermission(getContext(),Manifest.permission.CALL_PHONE)!=PackageManager.PERMISSION_GRANTED)
        {
            Toast call_perm_denied=Toast.makeText(getContext(),"Cannot Make calls to points of contact without granting permisions",Toast.LENGTH_LONG);
            call_perm_denied.setGravity(Gravity.CENTER,0,0);
            call_perm_denied.show();

        }
        else
        {
            Toast call_perm_denied=Toast.makeText(getContext(),"Now use the call icon to talk to points of contacts",Toast.LENGTH_LONG);
            call_perm_denied.setGravity(Gravity.CENTER,0,0);
            call_perm_denied.show();

        }

    }
    public boolean checkconnectivity()
    {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(getContext().CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if(! (activeNetworkInfo != null && activeNetworkInfo.isConnected()))
        {
            Toast nw=Toast.makeText(getContext(),"App requires internet connectivity",Toast.LENGTH_SHORT);
            nw.setGravity(Gravity.CENTER,0,0);
            nw.show();
        }
        return (activeNetworkInfo != null && activeNetworkInfo.isConnected());
    }

}
