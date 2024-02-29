package com.example.ejerciciospdm26feb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CurrencyConvertor extends AppCompatActivity {

    EditText editTextGetAmount;
    RadioButton radioButtonEuros, radioButtonMexicanPesos, radioButtonArgentinePesos, radioButtonPoundSterling;
    TextView textViewResult;
    Button buttonCloseApp;

    double dolarToEuroFactor = 0.92;
    double dolarToMexicanPesosFactor = 17.08;
    double dolarToArgentinePesosFactor = 841.75;
    double dolarToPoundsSterlingFactor = 0.79;
    double result = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_convertor);

        DecimalFormat df = new DecimalFormat("#.##");

        editTextGetAmount = findViewById(R.id.editTextGetAmount);

        radioButtonEuros = findViewById(R.id.radioButtonEuros);
        radioButtonMexicanPesos = findViewById(R.id.radioButtonMexicanPesos);
        radioButtonArgentinePesos = findViewById(R.id.radioButtonArgentinePesos);
        radioButtonPoundSterling = findViewById(R.id.radioButtonPoundSterling);

        textViewResult = findViewById(R.id.textViewResult);

        buttonCloseApp = findViewById(R.id.buttonCloseApp);

        buttonCloseApp.setOnClickListener(v -> {
            Toast.makeText(this, "Cerrando app", Toast.LENGTH_SHORT).show();
            finishAffinity();
            System.exit(0);
        });

        radioButtonEuros.setOnClickListener(v -> {
            String amountGivenByUser = editTextGetAmount.getText().toString();

            if (amountGivenByUser.isEmpty()){
                Toast.makeText(this, "Ingrese una cantidad", Toast.LENGTH_SHORT).show();
                return;
            }

            result = Double.parseDouble(amountGivenByUser) * dolarToEuroFactor;
            textViewResult.setText("USD $" + amountGivenByUser + " dólares equivalen a " + df.format(result) + " euros");
        });

        radioButtonMexicanPesos.setOnClickListener(v -> {
            String amountGivenByUser = editTextGetAmount.getText().toString();

            if (amountGivenByUser.isEmpty()){
                Toast.makeText(this, "Ingrese una cantidad", Toast.LENGTH_SHORT).show();
                return;
            }

            result = Double.parseDouble(amountGivenByUser) * dolarToMexicanPesosFactor;
            textViewResult.setText("USD $" + amountGivenByUser + " dólares equivalen a " + df.format(result) + " pesos mexicanos");
        });

        radioButtonArgentinePesos.setOnClickListener(v -> {
            String amountGivenByUser = editTextGetAmount.getText().toString();

            if (amountGivenByUser.isEmpty()){
                Toast.makeText(this, "Ingrese una cantidad", Toast.LENGTH_SHORT).show();
                return;
            }

            result = Double.parseDouble(amountGivenByUser) * dolarToArgentinePesosFactor;
            textViewResult.setText("USD $" + amountGivenByUser + " dólares equivalen a " + df.format(result) + " pesos argentinos");
        });

        radioButtonPoundSterling.setOnClickListener(v -> {
            String amountGivenByUser = editTextGetAmount.getText().toString();

            if (amountGivenByUser.isEmpty()){
                Toast.makeText(this, "Ingrese una cantidad", Toast.LENGTH_SHORT).show();
                return;
            }

            result = Double.parseDouble(amountGivenByUser) * dolarToPoundsSterlingFactor;
            textViewResult.setText("USD $" + amountGivenByUser + " dólares equivalen a " + df.format(result) + " libras esterlinas");
        });
    }
}
