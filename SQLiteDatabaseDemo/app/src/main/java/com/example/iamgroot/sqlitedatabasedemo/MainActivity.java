package com.example.iamgroot.sqlitedatabasedemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;

    EditText name,usn;
    Button ins,disp;

    ArrayAdapter<String> adapter;
    List<String> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBhelper(this).getWritableDatabase();
        name = (EditText)findViewById(R.id.nameText);
        usn = (EditText)findViewById(R.id.usnText);

        ins =(Button) findViewById(R.id.insertB);
        disp = (Button) findViewById(R.id.dispB);

        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myName = name.getText().toString();
                String myUsn = usn.getText().toString();

                if(myName.equals("")||myUsn.equals("")){
                    Toast.makeText(MainActivity.this,"Enter the values",Toast.LENGTH_LONG).show();
                }
                else
                {
                    ContentValues values = new ContentValues();
                    values.put("name",myName);
                    values.put("usn",myUsn);
                    db.insert("student",null,values);
                    Toast.makeText(MainActivity.this,"Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });

        disp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentList = new ArrayList<String>();

                Cursor cursor = db.rawQuery("select * from student",null);

                if(cursor.getCount()<=0) {
                    Toast.makeText(MainActivity.this,"No tuples in the table",Toast.LENGTH_LONG).show();
                }
                else {
                    for(int i=0;i<cursor.getCount();i++) {
                        cursor.moveToNext();
                        String stud = "Name:"+cursor.getString(0)+"\n USN:"+cursor.getString(1);
                        studentList.add(stud);
                    }
                    adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.student_list,R.id.textView,studentList);
                    ListView listView = (ListView)findViewById(R.id.listView);
                    listView.setAdapter(adapter);
                }
            }
        });
    }
}
