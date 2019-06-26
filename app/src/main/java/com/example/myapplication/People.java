package com.example.myapplication;

import java.io.Serializable;

public class People implements Serializable {
    private String name;
    private String id;
    private String mima;
    private String sex;
    private String huiyuan;
    private String tizhong;

    public void setName(String name) {
        this.name = name;
    }

    public void setMima(String mima) {
        this.mima = mima;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public void setHuiyuan(String huiyuan) {
        this.huiyuan = huiyuan;
    }
    public void setTizhong (String tizhong) {
        this.tizhong = tizhong;
    }

    public String getSex() {
        return sex;
    }
    public String getHuiyuan(){
        return huiyuan;
    }

    public String getTizhong() {
        return tizhong;
    }

    public String getName() {
        return name;
    }
    public String getMima(){
        return mima;
    }

    public String getId() {
        return id;
    }
}
