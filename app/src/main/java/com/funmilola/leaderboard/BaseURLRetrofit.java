package com.funmilola.leaderboard;

import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;


public class BaseURLRetrofit {
    public static final String BASE_URL = "https://gadsapi.herokuapp.com/api/";
    public static Retrofit sRetrofit = null;

    public BaseURLRetrofit() {
    }
    public static  synchronized Retrofit getLeaderApi(){
        if (sRetrofit == null){
           sRetrofit = new Retrofit.Builder().baseUrl(BASE_URL).
                   addConverterFactory(GsonConverterFactory.create()).build();
        }
        return sRetrofit;

    }
}
