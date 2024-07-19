package com.example.mycalculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Double first, second, result, number;
    private Boolean isOperationClick, isDotLine;
    private int currentOperation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        String text = ((MaterialButton) view).getText().toString();
        if (text.equals("AC")) {
            textView.setText("0");
        } else if (textView.getText().toString().equals("0") || isOperationClick) {
            if (text.equals(".")) {
                textView.setText("0.");
                isDotLine = true;
            } else {
                textView.setText(text);
            }
        } else {
            if (text.equals(".")) {
                if (!isDotLine) {
                    textView.append(text);
                    isDotLine = true;
                }
            } else {
                textView.append(text);
            }
        }
        isOperationClick = false;
    }

    public void doSum() {
        result = first + second;
        if (result.toString().endsWith(".0")) {
            textView.setText(result.toString().replace(".0", ""));
        } else {
            textView.setText(result.toString());
            isDotLine = true;
        }
    }

    public void doMinus() {
        result = first - second;
        if (result.toString().endsWith(".0")) {
            textView.setText(result.toString().replace(".0", ""));
        } else {
            textView.setText(result.toString());
            isDotLine = true;
        }
    }

    public void doMultiply() {
        result = first * second;
        if (result.toString().endsWith(".0")) {
            textView.setText(result.toString().replace(".0", ""));
        } else {
            textView.setText(result.toString());
            isDotLine = true;
        }
    }

    public void doDivide() {
        result = first / second;
        if (result.toString().endsWith(".0")) {
            textView.setText(result.toString().replace(".0", ""));
        } else {
            textView.setText(result.toString());
            isDotLine = true;
        }

    }


    public void onOperationClick(View view) {
        isDotLine = false;
        if (view.getId() == R.id.btn_plus || view.getId() == R.id.btn_minus || view.getId() == R.id.btn_divide || view.getId() == R.id.btn_multiply) {
            first = Double.valueOf(textView.getText().toString());
            currentOperation = view.getId();
        } else if (view.getId() == R.id.btn_equals) {
            second = Double.valueOf(textView.getText().toString());
            if (currentOperation == R.id.btn_plus) {
                doSum();
            } else if (currentOperation == R.id.btn_minus) {
                doMinus();
            } else if (currentOperation == R.id.btn_multiply) {
                doMultiply();
            } else if (currentOperation == R.id.btn_divide) {
                doDivide();
            }
        }
        isOperationClick = true;
    }

    public void onSignClick(View view) {
        String text = textView.getText().toString();
        if (view.getId() == R.id.btn_signs) {
            if (Double.valueOf(text) > 0) {
                textView.setText("-" + text);
            } else if (Double.valueOf(text) < 0) {
                textView.setText(text.replace("-", ""));
            }
            isDotLine = true;
        }
    }
}