package com.example.mvpproject.ui.addscreen.views;

import com.example.mvpproject.model.Item;

public interface AddScreenView {

    void showData(Item data);

    void showError(String msg);
}
