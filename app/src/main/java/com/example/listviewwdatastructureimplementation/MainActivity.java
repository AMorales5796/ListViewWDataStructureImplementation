package com.example.listviewwdatastructureimplementation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView SongList;
    String[] titles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DoublyLL Songs = new DoublyLL();

        SongList.setAdapter((ListAdapter) Songs);
        Songs.push(2);
        Songs.pushAtEnd(3);
        Songs.pushAtEnd(4);


        Integer[] DLLToArray =  Songs.toArray();

        SongList = findViewById(R.id.SongList);

        //ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, months);
        ArrayAdapter<Integer> songAdapter = new ArrayAdapter<Integer>(this, DLLToArray);

        SongList.setAdapter(songAdapter);
        SongList.setOnItemClickListener(this);

    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //String month = adapterView.getItemAtPosition(i).toString();
        //String month = months[i];
        //String month = ((TextView)view).getText().toString();
        String title = SongList.getItemAtPosition(i).toString();

        Toast.makeText(getApplicationContext(), "Clicked: " + title, Toast.LENGTH_SHORT).show();
    }


}