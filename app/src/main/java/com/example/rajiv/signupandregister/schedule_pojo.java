package com.example.rajiv.signupandregister;

import android.os.Message;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class schedule_pojo {
    @SerializedName("status_code")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private List<schedule_list_element> message = null;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public List<schedule_list_element> getMessage() {
        return message;
    }

    public void setMessage(List<schedule_list_element> message) {
        this.message = message;
    }
}
