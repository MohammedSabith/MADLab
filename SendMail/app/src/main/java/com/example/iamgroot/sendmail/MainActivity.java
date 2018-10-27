package com.example.iamgroot.sendmail;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText id,sub,msg;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (EditText)findViewById(R.id.eid);
        sub = (EditText)findViewById(R.id.subj);
        msg = (EditText)findViewById(R.id.msg);

        send = (Button)findViewById(R.id.button);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emid = id.getText().toString();
                String subs = sub.getText().toString();
                String msgs = msg.getText().toString();

                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT,subs);
                i.putExtra(Intent.EXTRA_TEXT,msgs);
                i.setData(Uri.parse("mailto:"+emid));
                startActivity(i);
            }
        });

    }
}
