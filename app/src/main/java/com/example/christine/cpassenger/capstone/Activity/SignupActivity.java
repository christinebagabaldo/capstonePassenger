package com.example.christine.cpassenger.capstone.Activity;

import android.app.Fragment;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.christine.cpassenger.R;
import com.example.christine.cpassenger.capstone.Model.LoginModel;
import com.example.christine.cpassenger.capstone.Model.SignupModel;
import com.example.christine.cpassenger.capstone.Service.APIServiceGenerator;
import com.example.christine.cpassenger.capstone.Service.APIServices;
import com.example.christine.cpassenger.databinding.ActivitySignupBinding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.logging.Logger;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.christine.cpassenger.capstone.AppController.apiService;
import static com.example.christine.cpassenger.capstone.AppController.hideKeyboard;

/**
 * Created by Christine on 1/27/2018.
 */

public class SignupActivity extends AppCompatActivity {
    private ActivitySignupBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup);

        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = binding.firstName.getText().toString();
                String lastname = binding.lastName.getText().toString();
                String email = binding.emailAdd.getText().toString();
                String password = binding.password.getText().toString();

                getSignUp(firstname, lastname, email, password);


                }
            });

        binding.password.setTypeface(Typeface.DEFAULT);
        binding.password.setTransformationMethod(new PasswordTransformationMethod());

        }

    private void getSignUp(String firstname, String lastname, String email, String password) {
        hideKeyboard(SignupActivity.this);
        binding.signup.setEnabled(false);
        binding.signup.setAlpha(0.4f);

        APIServiceGenerator.TOKEN = APIServiceGenerator.AUTHENTICATE_KEY;
        APIServices service=APIServiceGenerator.createService(APIServices.class);

        Call<SignupModel> signupUser = service.register(firstname, lastname, email, password);
        signupUser.enqueue(new Callback<SignupModel>() {
            @Override
            public void onResponse(Call<SignupModel> call, Response<SignupModel> response) {
                binding.signup.setEnabled(true);
                binding.signup.setAlpha(1f);
                SignupModel asd = response.body();
                try{
                    if ("true".equals(response.body().getStatus()))
                        Log.e("success", String.valueOf(asd));
                         Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();

                } catch (NullPointerException e){
                    //Log.e("Error", e.getMessage());
                    // new Gson().toJson(response.body().toString());
                    Log.e("error", String.valueOf(asd));
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SignupModel> call, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });

    }
        @Override
        public void onBackPressed() {
            super.onBackPressed();

            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            finish();

        }
}
