package com.example.mvpproject.ui.pinscreen.views;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mvpproject.databinding.ActivityPinBinding;
import com.example.mvpproject.ui.screenlist.views.ListActivity;

public class PinActivity extends AppCompatActivity {

    private ActivityPinBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPinBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSubmit.setOnClickListener(v -> {
            Intent intent = new Intent(PinActivity.this, ListActivity.class);
            startActivity(intent);
        });
    }
}