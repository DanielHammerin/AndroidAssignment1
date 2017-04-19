package com.example.daniel.assignment1project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BMICalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        /*
        Instances of buttons, textview and edittext fields.
         */
        Button calculate = (Button) findViewById(R.id.calculateButton);
        Button reset = (Button) findViewById(R.id.resetButton);
        final EditText height = (EditText) findViewById(R.id.heightField);
        final EditText weight = (EditText) findViewById(R.id.weightField);
        final TextView tv = (TextView) findViewById(R.id.bmiResult);

        calculate.setOnClickListener(new View.OnClickListener() {//Calculate button
            @Override
            public void onClick(View view) {
                if(height.getText().toString().equals("")) {//Has user entered height?
                    Toast.makeText(BMICalculator.this, "How do you not have a height?!", Toast.LENGTH_SHORT).show();
                }
                else if(weight.getText().toString().equals("")) {//Has user entered weight?
                    Toast.makeText(BMICalculator.this, "Do you even exist?!", Toast.LENGTH_SHORT).show();
                }
                else {//Calculation if both fields are filled out correctly.
                    double result = calculateBmi(Integer.valueOf(height.getText().toString()), Integer.valueOf(weight.getText().toString()));
                    tv.setText(String.valueOf(result));
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener(){//Reset values button.
            @Override
            public void onClick(View view) {//Resets values.
                height.setText("");
                weight.setText("");
                tv.setText("");
            }
        });
    }
    private double calculateBmi(double height, double weight) {//BMI formula method
        double calcBmi = 0;
        double heightM = height/100;
        calcBmi = weight / (Math.pow(heightM, 2));
        return Math.round(calcBmi * 10d) / 10d;
    }
}
