package com.example.iamgroot.broadcaasht;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    ProgressBar pb;
    BroadcastReceiver brc;

    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(brc,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(brc);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView)findViewById(R.id.textView);
        pb = (ProgressBar)findViewById(R.id.progressBar);

        brc = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
                txt.setText(String.valueOf(level));
                pb.setProgress(level);

                ConstraintLayout cx = (ConstraintLayout)findViewById(R.id.cx);

                if(level > 60) {
                    cx.setBackgroundColor(Color.rgb(0,255,0));
                }
                else if(level > 30) {
                    cx.setBackgroundColor(Color.rgb(0,0,255));
                }
                else{
                    cx.setBackgroundColor(Color.rgb(255,0,0));
                }

            }
        };



    }
}
