package com.bjpowernode.dao;

import com.bjpowernode.entity.Users;
import com.bjpowernode.util.JdbcUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
     private JdbcUtil util=new JdbcUtil();

     public int add(Users user){
          String mysql="insert into users(userName, password, sex,email) values(?,?,?,?)";
          PreparedStatement ps=util.createStatement(mysql);
          int result=0;
          try {
               ps.setString(1,user.getUserName());
               ps.setString(2,user.getPassword());
               ps.setString(3,user.getSex());
               ps.setString(4,user.getEmail());
               result=ps.executeUpdate();
          } catch (SQLException throwables) {
               throwables.printStackTrace();
          }finally {
               util.close();
          }

          return result;
     }

     /**
      * 重载add增快运行速度 使用ServletContext
      * @param request
      */
     public int add(Users user, HttpServletRequest request){
          String mysql="insert into users(userName, password, sex,email) values(?,?,?,?)";
          PreparedStatement ps=util.createStatement(mysql,request);
          int result=0;
          try {
               ps.setString(1,user.getUserName());
               ps.setString(2,user.getPassword());
               ps.setString(3,user.getSex());
               ps.setString(4,user.getEmail());
               result=ps.executeUpdate();
          } catch (SQLException throwables) {
               throwables.printStackTrace();
          }finally {
               util.close(request);
          }
          return result;
     }


     public List findAll(){
          String mysql="select * from users";
          PreparedStatement ps=util.createStatement(mysql);
          ResultSet rs = null;
          List userList=new ArrayList();
          try {
               rs=ps.executeQuery();
               while (rs.next()){
                    Integer userId=rs.getInt("userId");
                    String userName=rs.getString("userName");
                    String password=rs.getString("password");
                    String sex=rs.getString("sex");
                    String email=rs.getString("email");
                    userList.add(new Users(userId,userName, password,sex,email));
               }

          } catch (SQLException throwables) {
               throwables.printStackTrace();
          }finally {
               util.close(rs);
          }
          return userList;
     }

     public int deleteUser(int userId){
          String mysql="delete from users where userId=?";
          PreparedStatement ps=util.createStatement(mysql);
          int num=0;
          try {
               ps.setInt(1,userId);
               num = ps.executeUpdate();
          } catch (SQLException throwables) {
               throwables.printStackTrace();
          }finally {
               util.close();
          }
          return num;
     }

     public int UserLogin(String userName,String password){
          String mysql="select count(*) from users where userName=? and password=?";
          PreparedStatement ps=util.createStatement(mysql);
          ResultSet rs=null;
          int result=0;
          try {
               ps.setString(1,userName);
               ps.setString(2,password);
               rs= ps.executeQuery();
               while (rs.next()){
                    result=rs.getInt("count(*)");
               }
          } catch (SQLException throwables) {
               throwables.printStackTrace();
          }finally {
               util.close(rs);
          }
          return result;
     }



}
