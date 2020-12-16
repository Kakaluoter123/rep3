package com.bjpowernode.controller;

import com.bjpowernode.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDeleteServlet extends HttpServlet {
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     }

     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String userId = request.getParameter("userId");
          int id = Integer.parseInt(userId);
          PrintWriter out = null;
          UserDao dao = new UserDao();
          response.setContentType("text/html;charset=utf-8");
          out = response.getWriter();
          if (dao.deleteUser(id) == 1) {
               out.print("<font style='color:red;font-size:40px'>删除成功</font>");
          } else {
               out.print("<font style='color:red;font-size:40px'>删除失败</font>");
          }
     }
}
