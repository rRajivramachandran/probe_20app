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
    @SerializedName("max_count")
    @Expose
    private Integer maxCount;
    @SerializedName("event_start_time")
    @Expose
    private Object eventStartTime;
    @SerializedName("event_end_time")
    @Expose
    private Object eventEndTime;
    @SerializedName("event_date")
    @Expose
    private Object eventDate;
    @SerializedName("event_venue")
    @Expose
    private Object eventVenue;
    @SerializedName("event_desc")
    @Expose
    private Object eventDesc;
    @SerializedName("event_contact_name")
    @Expose
    private Object eventContactName;
    @SerializedName("event_contact")
    @Expose
    private Object eventContact;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("event_day")
    @Expose
    private Integer eventDay;

    public Integer getId() {
        return id;
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

    public Integer getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
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
