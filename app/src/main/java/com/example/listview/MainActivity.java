package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listviewwdatastructureimplementation.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView SongList;
    String[] DLLToArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DoublyLL Songs = new DoublyLL();
        Songs.push("AAA");
        Songs.pushAtEnd("BB");
        Songs.pushAtEnd("C");
        Songs.push("ok");


        DLLToArray =  Songs.toArray();

        SongList = findViewById(R.id.SongList);

        ArrayAdapter<String> songAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,DLLToArray);

        SongList.setAdapter(songAdapter);
        SongList.setOnItemClickListener(this);

    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        String title = SongList.getItemAtPosition(i).toString();

        Toast.makeText(getApplicationContext(), "Clicked: " + title, Toast.LENGTH_SHORT).show();
    }


}