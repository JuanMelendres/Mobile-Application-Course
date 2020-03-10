package com.itesm.appwithdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText userName;
    private static final String FILE = "filename";
    private SharedPreferences prefs;
    private TextView salute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.user);
        salute = findViewById(R.id.salute);
        loadFile();
    }

    public void loadFile() {
        prefs = getSharedPreferences(FILE, MODE_PRIVATE);
        Toast.makeText(this, "Prefs loadded" +
                prefs.getString("username", "stranger"),
                Toast.LENGTH_SHORT).show();
        salute.setText("Welcome & Hi " + prefs.getString("username", "stranger"));
    }

    public void save(View V) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("username", userName.getText().toString());
        editor.commit();
    }

    public void deleteAll(View V) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.commit();
        Toast.makeText(this, "Prefs Deleted" +
                        prefs.getString("username", "stranger"),
                Toast.LENGTH_SHORT).show();
        salute.setText("Welcome & Hi " + prefs.getString("username", "stranger"));
    }

    public void mainMenu(View V) {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }


}
