package com.itesm.appaboutmyself;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    private static final int HOBBIES_CODE = 1;

    private TextView salute, hobbies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Intent intent = getIntent();
        String message = "Hi " + intent.getStringExtra("userName");

        salute = findViewById(R.id.salute);
        hobbies = findViewById(R.id.hobbies);

        salute.setText(message);
        hobbies.setText("");
    }

    public void changeHobbies(View v) {
        Intent intent = new Intent(this, Hobbies.class);
        startActivityForResult(intent, HOBBIES_CODE);
    }

    public void changeFriends(View v) {
        Intent intent = new Intent(this, Friends.class);
        startActivity(intent);
    }

    public void changeMessage(View v) {
        Intent intent = new Intent(this, Message.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == HOBBIES_CODE) {
            if (resultCode == RESULT_OK) {
                hobbies.setText(data.getStringExtra("hobbies"));
            }
        }
    }


}