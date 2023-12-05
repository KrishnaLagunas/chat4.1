package com.example.chat4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegistroActivity extends AppCompatActivity {
    EditText editNombre;
    EditText editApellido;
    EditText editCorreo;
    EditText editContraseña;
    Button btnRegistro;
    private FirebaseFirestore mfirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        this.setTitle("Registro exitoso");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mfirestore = FirebaseFirestore.getInstance();

        editNombre = findViewById(R.id.editNombre);
        editApellido = findViewById(R.id.editApellido);
        editCorreo = findViewById(R.id.editCorreo);
        editContraseña = findViewById(R.id.editContraseña);
        btnRegistro = findViewById(R.id.btnRegistro);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editNombre.getText().toString();
                String apellido = editApellido.getText().toString();
                String correo = editCorreo.getText().toString();
                String contraseña = editContraseña.getText().toString();

                if (nombre.isEmpty() || apellido.isEmpty() || correo.isEmpty() || contraseña.isEmpty()) {
                    Toast.makeText(RegistroActivity.this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
                } else {
                    registros(nombre, apellido, correo, contraseña);
                }
            }
        });
    }

    private void registros(String nombre, String apellido, String correo, String contraseña) {
        Map<String, Object> map = new HashMap<>();
        map.put("Nombre", nombre);
        map.put("Apellido", apellido);
        map.put("Correo", correo);
        map.put("Contraseña", contraseña);

        mfirestore.collection("Registro").add(map)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
                        finish(); // Finaliza la actividad después del registro exitoso
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Error al Registrarse", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Manejar el clic en la flecha de retroceso
        if (item.getItemId() == android.R.id.home) {
            finish(); // Finaliza la actividad al hacer clic en la flecha de retroceso
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
