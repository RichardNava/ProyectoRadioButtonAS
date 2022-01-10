package com.example.app4_radiogroupbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText etNum1, etNum2;
    private TextView tvResult;
    private RadioButton rbSum, rbRest, rbMult, rbDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Objetos EditText
        etNum1 = (EditText) findViewById(R.id.etn1_num1);
        etNum2 = (EditText) findViewById(R.id.etn2_num2);
        // Objeto TextView
        tvResult = (TextView) findViewById(R.id.tv_result);
        // Objetos RadioButton
        rbSum = (RadioButton) findViewById(R.id.rb_sum);
        rbRest = (RadioButton) findViewById(R.id.rb_rest);
        rbMult = (RadioButton) findViewById(R.id.rb_mult);
        rbDiv = (RadioButton) findViewById(R.id.rb_div);

    }

    public void Calcular(View v){
        DecimalFormat df = new DecimalFormat("#.00");

        float num1 = Float.parseFloat(etNum1.getText().toString());
        float num2 = Float.parseFloat(etNum2.getText().toString());

        boolean sum = rbSum.isChecked();
        if (rbSum.isChecked()) {
            tvResult.setText(String.valueOf(df.format(num1+num2)));
        }
        else if (rbRest.isChecked()){
            tvResult.setText(df.format(num1-num2));
        }
        else if (rbMult.isChecked()){
            tvResult.setText(df.format(num1*num2));
        }
        else if (rbDiv.isChecked()){
            if(num2 != 0){
                tvResult.setText(df.format(num1/num2));
            }
            else
            {
                Toast.makeText(this, "No se puede dividir entre 0. Introduzca otro número.", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this, "Debe seleccionar una opción para realizar el cálculo.", Toast.LENGTH_SHORT).show();
        }
    }

}