package com.mgc.terminal.app;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.illposed.osc.OSCBundle;
import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPortOut;
import com.mgc.terminal.R;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class OSCActivity extends AppCompatActivity {
    public  static InetAddress ipAddr;
    public  static Integer port;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.osc);

        try {
            /*------------------------------设置要发送的目标主机的IP地址------------------------------------*/
            ipAddr = InetAddress.getByName("192.168.1.20");
            /*------------------------------设置要发送的目标主机的端口------------------------------------*/
            port = 7000;
            Log.e("---------","osc 192.168.1.20");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


        Button film1=findViewById(R.id.film1);
        Button film2=findViewById(R.id.film2);
        ImageButton pause=findViewById(R.id.pause);
        ImageButton play=findViewById(R.id.play);
        SeekBar voice=findViewById(R.id.voice);
        ImageButton oneplay=findViewById(R.id.oneplay);
        ImageButton circle=findViewById(R.id.circle);

        film1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List args=new ArrayList();
                args.add(1);
                sendOSCMsg("/composition/layers/1/clips/1/connect",args);
            }
        });
        film2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List args=new ArrayList();
                args.add(1);
                sendOSCMsg("/composition/layers/1/clips/2/connect",args);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List args=new ArrayList();
                args.add(1);
                sendOSCMsg("/composition/selectedclip/transport/position/behaviour/playdirection",args);
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List args=new ArrayList();
                args.add(2);
                sendOSCMsg("/composition/selectedclip/transport/position/behaviour/playdirection",args);
            }
        });
        oneplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List args=new ArrayList();
                args.add(3);
                sendOSCMsg("/composition/selectedclip/transport/position/behaviour/playmode",args);
            }
        });
        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List args=new ArrayList();
                args.add(0);
                sendOSCMsg("/composition/selectedclip/transport/position/behaviour/playmode",args);
            }
        });
        voice.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.e("--------","--"+progress);
                float v=(float)progress/100;
                DecimalFormat format=new DecimalFormat(".00");
                float arg=Float.parseFloat(format.format(v));
                List args=new ArrayList();
                args.add(arg);
                sendOSCMsg("/composition/selectedlayer/audio/volume",args);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }

    public  void sendOSCMsg(String address, List<Object> args){
        try {
            final OSCPortOut  out = new OSCPortOut(ipAddr, port);
            //包装消息
            OSCMessage message = new OSCMessage();
            //osc地址
            message.setAddress(address);
            //oscdata
            for(Object arg:args){
                message.addArgument(arg);
            }
            //给箱子套上一个保护袋
            final OSCBundle pack = new OSCBundle();
            pack.addPacket(message);
            //把打包好的东西送走
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    try{
                        out.send(pack);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }.start();

        } catch (IOException e) {
            System.out.println("有错误吗？");
            e.printStackTrace();
        }
    }
}
