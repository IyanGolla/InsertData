package com.example.insertdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;

    EditText surname;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        name = findViewById(R.id.editTextTextPersonName);
        surname = findViewById(R.id.sid);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBH dbhelper = new DBH(MainActivity.this);
                boolean result = dbhelper.insertData(name.getText().toString(), surname.getText().toString());
                if (result) {
                    Toast.makeText(MainActivity.this, "Insert is Successful", Toast.LENGTH_LONG).show();
                } else
                    Toast.makeText(MainActivity.this, "Insert has failed", Toast.LENGTH_LONG).show();
            }
        });
    }

    }


