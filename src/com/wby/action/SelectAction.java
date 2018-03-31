package com.wby.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wby.dao.SelectDao;
import com.wby.entity.Person;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Created by wby on 2018/3/31.
 */
public class SelectAction extends ActionSupport  implements ServletRequestAware {
    private HttpServletRequest request;
    public String queryAll() throws SQLException {
        System.out.println(" queryAll----------------");
       List list = SelectDao.queryUserInfo();
        System.out.println(" queryAll1111----------------");
        System.out.println(list.toString());
        request.getSession().setAttribute("list",list);
        System.out.println(list.toString());
        return SUCCESS;
    }
    @Override
    public void setServletRequest(HttpServletRequest request) {
        // TODO Auto-generated method stub
        this.request=request;
    }

}
