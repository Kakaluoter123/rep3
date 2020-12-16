package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionDeleteServlet extends HttpServlet {


     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String Id = request.getParameter("questionId");
          Integer questionId=Integer.valueOf(Id);
          QuestionDao dao=new QuestionDao();
          Integer result = (Integer) dao.deleteQuestion(questionId);
          request.setAttribute("key_delete",result);
          request.getRequestDispatcher("/question_Delete.jsp").forward(request,response);
     }
}
