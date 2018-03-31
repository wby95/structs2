package com.wby.dao;

import com.mysql.jdbc.PreparedStatement;
import com.wby.entity.Person;
import com.wby.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by wby on 2018/3/31.
 */
public class SelectDao {

    /*查询所有用户所买的机票
    * */
    public static List queryUserInfo() throws SQLException {
        List list=null;
        Timestamp d =null;
        Connection connection = DBUtil.getCon();
        String sql = "select * from person";
        try {
            java.sql.PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                list=new ArrayList();
                do{
                    Person person=new Person();
                    person.setUserName(rs.getString(1));
                    person.setSex(rs.getString(2));
                    person.setStartCity(rs.getString(3));
                    person.setEndCity(rs.getString(4));
                    person.setGooff(rs.getString(5));
                    person.setUserId(rs.getString(6));
                    list.add(person);
                }while(rs.next());
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
          connection.close();
        }
        return list;
    }
}
