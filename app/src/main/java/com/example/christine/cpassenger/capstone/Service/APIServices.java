package com.example.christine.cpassenger.capstone.Service;

import com.example.christine.cpassenger.capstone.Model.LoginModel;
import com.example.christine.cpassenger.capstone.Model.SignupModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Christine on 1/29/2018.
 */

public interface APIServices {

    @FormUrlEncoded
    @POST("loginPassenger")
    Call<LoginModel> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("registerPassenger")
    Call<SignupModel> register(@Field("firstname") String firstname, @Field("lastname") String lastname, @Field("email") String email, @Field("password") String password);

}
