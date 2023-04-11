package com.laioffer.tinnews.network;

import com.laioffer.tinnews.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {
    // describe the endpoint you would like to call
    // https://newsapi.org/v2/everything?q=tesla&pageSize=10
    // Call is a task to execute
    @GET("everything")
    Call<NewsResponse> getEverything(@Query("q") String query, @Query("pageSize") int pageSize);

    // https://newsapi.org/v2/top-headlines?country=us
    @GET("top-headlines")
    Call<NewsResponse> getTopHeadlines(@Query("country") String country);
}

