package com.example.mvpproject.network;

import com.example.mvpproject.model.Item;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class ApiClient {
    private ApiService apiService;

    @Inject
    public ApiClient(ApiService apiService) {
        this.apiService = apiService;
    }

    public Single<List<Item>> getListData(List<Integer> ids){
        return apiService.getItemsList(ids);
    }
}
