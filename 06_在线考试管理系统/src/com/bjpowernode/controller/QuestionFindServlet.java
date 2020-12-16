package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class QuestionFindServlet extends HttpServlet {


     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          QuestionDao dao=new QuestionDao();
          List<Question> all = dao.findAll();
          request.setAttribute("key1",all);
          request.getRequestDispatcher("/question_Find.jsp").forward(request,response);
     }
}
