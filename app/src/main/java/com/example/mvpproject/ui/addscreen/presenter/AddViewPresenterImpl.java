package com.example.mvpproject.ui.addscreen.presenter;

import android.content.ClipData;

import com.example.mvpproject.network.ApiClient;
import com.example.mvpproject.ui.addscreen.views.AddScreenView;

import javax.inject.Inject;

public class AddViewPresenterImpl implements AddViewPresenter{

    private ApiClient apiClient;
    private AddScreenView addScreenView;

    @Inject
    public AddViewPresenterImpl(ApiClient apiClient, AddScreenView addScreenView) {
        this.apiClient = apiClient;
        this.addScreenView = addScreenView;
    }

    @Override
    public void loadData(ClipData.Item data) {

    }
}
