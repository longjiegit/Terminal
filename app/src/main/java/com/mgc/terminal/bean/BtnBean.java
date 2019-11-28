package com.mgc.terminal.bean;

public class BtnBean {
    private String label;
    private String IP;
    private String Mac;

    public BtnBean(){

    }
    public BtnBean(String label,String IP,String Mac){
        this.label=label;
        this.IP=IP;
        this.Mac=Mac;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getMac() {
        return Mac;
    }

    public void setMac(String mac) {
        Mac = mac;
    }
}
