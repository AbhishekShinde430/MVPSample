package com.example.mvpproject.ui.screenlist.views;

import com.example.mvpproject.model.Item;

import java.util.List;

public interface ItemView  {

    void showData(List<Item> data);

    void showError(String msg);


}
