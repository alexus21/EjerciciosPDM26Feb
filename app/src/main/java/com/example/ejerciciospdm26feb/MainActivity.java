package com.example.ejerciciospdm26feb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextFirstNumber, editTextSecondNumber;
    RadioButton radioButtonAdd, radioButtonSubstract, radioButtonProduct, radioButtonDivide;
    TextView textViewResult;
    CheckBox checkBoxRoundUp;
    Button buttonNextActivity;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //////////////////////////////////////////////////////////////////////
        editTextFirstNumber = findViewById(R.id.editTextFirstNumber);
        editTextSecondNumber = findViewById(R.id.editTextSecondNumber);

        //////////////////////////////////////////////////////////////////////
        radioButtonAdd = findViewById(R.id.radioButtonAdd);
        radioButtonSubstract = findViewById(R.id.radioButtonSubstract);
        radioButtonProduct = findViewById(R.id.radioButtonProduct);
        radioButtonDivide = findViewById(R.id.radioButtonDivide);

        //////////////////////////////////////////////////////////////////////
        textViewResult = findViewById(R.id.textViewResult);

        //////////////////////////////////////////////////////////////////////
        checkBoxRoundUp = findViewById(R.id.checkBoxRoundUp);

        //////////////////////////////////////////////////////////////////////
        buttonNextActivity = findViewById(R.id.buttonNextActivity);

//        String firstNumber = editTextFirstNumber.getText().toString();
//        String secondNumber = editTextSecondNumber.getText().toString();

        buttonNextActivity.setOnClickListener(v -> {
            Toast.makeText(this, "Redirigiendo a la siguiente actividad", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, DataValidation.class);
            startActivity(intent);
        });
        
//        if(firstNumber.isEmpty()){
//            Toast.makeText(this, "Ingresá el primer número", Toast.LENGTH_SHORT).show();
//            editTextFirstNumber.setFocusable(true);
//            return;
//        }
//
//        if(secondNumber.isEmpty()){
//            Toast.makeText(this, "Ingresá el segundo número", Toast.LENGTH_SHORT).show();
//            editTextSecondNumber.setFocusable(true);
//            return;
//        }

        radioButtonAdd.setOnClickListener(v -> {
            String firstNumber = editTextFirstNumber.getText().toString();
            String secondNumber = editTextSecondNumber.getText().toString();
            if (firstNumber.isEmpty() || secondNumber.isEmpty()) {
                Toast.makeText(MainActivity.this, "Ingresa ambos números", Toast.LENGTH_SHORT).show();
                return;
            }
            textViewResult.setText(String.valueOf(Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber)));
        });

        radioButtonSubstract.setOnClickListener(v -> {
            String firstNumber = editTextFirstNumber.getText().toString();
            String secondNumber = editTextSecondNumber.getText().toString();
            if (firstNumber.isEmpty() || secondNumber.isEmpty()) {
                Toast.makeText(MainActivity.this, "Ingresa ambos números", Toast.LENGTH_SHORT).show();
                return;
            }
            textViewResult.setText(String.valueOf(Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber)));
        });

        radioButtonProduct.setOnClickListener(v -> {
            String firstNumber = editTextFirstNumber.getText().toString();
            String secondNumber = editTextSecondNumber.getText().toString();
            if (firstNumber.isEmpty() || secondNumber.isEmpty()) {
                Toast.makeText(MainActivity.this, "Ingresa ambos números", Toast.LENGTH_SHORT).show();
                return;
            }
            textViewResult.setText(String.valueOf(Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber)));
        });

        radioButtonDivide.setOnClickListener(v -> {
            String firstNumber = editTextFirstNumber.getText().toString();
            String secondNumber = editTextSecondNumber.getText().toString();
            if (firstNumber.isEmpty() || secondNumber.isEmpty()) {
                Toast.makeText(MainActivity.this, "Ingresa ambos números", Toast.LENGTH_SHORT).show();
                return;
            }
            double secondValue = Double.parseDouble(secondNumber);
            if (secondValue == 0) {
                textViewResult.setText("Error: no se puede dividir entre 0.");
                return;
            }
            textViewResult.setText(String.valueOf(Double.parseDouble(firstNumber) / secondValue));
        });


        checkBoxRoundUp.setOnClickListener(v -> {
            if (checkBoxRoundUp.isChecked()) {
                if(textViewResult.getText().toString().equals("Error: no se puede dividir entre 0.")){
                    return;
                }
                textViewResult.setText(String.valueOf(Math.ceil(Float.parseFloat(textViewResult.getText().toString()))));
            }
        });
    }
}
