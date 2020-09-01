package com.example.retrofitapi;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetRequest {

    @GET("todos/1")
    Call<JsonObject> getData();
}
