package com.itesm.aplicacioncita;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView textito1, textito2;
    EditText info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textito1 = findViewById(R.id.n);
        textito2 = findViewById(R.id.a);
        info = findViewById(R.id.info);

        Intent intentote = getIntent();

        textito1.setText(intentote.getStringExtra("nombre"));
        textito2.setText(intentote.getStringExtra("apellido"));
    }

    public void finDeActividad(View v) {
        Intent intent = new Intent();

        intent.putExtra("info", info.getText().toString());
        intent.putExtra("pruebaEntero", 5);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
