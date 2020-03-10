package com.itesm.appwithdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class MainMenu extends AppCompatActivity {

    private DBHobbies dbhobby;
    private EditText name, hobby;
    private Properties prop;
    private static final String PROP_FILE = "properties.xml";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        name = findViewById(R.id.friend);
        hobby = findViewById(R.id.hobby);

        dbhobby = new DBHobbies(this);
        prop = new Properties();
        Log.wtf("FILEs", getFilesDir().toString());
        File file = new File(getFilesDir(), PROP_FILE);

        if (file.exists()) {
            Toast.makeText(this, "Files Exist", Toast.LENGTH_SHORT).show();
            try {
                FileInputStream fis = openFileInput(PROP_FILE);
                prop.loadFromXML(fis);
                fis.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            Toast.makeText(this, "File Doesn´t Exist", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveProps() {
        try{
            FileOutputStream fos = openFileOutput(PROP_FILE, Context.MODE_PRIVATE);
            prop.storeToXML(fos,null);
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void SaveInDB(View v) {
        dbhobby.save(name.getText().toString(), hobby.getText().toString());
        Toast.makeText(this, "Fiend: " + name.getText().toString() +
                " Hobby: " + hobby.getText().toString() + "save",
                Toast.LENGTH_SHORT).show();
        name.setText("");
        hobby.setText("");
    }

    public void deleteInDB(View v) {
        int row = dbhobby.delete(name.getText().toString());
        Toast.makeText(this, "Removed " + row + " rows ", Toast.LENGTH_SHORT).show();
        name.setText("");
        hobby.setText("");
    }

    public void findInDB(View v) {
        hobby.setText(dbhobby.find(name.getText().toString()));
    }

    public void mainActivity(View V) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
