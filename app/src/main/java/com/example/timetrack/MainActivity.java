package com.example.timetrack;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.timetrack.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFichar = findViewById(R.id.btnFichar);
        btnFichar.setOnClickListener(v -> {
            // Aquí iría la lógica para insertar en la tabla Registros_Horarios [cite: 35]
            Toast.makeText(this, "Jornada Iniciada", Toast.LENGTH_LONG).show();
        });
    }
}