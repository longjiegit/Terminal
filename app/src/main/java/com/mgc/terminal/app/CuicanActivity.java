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
import com.mgc.terminal.Service.VideoService;

/**
 * 璀璨荣光
 */
public class CuicanActivity extends AppCompatActivity {
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
        rightTitle=findViewById(R.id.info_title);
        rightTitle.setText("璀璨荣光");
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
                Intent it = new Intent(CuicanActivity.this, MainActivity.class);
                startActivity(it);
            }
        });
        commON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComputService c=new ComputService();
                c.computerForZX("1005","on");
            }
        });
        commOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComputService c=new ComputService();
                c.computerForZX("1005","off");
            }
        });
        commPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService vs=new VideoService();
                vs.videoForZX("1005","play");
            }
        });
        commPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService vs=new VideoService();
                vs.videoForZX("1005","pause");
            }
        });
        commStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService vs=new VideoService();
                vs.videoForZX("1005","stop");
            }
        });
        commBackward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService vs=new VideoService();
                vs.videoForZX("1005","backward");
            }
        });
        commForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService vs=new VideoService();
                vs.videoForZX("1005","forward");
            }
        });
    }
}
