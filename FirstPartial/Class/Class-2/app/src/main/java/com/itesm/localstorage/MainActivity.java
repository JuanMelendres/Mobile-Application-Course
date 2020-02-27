package com.itesm.localstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    private DBHelper db;
    private EditText id, nombre, calificacion;
    // Properties
    // mecanismo propio de java
    // Guarda un archivo con formato llave - dato en almacenamiento local
    // se carga de y hacia un objeto
    private Properties properties;
    private static final String PROPERTIES_FILE = "properties.xml";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = findViewById(R.id.Id);
        nombre = findViewById(R.id.nombre);
        calificacion = findViewById(R.id.calificacion);

        // Usando BD local en sqlite
        db = new DBHelper(this);

        properties = new Properties();
        Log.wtf("ARCHIVOS", getFilesDir().toString());
        File file = new File(getFilesDir(), PROPERTIES_FILE);

        if (file.exists()) {
            Toast.makeText(this, "EXISTE ARCHIVO", Toast.LENGTH_SHORT).show();
            try {
                // Cargar a objeto
                FileInputStream fis = openFileInput(PROPERTIES_FILE);
                properties.loadFromXML(fis);
                fis.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            Toast.makeText(this, "NO EXISTE ARCHIVO", Toast.LENGTH_SHORT).show();;
        }
    }

    private void saveProperties() {
        try {
            FileOutputStream fos = openFileOutput(PROPERTIES_FILE, Context.MODE_PRIVATE);
            properties.storeToXML(fos, null);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void guardar(View v) {
        db.save(nombre.getText().toString(), Integer.parseInt(calificacion.getText().toString()));
        nombre.setText("");
        calificacion.setText("");
        Toast.makeText(this, "GUARDADO, SUPUESTAMENTE", Toast.LENGTH_SHORT).show();
    }

    public void borrar(View v) {
        int rows = db.delete(nombre.getText().toString());
        Toast.makeText(this, "Filas afectadas" + rows, Toast.LENGTH_SHORT).show();
    }

    public void buscar(View v) {
        int calificacioncita = db.find(nombre.getText().toString());
        calificacion.setText(calificacioncita + "");
    }

    public void guardarMemoria(View v) {
        properties.put("ejemplo", "un magnifico y extraordinario valor");
        Toast.makeText(this, "PROPIEDAD GUARDADA", Toast.LENGTH_SHORT).show();
    }

    public void guardarAlmacenameinto(View v) {
        saveProperties();
        Toast.makeText(this, "ARCHIVO GUARDADO", Toast.LENGTH_SHORT).show();
    }

    public void imprimirPropiedad(View v) {
        Toast.makeText(this, "VALOR DE PROPIEDAD: " +
                properties.get("ejemplo"),
                Toast.LENGTH_SHORT).show();
    }
}
