package com.itesm.appaboutmyself;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Hobbies extends AppCompatActivity {
    
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobbies);
        input = findViewById(R.id.input);
    }

    public void changeMainMenu(View v) {
        Intent intent = new Intent();
        String hobby = input.getText().toString();
        intent.putExtra("hobbies", hobby);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
