package com.first.mytwitter.Applycation;

import com.first.mytwitter.TwitModel.Messages;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Countries {
    @GET("name.json")
    Call<List<Messages>>  getCountries();

   // @PUT("users/{new}.json")
    //Call<List<Messages>> setData (@Path("new") int i, @Body Messages messages);
}
