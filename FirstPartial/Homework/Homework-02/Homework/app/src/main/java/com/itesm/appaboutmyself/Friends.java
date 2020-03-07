package com.itesm.appaboutmyself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Friends extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
    }

    public void changeMainMenu(View v) {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}
