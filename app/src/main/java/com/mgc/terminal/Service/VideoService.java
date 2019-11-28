package com.mgc.terminal.Service;

import com.alibaba.fastjson.JSON;
import com.mgc.terminal.bean.CommModel;
import java.io.BufferedWriter;
import java.net.Socket;

public class VideoService extends  BaseService {
    public void contorVideo(final String destip,final String command){
        Thread t=new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    Socket s=getSocket();
                    CommModel model=new CommModel();
                    model.setType("command");
                    model.setCommObj("video");
                    model.setDestip(destip);
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
}
