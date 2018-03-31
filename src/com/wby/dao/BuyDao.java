package com.wby.dao;

import com.mysql.jdbc.PreparedStatement;
import com.wby.entity.Person;
import com.wby.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by wby on 2018/3/31.
 */
public class BuyDao {
    /**
     * 购买机票
     * @param person
     * @return
     * @throws SQLException
     */
    public static boolean buy(Person person) throws SQLException {
        Connection connection = DBUtil.getCon();
        PreparedStatement preparedStatement = null;
        preparedStatement = (PreparedStatement) connection.prepareStatement("INSERT INTO person VALUES (?,?,?,?,?,?)");
        preparedStatement.setString(1, person.getUserName());
        preparedStatement.setString(2, person.getSex());
        preparedStatement.setString(3, person.getStartCity());
        preparedStatement.setString(4, person.getEndCity());
        preparedStatement.setString(5, String.valueOf(person.getGooff()));
        preparedStatement.setString(6, person.getUserId());
        boolean rs = preparedStatement.execute();
        if (rs) {
            return true;
        } else
            return false;
    }
}
