package com.itesm.marzo25;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.marzo25.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements Fragmentito2Fragment.Callback, Handler.Callback {

    private Handler dataHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentitoFragment fragmentito = new FragmentitoFragment();
        Fragmentito2Fragment fragmentito2 = Fragmentito2Fragment.newInstance("Fido", 5, 30);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.contenedor, fragmentito2, "fragmento");
        transaction.commit();

        fragmentito2.saludar();

        Toast.makeText(this, getString(R.string.saludo), Toast.LENGTH_LONG).show();

        // JSON
        // notacion ligera para intercambio de informacion
        // comunmente utilizado en web
        String jsonTest = "{'nombre':'Juan', 'edad':20}";
        String jsonTest2 = "{'nombre':'Pedro', 'calificaciones':[89, 92, 70, 88]}";
        String jsonTest3 = "[{'nombre':'Juan', 'edad':20}, {'nombre':'Pedro', 'edad':19}, {'nombre':'Maria', 'edad':21}]";

        try {
            JSONObject objeto = new JSONObject(jsonTest);
            Log.wtf("JSON", objeto.getString("nombre"));
            Log.wtf("JSON", objeto.getInt("edad") + "");

            JSONObject objeto2 = new JSONObject(jsonTest2);
            JSONArray calificaciones = objeto2.getJSONArray("calificaciones");

            for(int i = 0; i < calificaciones.length(); i++){

                Log.wtf("JSON", calificaciones.getInt(i) + "");
            }

            JSONArray objeto3 = new JSONArray(jsonTest3);
            for(int i = 0; i < objeto3.length(); i++){

                JSONObject actual = objeto3.getJSONObject(i);
                Log.wtf("JSON", actual.getString("nombre"));
                Log.wtf("JSON", actual.getInt("edad") + "");
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        dataHandler = new Handler(Looper.getMainLooper(), this);
    }

    public void swapFragments(View v){

        // objetivo - quitar fragmento inicial, poner nuevo
        FragmentManager manager = getSupportFragmentManager();
        Fragment f = manager.findFragmentByTag("fragmento");

        if(f != null){

            FragmentitoFragment nuevo = new FragmentitoFragment();

            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(f);
            transaction.add(R.id.contenedor, nuevo, "fragmento");
            transaction.commit();
        }

    }

    @Override
    public void ejecutarAccion() {

        Toast.makeText(this, "METODO DE INTERFAZ LLAMADO", Toast.LENGTH_SHORT).show();
    }

    public void request(View v){

        Request r = new Request("https://api.github.com/users", dataHandler);
        r.start();
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {

        JSONArray datos = (JSONArray) msg.obj;
        Toast.makeText(this, datos.toString(), Toast.LENGTH_SHORT).show();
        return true;
    }
}