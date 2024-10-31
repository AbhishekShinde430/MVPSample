package com.example.mvpproject.di.modules;

import com.example.mvpproject.network.ApiClient;
import com.example.mvpproject.ui.screenlist.presenter.MyPresenter;
import com.example.mvpproject.ui.screenlist.presenter.MyPresenterImpl;
import com.example.mvpproject.ui.screenlist.views.ItemView;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final ItemView view;

    public ActivityModule(ItemView view) {
        this.view = view;
    }

    // Provides ItemView to Dagger
    @Provides
    ItemView provideItemView() {
        return view;
    }



    @Provides
    MyPresenter providePresenter(ItemView view, ApiClient client){
        return new MyPresenterImpl(view,client);
    }


}
