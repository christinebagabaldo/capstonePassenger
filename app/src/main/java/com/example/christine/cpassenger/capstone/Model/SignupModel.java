package com.example.christine.cpassenger.capstone.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Christine on 1/31/2018.
 */

public class SignupModel {
    private String headers;

    private null exception;

    private Original original;

    public String getHeaders ()
    {
        return headers;
    }

    public void setHeaders (String headers)
    {
        this.headers = headers;
    }

    public null getException ()
    {
        return exception;
    }

    public void setException (null exception)
    {
        this.exception = exception;
    }

    public Original getOriginal ()
    {
        return original;
    }

    public void setOriginal (Original original)
    {
        this.original = original;
    }

}
