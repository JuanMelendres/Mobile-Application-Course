package com.itesm.feb12aplicacionsita;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

public class MainActivity extends AppCompatActivity {

    private TextView textito;
    private EditText nombre, apellido;
    private Button botoncito, botoncito2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener referencia a elementos de GUI

        textito = findViewById(R.id.textito);
        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        botoncito = findViewById(R.id.saludar);
        botoncito2 = findViewById(R.id.botoncito2);

        botoncito2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this,
                        "HOLA AMIGUITOS",
                        Toast.LENGTH_SHORT).show();
            }
        });

        textito.setText("HOLA A TODOS");
    }

    // Método invocable / vinculable desde XML
    // Debe ser público y recibir view

    public void saludar(View v) {

        Log.d( "SALUDAR", "Hola " +
                nombre.getText().toString() + " " +
                apellido.getText().toString());

        // Cambiar Actividad
        // Crear una solicitud
        Intent intentito = new Intent(this, Main2Activity.class);
        startActivity(intentito);
    }
}
