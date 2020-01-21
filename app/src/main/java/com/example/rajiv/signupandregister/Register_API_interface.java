package com.example.rajiv.signupandregister;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

public interface Register_API_interface {
    @FormUrlEncoded // annotation used in POST type requests
    @POST("/register")     // API's endpoints
    public void registration(@Field("name") String name,
                             @Field("email") String email,
                             @Field("password") String password,
                             @Field("gender") String logintype,
                             @Field("yos") String yos,
                             @Field("dept") String dept,
                             @Field("cn") String c_name,
                             @Field("phoneno") String phno,
                            // @Field("ac")
                             Callback<registration_pojo> callback);
    @FormUrlEncoded
    @POST("/login")     // API's endpoints
    public void login(@Field("email") String email,
                      @Field("password") String pwd,
                      Callback<login_pojo> callback);

    @GET("/events")
    public void getevents(
                      Callback<schedule_pojo> callback);
    @FormUrlEncoded
    @POST("/forgotPassword")
    public void forgotPassword(@Field("email") String email,Callback<login_pojo> callback);

}
