package com.NITT.ECEA.Probe20;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    String name,probe_id,college,dept;
    TextView name_v,probe_id_v,college_v,dept_v;
    public ProfileFragment(String name,String probe_id,String college,String dept) {
        // Required empty public constructor
        this.name=name;
        this.probe_id=probe_id;
        this.college=college;
        this.dept=dept;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_profile, container, false);
        probe_id_v=v.findViewById(R.id.probe_idtxt);
        college_v=v.findViewById(R.id.collegetxt);
        name_v=v.findViewById(R.id.nametxt);
        dept_v=v.findViewById(R.id.departmenttxt);
        probe_id_v.setText(probe_id);
        college_v.setText(college);
        name_v.setText(name);
        dept_v.setText(dept);
        return v;
    }

}
