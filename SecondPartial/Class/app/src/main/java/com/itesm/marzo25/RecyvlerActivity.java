package com.itesm.marzo25;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.marzo25.R;

import java.util.ArrayList;

public class RecyvlerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyvler);

        recyclerView = findViewById(R.id.recycler);

        // si quiero - fixed size - si sabemos que no cambia esto lo agiliza un poquito
        recyclerView.setHasFixedSize(true);

        // declarar datos - obviamente los pueden obtener de otro lado
        ArrayList<String> datos = new ArrayList<>();
        datos.add("Gus");
        datos.add("Juan");
        datos.add("Richy");
        datos.add("Hector");

        // inicializamos adapter
        StudentAdapter adapter = new StudentAdapter(datos);

        // layout manager
        // define como se va a organizar los elementos del recycler view

        LinearLayoutManager llm = new LinearLayoutManager(this);

        llm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
    }
}
