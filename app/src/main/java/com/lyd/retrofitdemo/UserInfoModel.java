package com.lyd.retrofitdemo;

public class UserInfoModel {
    public int code;
    public String message;
    public UserInfo data;

    public static class UserInfo {
        public int id;
        public String name;
        public String tel;
    }
}
