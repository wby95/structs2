package com.wby.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wby.dao.BuyDao;
import com.wby.entity.Booking;

/**
 * Created by wby on 2018/3/30.
 */
public class BuyAction extends ActionSupport {
    private String userName;
    private String sex;
    private String startCity;
    private String endCity;
    private String gooff;
    private String userId;

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


    public String execute() throws Exception {
        Booking booking =new Booking();
        booking.setUserName(userName);
        booking.setSex(sex);
        booking.setStartCity(startCity);
        booking.setEndCity(endCity);
        booking.setGooff(gooff);
        booking.setUserId(userId);
        boolean bln= BuyDao.buy(booking);
        return SUCCESS;
    }

}
