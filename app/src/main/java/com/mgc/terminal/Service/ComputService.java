package com.mgc.terminal.Service;

import com.alibaba.fastjson.JSON;
import com.mgc.terminal.bean.CommModel;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class ComputService extends BaseService{

    public void ShutDonw(final String IP){
        Thread t=new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    Socket s=getSocket(IP);
                    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                    bw.write("shutdown -s -t 00");
                    bw.flush();
                    bw.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    public void ShutDownByControl(final String destip){
        Thread t=new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    Socket s=getSocket();
                    CommModel model=new CommModel();
                    model.setType("command");
                    model.setCommObj("comput");
                    model.setDestip(destip);
                    model.setDestmac("");
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

    public void start(final String IP, final String Mac){
        Thread t=new Thread(){
            @Override
            public void run() {
                super.run();
                remoteStart(IP,Mac);
            }
        };
        t.start();
    }
    public  void startByControl(final String Mac){
        Thread t=new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    Socket s=getSocket();
                    CommModel model=new CommModel();
                    model.setType("command");
                    model.setCommObj("comput");
                    model.setDestmac(Mac);
                    model.setDestip("");
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

    public void ControlTouying(String IP,String command){
        Thread t=new Thread(){
            @Override
            public void run() {
                super.run();

            }
        };
        t.start();
    }

    public Socket getSocket(String IP) throws  Exception{
       Socket socket=new Socket(IP,8000);
       return socket;
    }

    public void remoteStart(String IP,String Mac){
        //假定子网掩码位255.255.255.0
        //获得广播地址
        String desIP=getBroadcastAddress(IP,"255.255.255.0");
        wakeBy(desIP,Mac,20105);
    }
    public static String getBroadcastAddress(String ip, String subnetMask){
        String ipBinary = toBinary(ip);
        String subnetBinary = toBinary(subnetMask);
        String broadcastBinary = getBroadcastBinary(ipBinary, subnetBinary);
        String wholeBroadcastBinary=spiltBinary(broadcastBinary);
        return binaryToDecimal(wholeBroadcastBinary);
    }

    //二进制的ip字符串转十进制
    private static String binaryToDecimal(String wholeBroadcastBinary){
        String[] strings = wholeBroadcastBinary.split("\\.");
        StringBuilder sb = new StringBuilder(40);
        for (int j = 0; j < strings.length ; j++) {
            String s = Integer.valueOf(strings[j], 2).toString();
            sb.append(s).append(".");
        }
        return sb.toString().substring(0,sb.length()-1);
    }

    //按8位分割二进制字符串
    private static String spiltBinary(String broadcastBinary){
        StringBuilder stringBuilder = new StringBuilder(40);
        char[] chars = broadcastBinary.toCharArray();
        int count=0;
        for (int j = 0; j < chars.length; j++) {
            if (count==8){
                stringBuilder.append(".");
                count=0;
            }
            stringBuilder.append(chars[j]);
            count++;
        }
        return stringBuilder.toString();
    }

    //得到广播地址的二进制码
    private static String getBroadcastBinary(String ipBinary, String subnetBinary){
        int i = subnetBinary.lastIndexOf('1');
        String broadcastIPBinary = ipBinary.substring(0,i+1);
        for (int j = broadcastIPBinary.length(); j < 32 ; j++) {
            broadcastIPBinary=broadcastIPBinary+"1";
        }
        return broadcastIPBinary;
    }

    //转二进制
    private static String toBinary(String content) {
        String binaryString = "";
        String[] ipSplit = content.split("\\.");
        for (String split : ipSplit) {
            String s = Integer.toBinaryString(Integer.valueOf(split));
            int length = s.length();
            for (int i = length; i < 8; i++) {
                s = "0" + s;
            }
            binaryString = binaryString + s;
        }
        return binaryString;
    }
    private static void wakeBy(String ip, String mac, int port) {
        //构建magic魔术包
        String MagicPacage = "FFFFFFFFFFFF";
        for (int i = 0; i < 16; i++) {
            MagicPacage += mac;
        }
        byte[] MPBinary = hexStr2BinArr(MagicPacage);
        try {
            InetAddress address = InetAddress.getByName(ip);
            DatagramSocket socket = new DatagramSocket(port);
            DatagramPacket packet = new DatagramPacket(MPBinary, MPBinary.length, address, port);
            //发送udp数据包到广播地址
            socket.send(packet);
            socket.close();
        } catch (IOException e) {
            //发送魔术包异常，写入日志。
            e.printStackTrace();

        }
    }

    private static byte[] hexStr2BinArr(String hexString) {
        String hexStr = "0123456789ABCDEF";
        int len = hexString.length() / 2;
        byte[] bytes = new byte[len];
        byte high = 0;
        byte low = 0;
        for (int i = 0; i < len; i++) {
            high = (byte) ((hexStr.indexOf(hexString.charAt(2 * i))) << 4);
            low = (byte) hexStr.indexOf(hexString.charAt(2 * i + 1));
            bytes[i] = (byte) (high | low);
        }
        return bytes;
    }
}
