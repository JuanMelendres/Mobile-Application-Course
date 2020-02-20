package com.itesm.aplicacioncita;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textito;
    private EditText nombre, apellido;
    private Button botoncito, botoncito2;

    public static final int ACTIVIDAD2_CODE = 0;

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
        //startActivity(intentito);
        intentito.putExtra("nombre", nombre.getText().toString());
        intentito.putExtra("apellido", apellido.getText().toString());

        startActivityForResult(intentito, ACTIVIDAD2_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ACTIVIDAD2_CODE && resultCode == Activity.RESULT_OK) {
            Toast.makeText(
                    this,
                    "Terminado"
                            + data.getStringExtra("info")
                            + data.getIntExtra("pruebaEntero", 0),
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}
