package com.itesm.activity2_1;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ViewFriend extends AppCompatActivity {

    private TextView nameTV,
            hobbyTV,
            ageTV,
            phoneTV,
            addressTV;
    private String name;
    private String hobby;
    private Integer age;
    private String phone;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_friend);

        nameTV  = findViewById(R.id.textView6);
        hobbyTV = findViewById(R.id.textView7);
        ageTV   = findViewById(R.id.textView8);
        phoneTV = findViewById(R.id.textView9);
        addressTV = findViewById(R.id.textView10);
        name    = getIntent().getStringExtra("name");
        hobby   = getIntent().getStringExtra("hobby");
        age     = getIntent().getIntExtra("age", -1);
        phone   = getIntent().getStringExtra("phone");
        address = getIntent().getStringExtra("address");

        nameTV.setText(name);
        hobbyTV.setText(hobby);
        ageTV.setText(age + "");
        phoneTV.setText(phone);
        addressTV.setText(address);
    }
}