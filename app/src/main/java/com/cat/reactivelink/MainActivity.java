package com.cat.reactivelink;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cat.mylibrary.customEditText.ReactiveEditText;
import com.cat.mylibrary.models.LinkInfo;

public class MainActivity extends AppCompatActivity {

    ReactiveEditText reactiveEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reactiveEditText = findViewById(R.id.et);
        reactiveEditText.getResult(new ReactiveEditText.GetReactiveResult() {
            @Override
            public void getResult(LinkInfo linkInfo) {
                // TODO Ahmed (Display image and title)
            }
        });

        // TODO Here, we test our library like individual project

    }
}