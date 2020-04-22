package com.mgc.terminal.app;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.mgc.terminal.R;
import com.mgc.terminal.Service.JDService;

public class MainActivity extends AppCompatActivity {
    private TextView gs;
    private TextView honor;
    private TextView shidai;
    private TextView yeji;
    private TextView cuican;
    private TextView hexin;
    private TextView jiyu;
    private Button keyOpen;
    private Button keyClose;
    private Button lightOpen;
    private Button lightClose;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.main_activity);
        gs=findViewById(R.id.gs);
        honor=findViewById(R.id.honor);
        shidai=findViewById(R.id.shidai);
        yeji=findViewById(R.id.yeji);
        cuican=findViewById(R.id.cuican);
        hexin=findViewById(R.id.hexin);
        jiyu=findViewById(R.id.jiyu);
        keyOpen=findViewById(R.id.keyopen);
        keyClose=findViewById(R.id.keyclose);
        lightOpen=findViewById(R.id.lightopen);
        lightClose=findViewById(R.id.lightclose);
        addListen();
    }

    public void addListen(){
        gs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(it);
            }
        });
        shidai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, ShidaiActivity.class);
                startActivity(it);
            }
        });
        honor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, HonorActivity.class);
                startActivity(it);
            }
        });
        cuican.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, CuicanActivity.class);
                startActivity(it);
            }
        });
        hexin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, HexinActivity.class);
                startActivity(it);
            }
        });
        jiyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, JiyuActivity.class);
                startActivity(it);
            }
        });
        keyOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("open");
                JDService jdService=new JDService();
                jdService.onkeyStart();
            }
        });
        keyClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JDService jdService=new JDService();
                jdService.onkeyClose();
            }
        });
        lightOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JDService jdService=new JDService();
                jdService.lightOnAndOFF("on");
            }
        });
        lightClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JDService jdService=new JDService();
                jdService.lightOnAndOFF("off");
            }
        });
    }
}
