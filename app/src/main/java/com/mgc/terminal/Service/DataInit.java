package com.mgc.terminal.Service;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mgc.terminal.bean.BtnBean;
import com.mgc.terminal.bean.CommModel;
import com.mgc.terminal.bean.JDBean;
import com.mgc.terminal.bean.SingletData;
import com.mgc.terminal.bean.VideoBean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class DataInit extends Thread {
    public ProgressDialog progressDialog;
    public Handler handler;
    public String ip;
    public int port;
    public  DataInit(ProgressDialog progressDialog,Handler handler,String url,int port){
        this.progressDialog=progressDialog;
        this.handler=handler;
        this.ip=url;
        this.port=port;
    }
    @Override
    public void run() {
        super.run();
        Socket socket=null;
        InputStream is=null;
        OutputStream os=null;
        byte[] response=new byte[2048];
        try{
            socket=new Socket(ip,port);
            is=socket.getInputStream();
            os=socket.getOutputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(os));
            CommModel model=new CommModel();
            model.setType("init");
            model.setInitdata("comput");
            String c= JSON.toJSONString(model);
            bw.write(c);
            bw.flush();
            String content=new String(br.readLine().getBytes(),"UTF-8");
            SingletData.getInstance().setBtns(toList(content));
            model.setInitdata("touying");
            c= JSON.toJSONString(model);
            bw.write(c);
            bw.flush();
            String content2=new String(br.readLine().getBytes(),"UTF-8");
            SingletData.getInstance().setTys(toList(content2));
            //初始化继电器数据
//            model.setInitdata("jd");
//            c= JSON.toJSONString(model);
//            bw.write(c);
//            bw.flush();
//            String content3=new String(br.readLine().getBytes(),"UTF-8");
//            SingletData.getInstance().setJds(toListJD(content3));
            model.setInitdata("video");
            c= JSON.toJSONString(model);
            System.out.println(c);
            bw.write(c);
            bw.flush();
            String content4=new String(br.readLine().getBytes(),"UTF-8");
            SingletData.getInstance().setVds(toListVideo(content4));
            progressDialog.dismiss();
            Message msg = new Message();
            // 消息的代号，是一个int类型
            msg.what = 200;
            handler.sendMessage(msg);


        }catch (Exception e){

            e.printStackTrace();
            Message msg = new Message();
            // 消息的代号，是一个int类型
            msg.what = 404;
            handler.sendMessage(msg);
        }
    }
    public  List<BtnBean> toList(String content){
        content="["+content+"]";
        JSONArray jsonArray= JSONArray.parseArray(content);
        List<BtnBean> list= JSONObject.parseArray(jsonArray.toJSONString(),BtnBean.class);
        return list;
    }

    public List<JDBean> toListJD(String content){
        List<JDBean> jdBeans=new ArrayList<JDBean>();
        String[] jds=content.split(";");
        for(String strs:jds){
            String[] str=strs.split(",");
            JDBean jdBean=new JDBean();
            jdBean.setIp(str[0]);
            jdBean.setPort(Integer.parseInt(str[1]));
            jdBean.setAddr(Integer.parseInt(str[2]));
            jdBean.setNum(Integer.parseInt(str[3]));
            jdBeans.add(jdBean);
        }
        return jdBeans;
    }
    public List<VideoBean> toListVideo(String content){
        List<VideoBean> videoBeans=new ArrayList();
        String[] vds=content.split(";");
        for(String strs:vds){
            String[] str=strs.split(",");
            VideoBean videoBean=new VideoBean(str[0],str[1],str[2],str[3]);
            videoBeans.add(videoBean);
        }
        return videoBeans;
    }



}
