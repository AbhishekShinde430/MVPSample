package com.example.mvpproject.base.views;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvpproject.MyApplication;
import com.example.mvpproject.utils.AlertPopup;
import com.example.mvpproject.di.component.ActivityComponent;
import com.example.mvpproject.di.component.DaggerActivityComponent;
import com.example.mvpproject.di.modules.ActivityModule;
import com.example.mvpproject.ui.screenlist.views.ItemView;

public class BaseActivity extends AppCompatActivity implements AlertPopup {

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public ActivityComponent getActivityComponent(ItemView view) {
        activityComponent= DaggerActivityComponent.builder()
                .coreComponent(((MyApplication) getApplication()).getCoreComponent()) // Get CoreComponent from BaseActivity or MyApplication
                .activityModule(new ActivityModule(view)) // Pass ActivityModule for activity-specific dependencies
                .build();

        return activityComponent;
    }

    @Override
    public void showAlert(String message) {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


}

