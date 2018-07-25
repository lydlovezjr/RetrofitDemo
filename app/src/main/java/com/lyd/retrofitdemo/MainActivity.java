package com.lyd.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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

        //第三步 生成接口对象

        //第四步 调用接口方法 返回Call对象

        //第五步 发送请求(同步 Or 异步)
        //同步:调用Call对象的execute(),返回结果的响应体
        //异步:调用Call对象的enqueue(),参数是一个回调

        //第六步: 处理返回数据
    }

    public void onAction(View view) {

    }
}
