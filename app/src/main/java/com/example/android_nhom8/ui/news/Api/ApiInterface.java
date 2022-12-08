package com.example.android_nhom8.ui.news.Api;

import com.example.android_nhom8.ui.news.mainNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String BASE_URL="https://newsapi.org/v2/";



    @GET("top-headlines")
    Call<mainNews> getCatagoryNews(
            @Query("country")   String country,
            @Query("category") String category,
            @Query("pageSize") int pagesize,
            @Query("apiKey") String apikey
    );

}
