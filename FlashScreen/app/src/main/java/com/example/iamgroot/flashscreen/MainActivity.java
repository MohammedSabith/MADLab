package com.example.iamgroot.flashscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e) {
                    Log.e("Error",e.toString());
                }

                finally {
                    startActivity(new Intent(getApplicationContext(),Main2Activity.class));
                    finish();
                }
            }
        }.start();


    }
}
