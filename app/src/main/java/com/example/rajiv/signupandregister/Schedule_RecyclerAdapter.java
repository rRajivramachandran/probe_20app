package com.example.rajiv.signupandregister;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Schedule_RecyclerAdapter extends RecyclerView.Adapter<Schedule_RecyclerAdapter.MyViewHolder> {

    private List<schedule_list_element> list;
    static Context context;

    public Schedule_RecyclerAdapter(List<schedule_list_element> list,Context context){
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.schedule_card_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        viewHolder.textView_event.setText(""+list.get(position).getName());
        viewHolder.textView_maxCount.setText("Max Count : "+list.get(position).getMaxCount());
        viewHolder.textView_eventDate.setText("Date : "+list.get(position).getEventDate());
        viewHolder.textView_eventDay.setText("Day : "+list.get(position).getEventDay());
        viewHolder.textView_startTime.setText("Start Time : " +list.get(position).getEventStartTime());
        viewHolder.textView_endTime.setText("End Time : "+list.get(position).getEventEndTime());
        viewHolder.textView_venue.setText("Venue : "+list.get(position).getEventVenue());
        viewHolder.textView_description.setText(""+list.get(position).getEventDesc());
        viewHolder.textView_createdAt.setText("Created At : "+list.get(position).getCreatedAt());
        viewHolder.textView_updatedAt.setText("Updated At : "+list.get(position).getUpdatedAt());
        viewHolder.textView_contact.setText("Contact : "+list.get(position).getEventContactName());
        viewHolder.getTextView_contactNumber.setText(""+list.get(position).getEventContact());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textView_event,textView_maxCount,textView_eventDate,textView_eventDay,textView_startTime
                ,textView_endTime,textView_venue,textView_description,textView_createdAt,textView_updatedAt
                ,textView_contact,getTextView_contactNumber;
        ImageView callImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_event = itemView.findViewById(R.id.event_name);
            textView_maxCount = itemView.findViewById(R.id.max_count);
            textView_eventDate = itemView.findViewById(R.id.event_date);
            textView_eventDay = itemView.findViewById(R.id.event_day);
            textView_startTime = itemView.findViewById(R.id.start_time);
            textView_endTime = itemView.findViewById(R.id.end_time);
            textView_venue = itemView.findViewById(R.id.venue);
            textView_description = itemView.findViewById(R.id.description);
            textView_createdAt = itemView.findViewById(R.id.created_at);
            textView_updatedAt = itemView.findViewById(R.id.updated_at);
            textView_contact = itemView.findViewById(R.id.contact);
            getTextView_contactNumber = itemView.findViewById(R.id.contact_number);

            callImage = itemView.findViewById(R.id.call);
            callImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            String phone = "9956815022";
            String s = "tel:"+phone;
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse(s));
            context.startActivity(intent);
        }
    }
}
