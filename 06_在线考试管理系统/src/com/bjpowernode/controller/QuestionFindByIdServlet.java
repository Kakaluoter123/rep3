package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionFindByIdServlet extends HttpServlet {


     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String questionId = request.getParameter("questionId");
          QuestionDao dao=new QuestionDao();
          Question question = dao.findById(questionId);
          request.setAttribute("key_update",question);
          request.getRequestDispatcher("/question_update.jsp").forward(request,response);
     }
}
