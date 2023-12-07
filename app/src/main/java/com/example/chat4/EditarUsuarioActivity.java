package com.example.chat4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditarUsuarioActivity extends AppCompatActivity {

    private EditText editname;
    private EditText editapel;
    private EditText editcorreoE;
    private EditText editpassE;
    private Button btnguardaE;

    private FirebaseUser user;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);

        editname = findViewById(R.id.editname);
        editapel = findViewById(R.id.editapel);
        editcorreoE = findViewById(R.id.editcorreoE);
        editpassE = findViewById(R.id.editpassE);

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("users");


    }
}



