package com.itesm.marzo25;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Fragmentito2Fragment.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentitoFragment fragmentito = new FragmentitoFragment();
        Fragmentito2Fragment fragmentito2 = Fragmentito2Fragment.newInstance("Fido", 5, 30);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //transaction.add(R.id.contenedor, fragmentito, "fragmento");
        transaction.add(R.id.contenedor, fragmentito2, "fragmento");
        transaction.commit();

        fragmentito2.saludar();
    }

    @Override
    public void ejecutarAccion() {
        Toast.makeText(this, "Metodo de interfaz llamado", Toast.LENGTH_SHORT).show();
    }
}
