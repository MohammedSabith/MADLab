package com.example.iamgroot.sendsms;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button send;
    EditText num,msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        send = (Button)findViewById(R.id.button);
        num = (EditText)findViewById(R.id.phoneText);
        msg = (EditText)findViewById(R.id.msgText);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneString = num.getText().toString();
                String msgString = msg.getText().toString();

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+phoneString));
                intent.putExtra("sms_body",msgString);
                startActivity(intent);
            }
        });
    }
}
