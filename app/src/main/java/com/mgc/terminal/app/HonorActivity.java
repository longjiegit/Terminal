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
import com.mgc.terminal.Service.VideoService;

public class HonorActivity extends AppCompatActivity {
    private TextView honorON;
    private TextView honorOFF;
    private ImageButton honorHome;
    private ImageButton honorPlay1;
    private ImageButton honorPause1;
    private ImageButton honorStop1;
    private ImageButton honorBackward1;
    private ImageButton honorForward1;
    private ImageButton honorPlay2;
    private ImageButton honorPause2;
    private ImageButton honorStop2;
    private ImageButton honorBackward2;
    private ImageButton honorForward2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.honor_activity);
        honorHome=findViewById(R.id.honor_home);
        honorON=findViewById(R.id.honor_on);
        honorOFF=findViewById(R.id.honor_off);
        honorPlay1=findViewById(R.id.honor_play1);
        honorPause1=findViewById(R.id.honor_pause1);
        honorStop1=findViewById(R.id.honor_stop1);
        honorBackward1=findViewById(R.id.honor_backward1);
        honorForward1=findViewById(R.id.honor_forward1);
        honorPlay2=findViewById(R.id.honor_play2);
        honorPause2=findViewById(R.id.honor_pause2);
        honorStop2=findViewById(R.id.honor_stop2);
        honorBackward2=findViewById(R.id.honor_backward2);
        honorForward2=findViewById(R.id.honor_forward2);
        addListen();
    }

    public void addListen(){
        honorHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(HonorActivity.this, MainActivity.class);
                startActivity(it);
            }
        });
        honorON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComputService c=new ComputService();
                c.computerForZX("1002","on");
            }
        });
        honorOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ComputService c=new ComputService();
                c.computerForZX("1002","off");
            }
        });
        honorPlay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService vs=new VideoService();
                vs.videoForZX("1002","zxplay,1");
            }
        });
        honorPause1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService vs=new VideoService();
                vs.videoForZX("1002","pause");
            }
        });
        honorStop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService vs=new VideoService();
                vs.videoForZX("1002","stop");
            }
        });
        honorBackward1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService vs=new VideoService();
                vs.videoForZX("1002","backward");
            }
        });
        honorForward1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService vs=new VideoService();
                vs.videoForZX("1002","forward");
            }
        });
        honorPlay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService vs=new VideoService();
                vs.videoForZX("1002","zxplay,2");
            }
        });
        honorPause2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService vs=new VideoService();
                vs.videoForZX("1002","pause");
            }
        });
        honorStop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService vs=new VideoService();
                vs.videoForZX("1002","stop");
            }
        });
        honorBackward2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService vs=new VideoService();
                vs.videoForZX("1002","backward");
            }
        });
        honorForward2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoService vs=new VideoService();
                vs.videoForZX("1002","forward");
            }
        });
    }
}
