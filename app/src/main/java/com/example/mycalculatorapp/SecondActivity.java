package com.example.mycalculatorapp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.slider.RangeSlider;

public class SecondActivity extends AppCompatActivity {

    private TextView textView;
    boolean isPressed=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        textView = findViewById(R.id.result_text);
        String text = getIntent().getStringExtra("key1");
        textView.setText(text);
    }

    public void onHeartClick(View view) {
        if(isPressed){
            view.setBackgroundResource(R.drawable.ic_full_heart);
        }else{
            view.setBackgroundResource(R.drawable.ic_heart);
        }
        isPressed=!isPressed;
    }

    public void onNextClick(View view) {
        finishAffinity();
    }
}