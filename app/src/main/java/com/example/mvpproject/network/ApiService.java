package com.example.mvpproject.network;

import com.example.mvpproject.model.Item;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/objects")
    Single<List<Item>> getItemsList(@Query("id") List<Integer> ids);
}
