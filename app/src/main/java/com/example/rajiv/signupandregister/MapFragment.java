package com.example.rajiv.signupandregister;



import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements maprecycleclicklistener{
    MapView mMapView;
    RecyclerView rec_view;
    TextView req_loc_sel;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    String[] mylocations = {"Zircon C","Opal(girls)","Aquamarine B","Zircon B","Zircon A","Amber b","Nitt hospital",
            "Amber A","Jasper Hostel","Aquamarine A","EEE Auditorium","ECE department","A2 Hall","A12 hall","A13 hall",
            "Barn hall","Security office","Orion"};

    ArrayList<LatLng> lat_lng_lis=new ArrayList<>();
    ArrayList<Marker> marker_lis=new ArrayList<>();
    //ArrayList markerPoints= new ArrayList();
    private GoogleMap googleMap;
    private static final String[] location_PERMS = {
            Manifest.permission.ACCESS_FINE_LOCATION};
    private static final String[] INTERNET_PERMS = {
            Manifest.permission.INTERNET};
    private static final int Location_REQUEST_code = 1337;
    private static final int Internet_REQUEST_code = 1338;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);
        req_loc_sel=(TextView) rootView.findViewById(R.id.request_loc_press);
        mMapView = (MapView) rootView.findViewById(R.id.mapView);

        mMapView.onCreate(savedInstanceState);
        rec_view=(RecyclerView) rootView.findViewById(R.id.rec_lay);
        layoutManager = new LinearLayoutManager(getContext());
        rec_view.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MapAdapter(mylocations,this);
        rec_view.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        lat_lng_lis.add(new LatLng(10.766860,78.816602));
        lat_lng_lis.add(new LatLng(10.757381,78.822030));
        lat_lng_lis.add(new LatLng(10.768574,78.818466));
        lat_lng_lis.add(new LatLng(10.766799,78.817683));
        lat_lng_lis.add(new LatLng(10.765913,78.817671));
        lat_lng_lis.add(new LatLng(10.768307,78.813636));
        lat_lng_lis.add(new LatLng(10.762830,78.818944));
        lat_lng_lis.add(new LatLng(10.767603,78.813636));
        lat_lng_lis.add(new LatLng(10.769048,78.8184162));
        // Jasper?
        lat_lng_lis.add(new LatLng(10.768574,78.818466));
        lat_lng_lis.add(new LatLng(10.759206,78.814682));
        lat_lng_lis.add(new LatLng(10.760713,78.816920));
        lat_lng_lis.add(new LatLng(10.759004,78.812880));
        lat_lng_lis.add(new LatLng(10.758944,78.813590));
        lat_lng_lis.add(new LatLng(10.759021,78.813620));
        lat_lng_lis.add(new LatLng(10.759315,78.813209));
        lat_lng_lis.add(new LatLng(10.757763,78.813066));
        lat_lng_lis.add(new LatLng(10.759680,78.810932));
        req_loc_sel.getBackground().setAlpha(45);







        rec_view.setVisibility(View.GONE);
        req_loc_sel.setVisibility(View.GONE);

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED) {
            requestPermissions(location_PERMS, Location_REQUEST_code);
        }
        else if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.INTERNET) == PackageManager.PERMISSION_DENIED){
            requestPermissions(INTERNET_PERMS, Internet_REQUEST_code);
        }
        else
            mapfn();




        return rootView;

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {

            if(ContextCompat.checkSelfPermission(getContext(),Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED&&ContextCompat.checkSelfPermission(getContext(),Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED)
                mapfn();


            else
            {
                Toast map_perm_denied=Toast.makeText(getContext(),"Cannot use this feature unless granted permission and internet is ON",Toast.LENGTH_SHORT);
                map_perm_denied.setGravity(Gravity.CENTER,0,0);
                map_perm_denied.show();

            }

    }
    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    public void mapfn()
    {
            mMapView.onResume();
            Log.i("here","inmaps");
            mMapView.getMapAsync(new

    OnMapReadyCallback() {
        @Override
        public void onMapReady (GoogleMap mMap){


            googleMap=mMap;
            mMap.setMyLocationEnabled(true);
            rec_view.setVisibility(View.VISIBLE);
            req_loc_sel.setVisibility(View.VISIBLE);
            googleMap.setBuildingsEnabled(true);






        }
    });
}

    public void setmarker(int pos)
    {
        googleMap.clear();
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lat_lng_lis.get(pos), 15));

        googleMap.addMarker(new MarkerOptions().position(lat_lng_lis.get(pos)).title(mylocations[pos]));
    }
    @Override
    public void recyclelistitemclick(int pos) {
        setmarker(pos);

    }
}
