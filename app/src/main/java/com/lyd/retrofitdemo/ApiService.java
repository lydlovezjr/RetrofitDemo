package com.lyd.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("login")
    Call<UserInfoModel> login(@Query("username") String username, @Query("password") String password);
}
