package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.core.content.ContextCompat;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout relativeLayout;
        EditText edtWeight, edtHeightFt, edtHeightIn;
        Button button;
        TextView textView;

        relativeLayout = findViewById(R.id.relativeLayout);
        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        button = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtWeight.length() == 0 || edtHeightFt.length() == 0 || edtHeightIn.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Enter Weight and Height!", Toast.LENGTH_LONG).show();
                } else {
                    int wt = Integer.parseInt(edtWeight.getText().toString());
                    int ft = Integer.parseInt(edtHeightFt.getText().toString());
                    int in = Integer.parseInt(edtHeightIn.getText().toString());

                    int totalIn = (ft * 12) + in;
                    double totalCm = totalIn * 2.53;
                    double totalM = totalCm / 100;

                    double bmi = wt / (totalM * totalM);
                    if (bmi > 25) {
                        textView.setText("You're overweight!");
                        int clrOverWt = ContextCompat.getColor(getApplicationContext(), R.color.clrOverWt);
                        relativeLayout.setBackgroundColor(clrOverWt);
                    }else if(bmi<18){
                        textView.setText("You're underweight!");
                        int clrUnderWt=ContextCompat.getColor(getApplicationContext(),R.color.clrUnderWt);
                        relativeLayout.setBackgroundColor(clrUnderWt);
                    }else {
                        textView.setText("You're Healthy!");
                        int clrHealthy=ContextCompat.getColor(getApplicationContext(),R.color.clrHealthy);
                        relativeLayout.setBackgroundColor(clrHealthy);
                    }
                }
            }
        });
    }
}