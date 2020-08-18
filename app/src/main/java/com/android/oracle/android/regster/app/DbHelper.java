package com.android.oracle.android.regster.app;

import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbHelper {
    boolean result = false;
    public DbHelper(){

    }


    public boolean add(String email,String username,String lastName,String pass,String  mobile,String address){
        try{
            Connection conn=ConnectionProvider.getConnection();
            PreparedStatement statement =conn.prepareStatement("Insert into users(email,lastName,password,username,mobile,address)"+"values(?,?,?,?,?,?) ");
            statement.setString(1,email);
            statement.setString(2,pass);
            statement.setString(3,username);
            statement.setString(4,lastName);
            statement.setString(5,mobile);
            statement.setString(6,address);
            result= statement.execute();
            statement.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public boolean login(String email,String pass){


        try {
            Connection conn=ConnectionProvider.getConnection();
            PreparedStatement statement =conn.prepareStatement("select * from users where email=? and password=?");
            statement.setString(1,email);
            statement.setString(2, pass);
            ResultSet rs=statement.executeQuery();
            result=rs.next();
            while(rs.next()) {
                String  s=  rs.getString("mobile");
                Log.d(s,"mobile");

            }

            statement.close();
        }catch (Exception q){
            q.getMessage();
        }

        return result;
    }


}
