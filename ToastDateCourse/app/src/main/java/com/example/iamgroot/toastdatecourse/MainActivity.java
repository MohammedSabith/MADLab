package com.example.iamgroot.toastdatecourse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] mobileArray = {
            "CSE","ECE","ISE","EEE","BTE","MECH"
    };

    ArrayAdapter<String> adapter;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<>(this,R.layout.create_list,R.id.myText,mobileArray);

        datePicker = (DatePicker) findViewById(R.id.datePicker);

        ListView listView = findViewById(R.id.myList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String course = adapter.getItem(i);
                String dateString = datePicker.getDayOfMonth()+"/"+(1+datePicker.getMonth())+"/"+datePicker.getYear();
                Toast.makeText(MainActivity.this,"Selected couse : "+course+" \nJoined on :"+dateString,Toast.LENGTH_LONG).show();
            }
        });
    }
}
