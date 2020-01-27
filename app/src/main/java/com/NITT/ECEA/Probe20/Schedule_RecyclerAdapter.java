package com.NITT.ECEA.Probe20;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static java.sql.Types.NULL;

public class Schedule_RecyclerAdapter extends RecyclerView.Adapter<Schedule_RecyclerAdapter.MyViewHolder> {

    private List<schedule_list_element> list;
    maprecycleclicklistener rcl;

    public Schedule_RecyclerAdapter(List<schedule_list_element> list,maprecycleclicklistener rcl){
        this.list = list;

        this.rcl=rcl;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_card_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, final int position) {
        viewHolder.textView_event.setText(""+list.get(position).getName());
        //viewHolder.textView_maxCount.setText("Max Team Size : "+list.get(position).getMaxCount());
        //viewHolder.textView_eventDate.setText("Date : "+list.get(position).getEventDate());
        //viewHolder.textView_eventDay.setText("Day : "+list.get(position).getEventDay());
        viewHolder.textView_endTime.setText("End Time : "+list.get(position).getEventEndTime().toString());

        if(list.get(position).gettype().toString().equals("workshop"))
        {
            viewHolder.lin_lay.setBackgroundResource(R.drawable.group18);
            viewHolder.textView_event.setTextColor(Color.rgb(255,255,255));
            viewHolder.textView_endTime.setTextColor(Color.rgb(255,255,255));
            viewHolder.textView_startTime.setTextColor(Color.rgb(255,255,255));
            viewHolder.textView_venue.setTextColor(Color.rgb(255,255,255));
            viewHolder.textView_description.setTextColor(Color.rgb(255,255,255));
            viewHolder.textView_contact.setTextColor(Color.rgb(255,255,255));
            viewHolder.getTextView_contactNumber.setTextColor(Color.rgb(255,255,255));
            viewHolder.callImage.setBackgroundResource(R.drawable.phonews);
        }
        if(list.get(position).getEventDay()==-1) {
            viewHolder.textView_startTime.setVisibility(View.GONE);
            viewHolder.textView_venue.setVisibility(View.GONE);
            viewHolder.textView_endTime.setVisibility(View.GONE);
        }
        viewHolder.textView_startTime.setText("Start Time : " +list.get(position).getEventStartTime());
        //viewHolder.textView_endTime.setText("End Time : "+list.get(position).getEventEndTime());
        Log.i(""+ list.get(position).getEventVenue(),"trial");
        if(list.get(position).getEventVenue()==null)
            viewHolder.textView_venue.setText("Venue : To be decided");
        else
        viewHolder.textView_venue.setText("Venue : "+list.get(position).getEventVenue());
        viewHolder.textView_description.setText(""+list.get(position).getEventDesc());
        //viewHolder.textView_createdAt.setText("Created At : "+list.get(position).getCreatedAt());
        //viewHolder.textView_updatedAt.setText("Updated At : "+list.get(position).getUpdatedAt());
        viewHolder.textView_contact.setText("Contact : "+list.get(position).getEventContactName());
        viewHolder.getTextView_contactNumber.setText(""+list.get(position).getEventContact());
        viewHolder.callImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rcl.recyclelistitemclick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textView_event,textView_maxCount,textView_startTime
                ,textView_endTime,textView_venue,textView_description,textView_endtime,
                textView_contact,getTextView_contactNumber;
        ImageView callImage;
        LinearLayout lin_lay;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_event = itemView.findViewById(R.id.event_name);
            //textView_maxCount = itemView.findViewById(R.id.max_count);
            textView_endTime=itemView.findViewById(R.id.end_time);
            textView_startTime = itemView.findViewById(R.id.start_time);
            lin_lay = itemView.findViewById(R.id.lin_lay);
            textView_venue = itemView.findViewById(R.id.venue);
            textView_description = itemView.findViewById(R.id.description);

            textView_contact = itemView.findViewById(R.id.contact);
            getTextView_contactNumber = itemView.findViewById(R.id.contact_number);

            callImage = itemView.findViewById(R.id.call);
            //callImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
