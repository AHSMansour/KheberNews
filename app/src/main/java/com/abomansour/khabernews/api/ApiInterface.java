package com.abomansour.khabernews.api;


import com.abomansour.khabernews.modules.news;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface  {

    @GET("top-headlines?")

    Call<news> getNews(

            @Query("country") String country ,

            @Query("apiKey") String apikey


    );
}
