package com.example.chat4;

import static com.example.chat4.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class inicioSesionActivity extends AppCompatActivity {
    private EditText editName;
    private EditText editPass;
    private Button btnIniciosesion;
    private Button btnRegistrarsee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        editName = findViewById(R.id.editName);
        editPass = findViewById(R.id.editPass);


        btnRegistrarsee = findViewById(R.id.btnRegistrarsee);
        btnRegistrarsee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(inicioSesionActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });

        btnIniciosesion = findViewById(R.id.btnIniciosesion);
        btnIniciosesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para el inicio de sesión
            }
        });
    }
}
