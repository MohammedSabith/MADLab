package com.example.iamgroot.loglifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Life Cycle","started");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Life Cycle","Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Life Cycle","Stopped");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Life cycle","Resumed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Life Cycle","Destroyed");
    }
}
