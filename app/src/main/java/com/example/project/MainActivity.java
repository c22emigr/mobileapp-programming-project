package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=c22emigr";
    private RecyclerView RecyclerView;
    private ArrayList<Bergen> Berg;
    private RecyclerViewAdapter Adaptern;

    TextView TextView;
    Button Buttonknapp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonTask(this).execute(JSON_URL);

        RecyclerView = findViewById(R.id.RecyclerViewId);
        Berg = new ArrayList<Bergen>();
        Adaptern = new RecyclerViewAdapter(Berg);
        RecyclerView.setAdapter(Adaptern);
        RecyclerView.setLayoutManager(new LinearLayoutManager(this));


        /* Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); */


        Buttonknapp = findViewById(R.id.Button1);
        Buttonknapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(Intent);
            }
        });

    }


    @Override
    public void onPostExecute(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Bergen>>() {}.getType();
        ArrayList<Bergen> data = gson.fromJson(json, type);
        Berg.addAll(data);
        Adaptern.notifyDataSetChanged();
    }
}
