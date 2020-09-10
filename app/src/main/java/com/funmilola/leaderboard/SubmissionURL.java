package com.funmilola.leaderboard;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmissionURL {
    public static final String FULL_URL = "https://docs.google.com/forms/d/e/";
    public static Retrofit sRetrofit = null;

    public SubmissionURL() {
    }
    public static synchronized Retrofit processRetrofitSubmit(){
        if (sRetrofit == null){
            sRetrofit = new Retrofit.Builder().baseUrl(FULL_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return sRetrofit;
    }
}
