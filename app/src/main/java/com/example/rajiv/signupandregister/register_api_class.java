package com.example.rajiv.signupandregister;

import retrofit.RestAdapter;

public class register_api_class {
    public static Register_API_interface getClient() {

        // change your base URL
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("https://probe.org.in/20/api") //Set the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        Register_API_interface api = adapter.create(Register_API_interface.class);
        return api; // return the APIInterface object
    }

}
