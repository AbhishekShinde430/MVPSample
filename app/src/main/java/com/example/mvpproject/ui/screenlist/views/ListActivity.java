package com.example.mvpproject.ui.screenlist.views;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvpproject.R;
import com.example.mvpproject.base.views.BaseActivity;
import com.example.mvpproject.model.Item;
import com.example.mvpproject.ui.screenlist.presenter.MyPresenter;
import com.example.mvpproject.ui.screenlist.adapter.ListViewAdapter;

import java.util.List;

import javax.inject.Inject;

public class ListActivity extends BaseActivity implements ItemView {

    private String TAG = getClass().getSimpleName();

    @Inject
    MyPresenter myPresenter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize DaggerActivityComponent, passing CoreComponent as a dependency
        getActivityComponent(this).inject(this);

        myPresenter.loadData();

        //
        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showData(List<Item> data) {
        ListViewAdapter itemAdapter = new ListViewAdapter(data);
        recyclerView.setAdapter(itemAdapter);
    }

    @Override
    public void showError(String msg) {
       showAlert(msg);
    }

}