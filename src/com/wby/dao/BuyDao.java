package com.wby.dao;

import com.mysql.jdbc.PreparedStatement;
import com.wby.entity.Booking;
import com.wby.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by wby on 2018/3/31.
 */
public class BuyDao {
    /**
     * 购买机票
     * @param booking
     * @return
     * @throws SQLException
     */
    public static boolean buy(Booking booking) throws SQLException {
        Connection connection = DBUtil.getCon();
        PreparedStatement preparedStatement = null;
        preparedStatement = (PreparedStatement) connection.prepareStatement("INSERT INTO person VALUES (?,?,?,?,?,?)");
        preparedStatement.setString(1, booking.getUserName());
        preparedStatement.setString(2, booking.getSex());
        preparedStatement.setString(3, booking.getStartCity());
        preparedStatement.setString(4, booking.getEndCity());
        preparedStatement.setString(5, String.valueOf(booking.getGooff()));
        preparedStatement.setString(6, booking.getUserId());
        boolean rs = preparedStatement.execute();
        if (rs) {
            return true;
        } else
            return false;
    }
}
