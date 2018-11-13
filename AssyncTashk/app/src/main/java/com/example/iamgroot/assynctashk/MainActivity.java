package com.example.iamgroot.assynctashk;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    ProgressBar pb;
    TextView txt;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar)findViewById(R.id.progressBar);
        txt = (TextView)findViewById(R.id.textView);
        bt = (Button)findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pb.setProgress(0);

                new AsyncTask<String,Integer,String>() {

                    @Override
                    protected String doInBackground(String... strings) {

                        int i = 0;
                        int max = Integer.parseInt(strings[0]);

                        while(i<max) {
                            try{
                                Thread.sleep(100);
                                i++;
                                publishProgress(i);
                            }
                            catch (Exception e) {
                                Log.e("Error",e.getMessage());
                            }
                        }

                        return null;
                    }

                    @Override
                    protected void onProgressUpdate(Integer... values) {
                        super.onProgressUpdate(values);
                        pb.setProgress(values[0]);
                        txt.setText(values[0].toString());
                    }
                }.execute("100");
            }
        });

    }
}
