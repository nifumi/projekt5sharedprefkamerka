package com.example.projekt5sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView txtVieww;
    Button btnLogout;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtVieww = findViewById(R.id.txtView);
        btnLogout = findViewById(R.id.btnLogout);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME, null);

        if (name != null) {
            //set the data on textview
            txtVieww.setText("Twoje imię - " + name);
        }
        //call button to log out

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(MainActivity2.this, "Log out succesfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}