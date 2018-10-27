package com.example.iamgroot.callphone;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText num;
    Button call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this,new String[] {Manifest.permission.CALL_PHONE},1);

        num = (EditText)findViewById(R.id.phoneText);
        call = (Button)findViewById(R.id.button);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneString = num.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:" + phoneString));

                try {
                    startActivity(callIntent);
                }
                catch (SecurityException e) {
                    Log.e("Erro",e.getMessage());
                }
            }
        });
    }
}
