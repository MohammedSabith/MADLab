package com.example.iamgroot.sharedprefdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String prefName = "pName";
    String prefTag = "pTag";

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText)findViewById(R.id.editText);

        pref = getSharedPreferences(prefName,Context.MODE_PRIVATE);
        text.setText(pref.getString(prefTag,""));

    }

    @Override
    protected void onPause() {
        super.onPause();

        editor = pref.edit();
        editor.putString(prefTag,text.getText().toString()).commit();
    }
}
