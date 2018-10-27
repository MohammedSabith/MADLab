package com.example.iamgroot.menuforbg;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.create_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ConstraintLayout cstr = findViewById(R.id.myConstraint);

        switch (item.getItemId()) {
            case R.id.red:
                cstr.setBackgroundColor(Color.rgb(255,0,0));
                return true;

            case R.id.green:
                cstr.setBackgroundColor(Color.rgb(0,255,0));
                return true;

            case R.id.blue:
                cstr.setBackgroundColor(Color.rgb(0,0,255));
                return true;

            default:
                return super.onOptionsItemSelected(item);


        }
    }
}
