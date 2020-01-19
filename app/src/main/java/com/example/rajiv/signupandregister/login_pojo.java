package com.example.rajiv.signupandregister;

import java.util.List;

public class login_pojo {
    private Integer status_code;
    private String user_name;
    private String user_probe_id;

    public Integer getstatus_code() {
        return status_code;
    }

    public void setstatus_code(Integer statusCode) {
        this.status_code = statusCode;
    }
    public String getuser_name() {
        return user_name;
    }

    public void setuser_name(String user_name) {
        this.user_name=user_name;
    }
    public String getuser_probe_id() {
        return user_probe_id;
    }

    public void setuser_probe_id(String user_probe_id) {
        this.user_probe_id=user_probe_id;
    }


}
