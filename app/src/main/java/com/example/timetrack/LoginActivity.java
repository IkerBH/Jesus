package com.example.timetrack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Enlazamos con los IDs de tu XML actual
        EditText etDni = findViewById(R.id.etDni);
        EditText etPass = findViewById(R.id.etContrasena);
        Button btn = findViewById(R.id.btnEntrar);

        btn.setOnClickListener(v -> {
            String dni = etDni.getText().toString();
            String pass = etPass.getText().toString();

            // Las conexiones a BBDD tienen que estar dentro de una hebra para que no se cierre la aplicación [cite: 106, 107]
            new Thread(() -> {
                UsuarioDAO dao = new UsuarioDAO();
                boolean esValido = dao.login(dni, pass);

                runOnUiThread(() -> {
                    if (esValido) {
                        Toast.makeText(this, "¡Bienvenido!", Toast.LENGTH_SHORT).show();
                        // Al terminar el login, pasamos a la pantalla de fichar [cite: 86]
                        startActivity(new Intent(this, MainActivity.class));
                    } else {
                        Toast.makeText(this, "DNI o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    }
                });
            }).start();
        });
    }
}