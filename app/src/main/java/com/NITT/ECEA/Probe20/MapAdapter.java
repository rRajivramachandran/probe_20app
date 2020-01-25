package com.NITT.ECEA.Probe20;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MapAdapter extends RecyclerView.Adapter<MapAdapter.MyViewHolder>  {
    private String[] mDataset;
    private maprecycleclicklistener rcl;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView t_view;
        public View view;
        public MyViewHolder(View v) {
            super(v);
            t_view = (TextView) v.findViewById(R.id.loc_text);
            view=v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MapAdapter(String[] myDataset, maprecycleclicklistener mp) {
        mDataset = myDataset;
        rcl=mp;
    }

    // Create new views (invoked by the layout manager)


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.location_holder, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;

    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.t_view.setText(mDataset[position]);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rcl.recyclelistitemclick(position);
                Log.i("position",position+" ");
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }


}

