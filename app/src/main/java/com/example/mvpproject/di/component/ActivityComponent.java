package com.example.mvpproject.di.component;

import com.example.mvpproject.di.modules.ActivityModule;
import com.example.mvpproject.di.scope.PerActivity;
import com.example.mvpproject.ui.screenlist.views.ListActivity;

import dagger.Component;
@PerActivity
@Component(dependencies = CoreComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(ListActivity itemActivity);
}
