package com.mgc.terminal.app;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.icu.text.IDNA;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.mgc.terminal.R;
import com.mgc.terminal.Service.ComputService;
import com.mgc.terminal.Service.VideoService;

/**
 * 公司概况
 */
public class InfoActivity extends AppCompatActivity {
    private TextView rightTitle;
    private TextView commON;
    private TextView commOFF;
    private ImageButton commPlay;
    private ImageButton commPause;
    private ImageButton commStop;
    private ImageButton commBackward;
    private ImageButton commForward;
    private ImageButton commHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.gsinfo_activity);
        rightTitle=findViewById(R.id.gs_title);
        commON=findViewById(R.id.gs_on);
        commOFF=findViewById(R.id.gs_off);
        commPlay=findViewById(R.id.comm_play);
        commPause=findViewById(R.id.comm_pause);
        commStop=findViewById(R.id.comm_stop);
        commBackward=findViewById(R.id.comm_backward);
        commForward=findViewById(R.id.comm_forward);
        commHome=findViewById(R.id.comm_home);

        addListen();
    }
    public void addListen(){
        commHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(InfoActivity.this, MainActivity.class);
                startActivity(it);
            }
        });
        commON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComputService c=new ComputService();
                c.computerForZX("1001","on");
            }
        });
        commOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComputService c=new ComputService();
                c.computerForZX("1001","off");
            }
        });
        commPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService vs=new VideoService();
                vs.videoForZX("1001","play");
            }
        });
        commPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService vs=new VideoService();
                vs.videoForZX("1001","pause");
            }
        });
        commStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService vs=new VideoService();
                vs.videoForZX("1001","stop");
            }
        });
        commBackward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService vs=new VideoService();
                vs.videoForZX("1001","backward");
            }
        });
        commForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService vs=new VideoService();
                vs.videoForZX("1001","forward");
            }
        });
    }
}
