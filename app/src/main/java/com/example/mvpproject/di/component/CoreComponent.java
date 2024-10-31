package com.example.mvpproject.di.component;

import com.example.mvpproject.di.modules.CoreModule;
import com.example.mvpproject.network.ApiService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {CoreModule.class})
public interface CoreComponent {

    ApiService apiService();
}
