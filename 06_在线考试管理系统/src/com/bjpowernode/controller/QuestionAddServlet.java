package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionAddServlet extends HttpServlet {
     /**
      *
      * 添加试题
      * @param request
      * @param response
      * @throws ServletException
      * @throws IOException
      */

     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String title = request.getParameter("title");
          String optionA = request.getParameter("optionA");
          String optionB = request.getParameter("optionB");
          String optionC = request.getParameter("optionC");
          String optionD = request.getParameter("optionD");
          String answer = request.getParameter("answer");

          Question question = new Question(null,title, optionA, optionB, optionC, optionD, answer);
          QuestionDao dao = new QuestionDao();
          int result = dao.add(question);
          if(result==1){
               request.setAttribute("info","试题添加成功");
          }else {
               request.setAttribute("info","试题添加失败");
          }
          request.getRequestDispatcher("/info.jsp").forward(request,response);
     }
}
