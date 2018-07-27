package com.first.mytwitter.Applycation;

import com.first.mytwitter.TwitModel.Messages;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Countries {
    @GET("rest/v2/all?fields=name")
    Call<List<Messages>>  getCountries();
}
