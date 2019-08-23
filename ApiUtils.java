package com.example.baseretrofitapp.remote;

import com.example.baseretrofitapp.utils.Constants;

public class ApiUtils {

    public static UserService getUserService(){
        return RetrofitClient.getRetrofit(Constants.BASE_URL).create(UserService.class);
    }
}
