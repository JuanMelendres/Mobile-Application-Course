package com.itesm.appaboutmyself;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.name);
    }

    public void changeMainMenu(View v) {
        Intent intent = new Intent(this, MainMenu.class);
        String name = input.getText().toString();
        intent.putExtra("userName", name);
        startActivity(intent);
    }
}
