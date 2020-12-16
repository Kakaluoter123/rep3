package com.bjpowernode.controller;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Question;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class QuestionUpdateServlet extends HttpServlet {


     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String Id=request.getParameter("questionId");
          String title = request.getParameter("title");
          String optionA = request.getParameter("optionA");
          String optionB = request.getParameter("optionB");
          String optionC = request.getParameter("optionC");
          String optionD = request.getParameter("optionD");
          String answer = request.getParameter("answer");
          Integer questionId=Integer.valueOf(Id);
          Question question = new Question(questionId,title, optionA, optionB, optionC, optionD, answer);
          QuestionDao dao = new QuestionDao();
          int result = dao.updateQuestion(question);
          if(result==1){
               request.setAttribute("info","试题修改成功");
          }else {
               request.setAttribute("info","试题修改失败");
          }
          request.getRequestDispatcher("/info.jsp").forward(request,response);
     }
}
