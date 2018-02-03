package com.example.christine.cpassenger.capstone;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.christine.cpassenger.capstone.Service.APIServiceGenerator;
import com.example.christine.cpassenger.capstone.Service.APIServices;

/**
 * Created by Christine on 1/29/2018.
 */

public class AppController extends Application{
    public static APIServices apiService;

    @Override
    public void onCreate() {
        super.onCreate();
        apiService = APIServiceGenerator.createService(APIServices.class);
    }

    public static void hideKeyboard(Activity activity){
        // Check if no view has focus:
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
