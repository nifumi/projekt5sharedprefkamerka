package com.example.projekt5sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTxt;
    Button btn1;
    SharedPreferences sharedPreferences;

    //create a shared pref name and key name
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTxt = findViewById(R.id.editTxt);
        btn1 = findViewById(R.id.btn1);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        //before opening another activity, first check if data in shared prefs is available or not
        String name = sharedPreferences.getString(KEY_NAME, null);

        if (name != null) {
            //if fata is available, directly call on MainActivity2
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when click on button, put data on shared prefs
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME, editTxt.getText().toString());
                editor.apply();
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
            }
        });
    }
}