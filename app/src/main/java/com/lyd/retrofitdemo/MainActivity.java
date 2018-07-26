package com.lyd.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRetrofit();
    }

    private void initRetrofit() {
        //第一步 创建接口 设置请求类型与参数

        //第二步 创建Retrofit对象 并设置数据解析器
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //第三步 生成接口对象
        ApiService apiService = retrofit.create(ApiService.class);

        //第四步 调用接口方法 返回Call对象
        final Call<UserInfoModel> call = apiService.login("lyd", "123456");

        //第五步 发送请求(同步 Or 异步) 并处理返回数据
        //同步:调用Call对象的execute(),返回结果的响应体
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response<UserInfoModel> response = call.execute();
                    int code = response.body().code;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //异步:调用Call对象的enqueue(),参数是一个回调
        call.enqueue(new Callback<UserInfoModel>() {
            @Override
            public void onResponse(Call<UserInfoModel> call, Response<UserInfoModel> response) {
                int code = response.body().data.id;
            }

            @Override
            public void onFailure(Call<UserInfoModel> call, Throwable t) {

            }
        });
    }

    public void onAction(View view) {
    }
}
