package com.itesm.marzo25;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.Contacts;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragmentito2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmentito2Fragment extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String NOMBRE = "nombre";
    private static final String EDAD = "edad";
    private static final String PESO = "peso";

    private String nombre;
    private float edad, peso;
    private Context context;
    private Callback listener;

    public Fragmentito2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param nombre Parameter 1.
     * @param edad Parameter 2.
     * @param peso Parameter 3.
     * @return A new instance of fragment Fragmentito2Fragment.
     */
    public static Fragmentito2Fragment newInstance(String nombre, float edad, float peso) {
        Fragmentito2Fragment fragment = new Fragmentito2Fragment();
        Bundle args = new Bundle();
        args.putString(NOMBRE, nombre);
        args.putFloat(EDAD, edad);
        args.putFloat(PESO, peso);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nombre = getArguments().getString(NOMBRE);
            edad = getArguments().getFloat(EDAD);
            peso = getArguments().getFloat(PESO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragmentito2, container, false);
        TextView textito1 = v.findViewById(R.id.textView3);
        TextView textito2 = v.findViewById(R.id.textView4);
        TextView textito3 = v.findViewById(R.id.textView5);

        Button botoncito = v.findViewById(R.id.button2);
        botoncito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.ejecutarAccion();
            }
        });

        textito1.setText(nombre);
        textito2.setText(edad + "");
        textito3.setText(peso + "");

        return v;
    }

    public void saludar() {
        Log.wtf("7AM", "Hola buenos dias");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;

        if (context instanceof Callback) {
            listener = (Callback) context;
        }
        else {
            throw new RuntimeException("Tratando de anexar una actividad que no puede escucharme");
        }
    }

    public interface Callback {
        public void ejecutarAccion();
    }
}
