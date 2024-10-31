package com.example.mvpproject.ui.screenlist.presenter;

import com.example.mvpproject.network.ApiClient;
import com.example.mvpproject.ui.screenlist.views.ItemView;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MyPresenterImpl implements MyPresenter {

    private ItemView itemView;
    private ApiClient apiClient;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Inject
    public MyPresenterImpl(ItemView itemView, ApiClient apiClient) {
        this.itemView = itemView;
        this.apiClient = apiClient;
    }



    @Override
    public void loadData() {
        List<Integer> ids = Arrays.asList(3, 5, 10);
        compositeDisposable.add(apiClient.getListData(ids)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        data ->
                        {
                            itemView.showData(data);
                        },
                        throwable -> {
                            itemView.showError(throwable.getMessage());
                        }
                )
        );
    }

    public void clear() {
        //this.itemView = null;
        compositeDisposable.clear();
    }
}
