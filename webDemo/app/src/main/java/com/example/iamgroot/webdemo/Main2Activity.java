package com.example.iamgroot.webdemo;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ActivityCompat.requestPermissions(Main2Activity.this, new String[]{Manifest.permission.INTERNET},1);
        wv = (WebView)findViewById(R.id.wv);
        wv.setWebViewClient(new WebViewClient());
        //wv.setWebViewClient(new WebViewClient());

        Intent i = getIntent();
        String url = i.getStringExtra("load");

        if(url.equals("defaultPage")) {
            wv.loadUrl("https://www.google.com");
        }
        else {
            wv.loadUrl("https://"+url);
        }
    }
}
