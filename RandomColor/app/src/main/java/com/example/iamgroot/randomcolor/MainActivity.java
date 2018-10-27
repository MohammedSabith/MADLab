package com.example.iamgroot.randomcolor;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ConstraintLayout cstr = (ConstraintLayout) findViewById(R.id.myConstraint);
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random gen = new Random();
                cstr.setBackgroundColor(Color.rgb(gen.nextInt(256),gen.nextInt(256),gen.nextInt(256)));

            }
        });
    }

}
