package com.wby.dao;

import com.wby.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by wby on 2018/4/9.
 */
public class CustomerLoginDao {
    public static boolean validateLogin(String name,String password){
        Connection connection = DBUtil.getCon();
        Statement stmt=null;
        try{
            stmt=connection.createStatement();
            String sql="select * from users where name='"+name+"' and password='"+password+"'";
            System.out.println(sql);
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()){ System.out.println("true");
                return true;

            }else{ System.out.println("false");
                return false;
            }
        }catch(SQLException ex){
            System.out.println("数据库连接失败!");
            ex.printStackTrace();
            return false;
        }

    }

}
