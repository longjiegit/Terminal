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

/**
 * 共书寄语
 */
public class JiyuActivity extends AppCompatActivity {
    private TextView jiyuON;
    private TextView jiyuOFF;
    private ImageButton jiyuHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.jiyu_activity);
        jiyuON=findViewById(R.id.jiyu_on);
        jiyuOFF=findViewById(R.id.jiyu_off);
        jiyuHome=findViewById(R.id.jiyu_home);
        addListen();
    }
    public void addListen(){
        jiyuHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(JiyuActivity.this, MainActivity.class);
                startActivity(it);
            }
        });
        jiyuON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComputService c=new ComputService();
                c.computerForZX("1007","on");
            }
        });
        jiyuOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComputService c=new ComputService();
                c.computerForZX("1007","off");
            }
        });
    }
}
