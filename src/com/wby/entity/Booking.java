package com.wby.entity;

import java.util.Date;

/**
 * Created by wby on 2018/3/30.
 */
public class Booking {
    private String userName;
    private String sex;
    private String startCity;
    private String endCity;
    private String gooff;
    private String userId;

    public Booking() {
    }

    public Booking(String userName, String sex, String startCity, String endCity, String gooff, String userId) {
        this.userName = userName;
        this.sex = sex;
        this.startCity = startCity;
        this.endCity = endCity;
        this.gooff = gooff;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    public String getGooff() {
        return gooff;
    }

    public void setGooff(String gooff) {
        this.gooff = gooff;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
