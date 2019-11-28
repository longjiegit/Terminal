package com.mgc.terminal.app;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mgc.terminal.R;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.jar.JarEntry;

public class VideoActivity extends AppCompatActivity {
    String ipaddress="192.168.1.106";
    int   port=9999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Properties prop=new Properties();
        try {
            prop.load(getApplicationContext().openFileInput("prop.properties"));
            ipaddress=prop.getProperty("videoIP");
            port=Integer.parseInt(prop.getProperty("videoPort"));
        }catch (Exception e){
            Toast.makeText(this,"获取配置文件失败,请长按图标进行配置!",Toast.LENGTH_LONG).show();
        }

        setContentView(R.layout.activity_video);
        Button film1=findViewById(R.id.v_film1);
        Button film2=findViewById(R.id.v_film2);
        ImageButton pause=findViewById(R.id.v_pause);
        ImageButton play=findViewById(R.id.v_play);
        ImageButton stop=findViewById(R.id.v_stop);
        SeekBar voice=findViewById(R.id.v_voice);
        ImageButton oneplay=findViewById(R.id.v_oneplay);
        ImageButton circle=findViewById(R.id.v_circle);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendCommand("play");
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendCommand("pause");
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendCommand("stop");
            }
        });
        oneplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //单次播放
                sendCommand("oneplay");
            }

        });
        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //循环播放
                sendCommand("circle");
            }
        });

        voice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sendCommand("voice,"+progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
    public void sendCommand(final String command) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {

                    Socket client = new Socket(ipaddress, port);
                    //DataInputStream din=new DataInputStream(new BufferedInputStream(client.getInputStream()));
                    DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
                    dout.write(command.getBytes());
                    dout.flush();
                    client.close();
                }catch (Exception e){
                    e.printStackTrace();
                    Looper.prepare();
                    Toast.makeText(getApplicationContext(),ipaddress+"网络异常，请检查网络配置!",Toast.LENGTH_LONG).show();
                    Looper.loop();
                }

            }

        }.start();

    }

}
