package com.mgc.terminal.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import com.mgc.terminal.R;

import java.io.*;
import java.util.Properties;

public class IPActivity extends AppCompatActivity {

    Properties prop=null;
    EditText ipet;
    EditText portEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_config);

         ipet=findViewById(R.id.ip_et);
         portEt=findViewById(R.id.port_et);
        Button cancle=findViewById(R.id.cancle);
        Button ok=findViewById(R.id.OK);
        prop=new Properties();
        try {
           // InputStream in = getApplicationContext().getAssets().open("prop.properties");

            //prop.load(new InputStreamReader(in, "UTF-8"));

            prop.load(getApplicationContext().openFileInput("prop.properties"));
        }catch (Exception e){
            e.printStackTrace();
        }

        ipet.setText(prop.getProperty("videoIP"));
        portEt.setText(prop.getProperty("videoPort"));

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(IPActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               setValue("videoIP",ipet.getText().toString());
               setValue("videoPort",portEt.getText().toString());
                System.out.println(portEt.getText().toString());
                Intent intent=new Intent(IPActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void  setValue(String key,String value){
        try {
            prop.setProperty (key,value);
            FileOutputStream out = getApplicationContext().openFileOutput("prop.properties", Context.MODE_PRIVATE);
            // FileOutputStream out = new FileOutputStream(configPath);
            prop.store(out, null);

        } catch (Exception e1) {
            e1.printStackTrace();
        } finally {

        }

    }
}
