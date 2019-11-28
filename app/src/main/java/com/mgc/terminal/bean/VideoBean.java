package com.mgc.terminal.bean;

public class VideoBean {
    private String ip;
    private String port;
    private String name;
    private String num;

    public  VideoBean(){

    }

    public VideoBean(String num,String ip, String port, String name) {
        this.ip = ip;
        this.port = port;
        this.name = name;
        this.num=num;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
