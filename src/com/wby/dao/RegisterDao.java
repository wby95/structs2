package com.wby.dao;

import com.mysql.jdbc.PreparedStatement;
import com.wby.entity.Customer;
import com.wby.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by wby on 2018/4/9.
 */
public class RegisterDao {

    //ע���û��ķ���
    public static boolean registerUser(Customer customer){

        Connection connection = DBUtil.getCon();
        PreparedStatement preparedStatement = null;
        try{
            Statement stmt=null;
            stmt=connection.createStatement();
            String sql="insert into Users values('"+customer.getUserName()+"','"+customer.getPassword()+"')";
            int r=stmt.executeUpdate(sql);
            if(r>0){
                return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
            System.out.println("���ݿ����ʧ��!");
            ex.printStackTrace();
            return false;
        }
    }
}
