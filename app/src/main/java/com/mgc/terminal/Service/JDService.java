package com.mgc.terminal.Service;

import com.alibaba.fastjson.JSON;
import com.mgc.terminal.bean.CommModel;

import java.io.BufferedWriter;
import java.net.Socket;

public class JDService extends BaseService {
    public void onkeyStart(){
        Thread t=new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    Socket s=getSocket();
                    CommModel model=new CommModel();
                    model.setType("command");
                    model.setCommObj("jd");
                    model.setData("on");
                    String c= JSON.toJSONString(model);
                    BufferedWriter bw =getBw(s);
                    bw.write(c);
                    bw.flush();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
    public void onkeyClose(){
        Thread t=new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    Socket s=getSocket();
                    CommModel model=new CommModel();
                    model.setType("command");
                    model.setCommObj("jd");
                    model.setData("off");
                    String c= JSON.toJSONString(model);
                    BufferedWriter bw =getBw(s);
                    bw.write(c);
                    bw.flush();


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    public void socketOnAndOFF(final String onOFF){
        Thread t=new Thread(){
            @Override
            public void run() {
                try{
                    Socket s=getSocket();
                    CommModel model=new CommModel();
                    model.setType("command");
                    model.setCommObj("socket");
                    model.setData(onOFF);
                    String c= JSON.toJSONString(model);
                    BufferedWriter bw =getBw(s);
                    bw.write(c);
                    bw.flush();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
    public void lightOnAndOFF(final String onOFF){
        Thread t=new Thread(){
            @Override
            public void run() {
                try{
                    Socket s=getSocket();
                    CommModel model=new CommModel();
                    model.setType("command");
                    model.setCommObj("light");
                    model.setData(onOFF);
                    String c= JSON.toJSONString(model);
                    BufferedWriter bw =getBw(s);
                    bw.write(c);
                    bw.flush();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
}
