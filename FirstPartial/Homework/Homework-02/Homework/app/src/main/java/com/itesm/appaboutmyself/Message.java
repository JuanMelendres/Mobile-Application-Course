package com.itesm.appaboutmyself;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Message extends AppCompatActivity {

    private EditText msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        msg = findViewById(R.id.message);
    }

    public void changeMainMenu(View v) {
        Intent intent = new Intent(this, MainMenu.class);
        String message = msg.getText().toString();
        Toast.makeText(this, "Message sent: " + message, Toast.LENGTH_SHORT).show();
        setResult(Activity.RESULT_OK, intent);
        startActivity(intent);
    }
}
