package com.wby.dao;

import com.wby.entity.Booking;
import com.wby.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
                    Booking booking =new Booking();
                    booking.setUserName(rs.getString(1));
                    booking.setSex(rs.getString(2));
                    booking.setStartCity(rs.getString(3));
                    booking.setEndCity(rs.getString(4));
                    booking.setGooff(rs.getString(5));
                    booking.setUserId(rs.getString(6));
                    list.add(booking);
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
