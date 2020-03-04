package com.itesm.localstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SharePrefActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private static final String ARCHIVO = "archivito";
    private EditText valorcito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_pref);

        valorcito = findViewById(R.id.valor);
    }

    public void cargar(View v) {
        prefs = getSharedPreferences(ARCHIVO, MODE_PRIVATE);
        Toast.makeText(this, "PREFS CARGADAS", Toast.LENGTH_SHORT).show();
    }

    public void guardar(View v) {
        SharedPreferences.Editor editorcito = prefs.edit();
        editorcito.putString("llavecita", valorcito.getText().toString());
        editorcito.commit();
        Toast.makeText(this, "VALOR GUARDADO EN LLAVECITA", Toast.LENGTH_SHORT).show();
    }

    public void imprimir(View v) {
        Toast.makeText(this,
                "VALOR: " + prefs.getString("llavecita", "SIN VALOR"),
                Toast.LENGTH_SHORT).show();
    }

    public void borrarCampo(View v) {
        SharedPreferences.Editor editorcito = prefs.edit();
        editorcito.remove("llavecita");
        editorcito.commit();
        Toast.makeText(this, "LLAVECITA BORRADA :´(", Toast.LENGTH_SHORT).show();
    }

    public void borrarTodo(View v) {
        SharedPreferences.Editor editorcito = prefs.edit();
        editorcito.clear();
        editorcito.commit();

        Toast.makeText(this, "TODO A MUERTO", Toast.LENGTH_SHORT).show();
    }
}
