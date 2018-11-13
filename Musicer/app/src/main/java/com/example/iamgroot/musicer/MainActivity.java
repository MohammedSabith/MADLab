package com.example.iamgroot.musicer;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button pl,st,ch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pl = (Button)findViewById(R.id.playB);
        st = (Button)findViewById(R.id.stopB);
        ch = (Button)findViewById(R.id.bgB);

        pl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(),MusicService.class));
            }
        });

        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(),MusicService.class));
            }
        });

        ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstraintLayout cx = (ConstraintLayout)findViewById(R.id.ctx);
                Random gen = new Random();
                cx.setBackgroundColor(Color.rgb(gen.nextInt(255),gen.nextInt(255),gen.nextInt(255)));
            }
        });
    }
}
