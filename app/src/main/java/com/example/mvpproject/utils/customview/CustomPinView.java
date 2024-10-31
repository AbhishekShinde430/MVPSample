package com.example.mvpproject.utils.customview;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.mvpproject.R;

public class CustomPinView extends LinearLayout {

    private EditText[] pinEditTexts;

    public CustomPinView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomPinView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public CustomPinView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    public CustomPinView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_custom_pin, this, true);
        pinEditTexts = new EditText[4]; // Change the size as needed

        pinEditTexts[0] = findViewById(R.id.pin_edit_text_1);
        pinEditTexts[1] = findViewById(R.id.pin_edit_text_2);
        pinEditTexts[2] = findViewById(R.id.pin_edit_text_3);
        pinEditTexts[3] = findViewById(R.id.pin_edit_text_4);

        for (int i = 0; i < pinEditTexts.length; i++) {

            final int index = i;

            pinEditTexts[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.length() == 1 && index < pinEditTexts.length - 1) {
                        pinEditTexts[index + 1].requestFocus();
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

        }
    }

    public String getPin() {
        StringBuilder pin = new StringBuilder();
        for (EditText editText : pinEditTexts) {
            pin.append(editText.getText().toString());
        }
        return pin.toString();
    }


}
