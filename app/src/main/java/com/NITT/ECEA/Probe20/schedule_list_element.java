package com.NITT.ECEA.Probe20;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class schedule_list_element {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("start_time")
    @Expose
    private Object eventStartTime;
    @SerializedName("end_time")
    @Expose
    private Object eventEndTime;
    @SerializedName("date")
    @Expose
    private Object eventDate;
    @SerializedName("venue")
    @Expose
    private Object eventVenue;
    @SerializedName("desc")
    @Expose
    private Object eventDesc;
    @SerializedName("contact_name")
    @Expose
    private Object eventContactName;
    @SerializedName("contact")
    @Expose
    private Object eventContact;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("day")
    @Expose
    private Integer eventDay;

    public Integer getId() {
        return id;
    }
    public String gettype(){return type;}
    public void settype(String t){
        this.type=t;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Object getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(Object eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public Object getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(Object eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public Object getEventDate() {
        return eventDate;
    }

    public void setEventDate(Object eventDate) {
        this.eventDate = eventDate;
    }

    public Object getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(Object eventVenue) {
        this.eventVenue = eventVenue;
    }

    public Object getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(Object eventDesc) {
        this.eventDesc = eventDesc;
    }

    public Object getEventContactName() {
        return eventContactName;
    }

    public void setEventContactName(Object eventContactName) {
        this.eventContactName = eventContactName;
    }

    public Object getEventContact() {
        return eventContact;
    }

    public void setEventContact(Object eventContact) {
        this.eventContact = eventContact;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getEventDay() {
        return eventDay;
    }

    public void setEventDay(Integer eventDay) {
        this.eventDay = eventDay;
    }

}
