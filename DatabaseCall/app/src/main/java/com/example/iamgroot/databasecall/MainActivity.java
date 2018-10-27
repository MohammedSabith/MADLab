package com.example.iamgroot.databasecall;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
     SQLiteDatabase db;
    EditText name,usn,phone;
    Button ins,disp;

    List<String> employeeList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(MainActivity.this,new String[] {Manifest.permission.CALL_PHONE},1);
        db = new DbHelper(this).getWritableDatabase();

        name = (EditText)findViewById(R.id.nameText);
        usn = (EditText)findViewById(R.id.usnText);
        phone = (EditText)findViewById(R.id.phoneText);

        ins = (Button)findViewById(R.id.insertB);
        disp = (Button)findViewById(R.id.dispB);

        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                String u = usn.getText().toString();
                String p = phone.getText().toString();

                if(n.equals("") || u.equals("") || p.equals("")) {
                    Toast.makeText(MainActivity.this,"Enter all the values!",Toast.LENGTH_LONG).show();
                }
                else {
                    ContentValues values = new ContentValues();
                    values.put("name",n);
                    values.put("usn",u);
                    values.put("phone",p);

                    db.insert("employee",null,values);
                    Toast.makeText(MainActivity.this,"Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });

        disp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = usn.getText().toString();
                if(u.equals("")) {
                    Toast.makeText(MainActivity.this,"Enter the usn!",Toast.LENGTH_LONG).show();
                }

                else {
                    Cursor cursor = db.rawQuery("select * from employee where usn ='"+u+"'",null);

                    if(cursor.getCount()!=1) {
                        Toast.makeText(MainActivity.this,"No record found",Toast.LENGTH_LONG).show();
                    }
                    else {
                        cursor.moveToNext();
                        String p = cursor.getString(2);
                        try {
                            Intent callIntent = new Intent(Intent.ACTION_CALL);
                            callIntent.setData(Uri.parse("tel:" + p));
                            startActivity(callIntent);
                        }
                        catch (SecurityException e) {
                            Log.e("Error",e.getMessage());
                        }
                    }
                }

            }
        });

    }
}
