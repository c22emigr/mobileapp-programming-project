package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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

    private Intent knopp;
    private Button button1;


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
