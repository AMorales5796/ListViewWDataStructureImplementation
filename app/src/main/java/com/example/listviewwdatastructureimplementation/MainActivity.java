package com.example.listviewwdatastructureimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity{

    ListView SongList;
    DoublyLL Songs = new DoublyLL();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SongList = findViewById(R.id.SongList);

        ArrayAdapter<String> songAdapter;
        songAdapter = new ArrayAdapter<DoublyLL>(this, android.R.layout.simple_list_item_1, Songs);
        SongList.setAdapter(songAdapter);
    }
}