package com.example.mvpproject;

import android.app.Application;

import com.example.mvpproject.di.component.CoreComponent;
import com.example.mvpproject.di.component.DaggerCoreComponent;
import com.example.mvpproject.di.modules.CoreModule;

public class MyApplication extends Application {

    private CoreComponent coreComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        coreComponent =DaggerCoreComponent.builder()
                .coreModule(new CoreModule(this)) // Pass any required parameters to CoreModule here
                .build();



    }
    public CoreComponent getCoreComponent() {
        return coreComponent;
    }





}
