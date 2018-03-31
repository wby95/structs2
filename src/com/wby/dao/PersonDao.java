package com.wby.dao;

import com.wby.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * Created by wby on 2018/3/30.
 */
public class PersonDao {
    /**
     * 假设一人一天只能上一班飞机，验证该用户是否已经在该天买了票
     * @param username
     * @param
     * @return
     */
    public static boolean validatePerson(String username, String gooff) {
        Connection connection = DBUtil.getCon();
        boolean bln = true;
        try {
            Statement stmt = connection.createStatement();
            String sql = "select * from person where userName='"+username +"' and  gooff ='"+gooff+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if (!rs.next()) {

                System.out.println("flase");
                System.out.println(gooff);
                System.out.println(username);
                bln = false;
            }
            rs.close();
            stmt.close();
            connection.close();
            return bln;
        } catch (SQLException ex) {
            ex.printStackTrace();
            bln = false;
            return bln;
        }
    }
}
