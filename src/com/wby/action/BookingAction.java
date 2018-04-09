package com.wby.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wby.dao.BookingDao;
import com.wby.util.ResponseUtil;

import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

/**
 * Created by wby on 2018/3/30.
 */
public class BookingAction extends ActionSupport {
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
        JSONObject result = new JSONObject();
        boolean flag = BookingDao.validatePerson(userName, gooff);
        if (flag) {
            System.out.println("true action");
            result.put("exist", true);

        } else {
            System.out.println("false action");
            result.put("exist", false);
        }
        ResponseUtil.write(ServletActionContext.getResponse(), result);
        return null;
    }

}
