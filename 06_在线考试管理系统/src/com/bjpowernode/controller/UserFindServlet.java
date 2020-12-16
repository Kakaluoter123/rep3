package com.bjpowernode.controller;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserFindServlet extends HttpServlet {
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     }

     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          UserDao dao = new UserDao();
          List<Users> userList = dao.findAll();
          response.setContentType("text/html;charset=utf-8");
          PrintWriter out = response.getWriter();

               out.print("<table border='2' align='center'>");
               out.print("<tr>");
               out.print("<td>用户编号</td>");
               out.print("<td>用户名称</td>");
               out.print("<td>用户密码</td>");
               out.print("<td>用户性别</td>");
               out.print("<td>用户邮箱</td>");
               out.print("<td>操作</td>");
               out.print("</tr>");
               for (int i = 0; i < userList.size(); i++) {
                    out.print("<tr>");
                    out.print("<td>" + userList.get(i).getUserId() + "</td>");
                    out.print("<td>" + userList.get(i).getUserName() + "</td>");
                    out.print("<td>" + userList.get(i).getPassword() + "</td>");
                    out.print("<td>" + userList.get(i).getSex() + "</td>");
                    out.print("<td>" + userList.get(i).getEmail() + "</td>");
                    out.print("<td><a href='/myWeb/user/delete?userId="+userList.get(i).getUserId()+"'>删除</a></td>");
                    out.print("</tr>");
               }
               out.print("</table>");
          }
}
