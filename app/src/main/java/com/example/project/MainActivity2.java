package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {

    String Name;
    int Number;

    private TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            Name = extras.getString("name");
            Number = extras.getInt("number");
            textview = findViewById(R.id.textView1);
            textview.setText(Name+Number);
        }
    }
}