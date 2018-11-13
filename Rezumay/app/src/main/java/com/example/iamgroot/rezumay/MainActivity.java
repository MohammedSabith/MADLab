package com.example.iamgroot.rezumay;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText n;
    RadioGroup group;
    RadioButton gen;
    CheckBox s,p;
    ListView listView;
    Button bt;
    ArrayAdapter<String> adapter;
    ArrayList<String> details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n = (EditText)findViewById(R.id.nameT);
        group = (RadioGroup)findViewById(R.id.radioGroup);
        s = (CheckBox)findViewById(R.id.ten);
        p = (CheckBox)findViewById(R.id.pu);
        bt = (Button)findViewById(R.id.button);
        listView = (ListView)findViewById(R.id.listView);
        details = new ArrayList<String>();

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                details.add("Name : "+n.getText().toString());
                int id = group.getCheckedRadioButtonId();
                gen = (RadioButton)findViewById(id);
                details.add("Gender:"+gen.getText().toString());
                String quali = getQualifications();
                details.add(quali);
                adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.show_data,R.id.textView,details);
                listView.setAdapter(adapter);
            }
        });





    }

    public String getQualifications() {
        String qualifications="Qualifications are : ";
        if(s.isChecked())
            qualifications += "SSLC ";
        if(p.isChecked())
            qualifications += "PUC ";
        return qualifications;
    }
}
