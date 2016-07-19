package com.example.putuguna.retrofit2post.apis;

import com.example.putuguna.retrofit2post.ListFaqModel;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by putuguna on 14/06/16.
 */
public interface ApiService {
    @POST("/loginsaya")
    Call<ListFaqModel> postLogin(@Query("email") String username, @Query("password") String password);
}
