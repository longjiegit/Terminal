package com.mgc.terminal.Service;

import com.alibaba.fastjson.JSON;
import com.mgc.terminal.bean.CommModel;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class TouyingService extends BaseService{

    public void ControlTouying(final String IP,final String command){
        Thread t=new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Socket s = getSocket(IP);
                    InputStream is = s.getInputStream();
                    OutputStream os=s.getOutputStream();
                    byte[] response=new byte[2048];
                    is.read(response);
                    if((char)response[7]=='0'){
                        os.write(command.getBytes());
                        int n=is.read(response);
                        String res=new String(response,0,n);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }
    public void TouyingControl(final String IP,final String command){
        Thread t=new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    Socket s=getSocket();
                    CommModel model=new CommModel();
                    model.setType("command");
                    model.setCommObj("touying");
                    model.setDestip(IP);
                    model.setData(command);
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

    public Socket getSocket(String IP) throws  Exception{

        System.out.println("连接投影---"+IP);
        Socket socket=new Socket(IP,4352);
        return socket;
    }

}
