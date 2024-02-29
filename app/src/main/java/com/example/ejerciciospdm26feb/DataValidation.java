package com.example.ejerciciospdm26feb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DataValidation extends AppCompatActivity {

    EditText editTextGetUserAge;
    Button buttonVerifyUserAge;
    TextView textViewAgeValidation;
    Button buttonNextActivity;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_validation);

        editTextGetUserAge = findViewById(R.id.editTextGetUserAge);
        buttonVerifyUserAge = findViewById(R.id.buttonVerifyUserAge);
        textViewAgeValidation = findViewById(R.id.textViewAgeValidation);
        buttonNextActivity = findViewById(R.id.buttonNextActivity);

        buttonNextActivity.setOnClickListener(v -> {
            Toast.makeText(this, "Redirigiendo a la siguiente actividad", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, GuessTheAge.class);
            startActivity(intent);
        });

        buttonVerifyUserAge.setOnClickListener(v -> {
            String userAge = editTextGetUserAge.getText().toString();

            if (userAge.isEmpty()) {
                Toast.makeText(this, "Ingresá tu edad", Toast.LENGTH_SHORT).show();
            } else {
                int age = Integer.parseInt(userAge);
                if (age > 0 && age < 120) {
                    textViewAgeValidation.setText("Edad correcta");
                } else {
                    textViewAgeValidation.setText("Edad incorrecta");
                }
            }
        });
    }
}
