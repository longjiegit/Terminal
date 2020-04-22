package com.mgc.terminal.app;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mgc.terminal.R;
import com.mgc.terminal.Service.ComputService;

/**
 * 时代见证
 */
public class ShidaiActivity extends AppCompatActivity {
    private TextView shidaiON;
    private TextView shidaiOFF;
    private ImageButton shidaiHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.shidai_activity);
        shidaiON=findViewById(R.id.shidai_on);
        shidaiOFF=findViewById(R.id.shidai_off);
        shidaiHome=findViewById(R.id.shidai_home);
        addListen();
    }

    public void addListen(){
        shidaiHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ShidaiActivity.this, MainActivity.class);
                startActivity(it);
            }
        });
        shidaiON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComputService c=new ComputService();
                c.computerForZX("1003","on");
            }
        });
        shidaiOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComputService c=new ComputService();
                c.computerForZX("1003","off");
            }
        });
    }
}
