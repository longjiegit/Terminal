package com.mgc.terminal.app;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mgc.terminal.R;
import com.mgc.terminal.Service.ComputService;

public class HexinActivity extends AppCompatActivity {
    private TextView hexinON;
    private TextView hexinOFF;
    private ImageButton hexinHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.hexin_activity);
        hexinON=findViewById(R.id.hexin_on);
        hexinOFF=findViewById(R.id.hexin_off);
        hexinHome=findViewById(R.id.hexin_home);
        addListen();
    }
    public void addListen(){
        hexinHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(HexinActivity.this, MainActivity.class);
                startActivity(it);
            }
        });
        hexinON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComputService c=new ComputService();
                c.computerForZX("1006","on");
            }
        });
        hexinOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComputService c=new ComputService();
                c.computerForZX("1006","off");
            }
        });
    }
}
