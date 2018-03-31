package com.wby.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by wby on 2018/3/15.
 */

/**
 * 获取数据库连接类
 */
public class DBUtil {

    /**
     * 获取连接
     *
     * @return
     */
    public static Connection getCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/struts?useUnicode=true&characterEncoding=utf-8";
            String user = "root";
            String password = "root";
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn.getMetaData().getURL());
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 释放连接
     *
     * @param con
     * @throws Exception
     */
    public static void closeCon(Connection con) throws Exception {
        if (con != null) {
            con.close();
        }

    }
}
