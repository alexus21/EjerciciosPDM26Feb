package com.example.ejerciciospdm26feb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GuessTheAge extends AppCompatActivity {

    EditText editTextGetNumber;
    Button buttonCheckAnswer, buttonNextActivity;
    TextView textViewShowAnswerDialog, textViewShowTotalAttemps;

    int generateRandomNumber = (int) (Math.random() * 10 + 1);
    int totalAttemps = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_age);

        editTextGetNumber = findViewById(R.id.editTextGetNumber);
        buttonCheckAnswer = findViewById(R.id.buttonCheckAnswer);
        textViewShowAnswerDialog = findViewById(R.id.textViewShowAnswerDialog);
        textViewShowTotalAttemps = findViewById(R.id.textViewShowTotalAttemps);
        buttonNextActivity = findViewById(R.id.buttonNextActivity);

        buttonNextActivity.setOnClickListener(v -> {
            Toast.makeText(this, "Redirigiendo a la siguiente actividad", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, CurrencyConvertor.class);
            startActivity(intent);
        });

        buttonCheckAnswer.setOnClickListener(v -> {
            String userNumber = editTextGetNumber.getText().toString();


            if(userNumber.equals(String.valueOf(generateRandomNumber))){
                textViewShowAnswerDialog.setText("Adivinaste la respuesta");
                totalAttemps += 1;
            }
            else{
                if(Integer.parseInt(userNumber) > generateRandomNumber){
                    textViewShowAnswerDialog.setText("El número buscado es menor");
                    editTextGetNumber.setText("");
                }
                else{
                    textViewShowAnswerDialog.setText("El número buscado es mayor");
                    editTextGetNumber.setText("");
                }
                totalAttemps += 1;
            }

            textViewShowTotalAttemps.setText("Cantidad de intentos: " +  totalAttemps);
        });

    }
}
