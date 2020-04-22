package com.mgc.terminal.bean;

import java.util.List;

public class SingletData {
    private List<BtnBean> btns;
    private List<BtnBean> tys;
    private List<JDBean>  jds;
    private List<VideoBean> vds;
    private static SingletData INSTANCE=new SingletData();
    private String ip;
    private int port;
    private SingletData(){
        ip="192.168.1.146";
        port=9080;
    }
    public static SingletData getInstance() {
        return INSTANCE;
    }

    public List<BtnBean> getBtns() {
        return btns;
    }

    public void setBtns(List<BtnBean> btns) {
        this.btns = btns;
    }

    public List<BtnBean> getTys() {
        return tys;
    }

    public void setTys(List<BtnBean> tys) {
        this.tys = tys;
    }

    public List<JDBean> getJds() {
        return jds;
    }

    public void setJds(List<JDBean> jds) {
        this.jds = jds;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public List<VideoBean> getVds() {
        return vds;
    }

    public void setVds(List<VideoBean> vds) {
        this.vds = vds;
    }
}
