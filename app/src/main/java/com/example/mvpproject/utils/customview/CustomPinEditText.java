package com.example.mvpproject.utils.customview;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

public class CustomPinEditText extends AppCompatEditText {
    public CustomPinEditText(@NonNull Context context) {
        super(context);
        init();
    }

    public CustomPinEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomPinEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        setMaxLines(1);
        setMaxLength();
        setInputType(android.text.InputType.TYPE_CLASS_NUMBER);
        setCursorVisible(false); // Hide cursor initially


        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 1) {
                    // Move focus to the next EditText
                    View next = focusSearch(View.FOCUS_RIGHT);
                    if (next != null) {
                        next.requestFocus();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        setOnKeyListener((v, keyCode, event) -> {
            if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                // Move focus to the previous EditText on backspace if empty
                if (getText().length() == 0) {
                    // Move focus to the previous EditText
                    View previous = focusSearch(View.FOCUS_LEFT);
                    if (previous != null) {
                        // Clear the previous EditText's text
                        if (previous instanceof CustomPinEditText) {
                            ((CustomPinEditText) previous).setText(""); // Clear the previous number
                        }
                        previous.requestFocus(); // Move focus to the previous EditText
                    }
                } else {
                    // If there is text, clear the current EditText
                    setText(""); // Clear the current EditText

                }
                return true;
            }
            return false;
        });
    }

    private void setMaxLength(){
        setFilters(new android.text.InputFilter[]{new android.text.InputFilter.LengthFilter(1)});
    }
}
