package com.example.mvpproject.ui.addscreen.views;

import android.os.Bundle;

import com.example.mvpproject.base.views.BaseActivity;
import com.example.mvpproject.databinding.ActivityAddViewBinding;
import com.example.mvpproject.model.Item;

public class AddViewActivity extends BaseActivity implements AddScreenView {

    private ActivityAddViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public void showData(Item data) {

    }

    @Override
    public void showError(String msg) {

    }
}