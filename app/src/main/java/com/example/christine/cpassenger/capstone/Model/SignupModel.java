package com.example.christine.cpassenger.capstone.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Christine on 1/31/2018.
 */

public class SignupModel {
    @SerializedName("message")
    private String message;

    @SerializedName("email")
    private String email;

    @SerializedName("status")
    private String status;

    @SerializedName("lastname")
    private String lastname;

    @SerializedName("firstname")
    private String firstname;

    public SignupModel(String message, String email, String status, String lastname, String firstname) {
        this.message = message;
        this.email = email;
        this.status = status;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public String getMessage ()
    {
        return message;
    }


    public String getEmail ()
    {
        return email;
    }


    public String getStatus ()
    {
        return status;
    }


    public String getLastname ()
    {
        return lastname;
    }



    public String getFirstname ()
    {
        return firstname;
    }


}
