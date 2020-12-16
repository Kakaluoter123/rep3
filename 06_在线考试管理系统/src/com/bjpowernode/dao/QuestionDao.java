package com.bjpowernode.dao;

import com.bjpowernode.entity.Question;
import com.bjpowernode.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
     JdbcUtil util=new JdbcUtil();
     public int add(Question q){
          String sql="insert into question(title, optionA, optionB,optionC,optionD,answer) values(?,?,?,?,?,?)";
          PreparedStatement ps = util.createStatement(sql);
          int result =0;
          try {
               ps.setString(1,q.getTitle());
               ps.setString(2,q.getOptionA());
               ps.setString(3,q.getOptionB());
               ps.setString(4,q.getOptionC());
               ps.setString(5,q.getOptionD());
               ps.setString(6,q.getAnswer());

                result = ps.executeUpdate();
          } catch (SQLException throwables) {
               throwables.printStackTrace();
          }finally {
               util.close();
          }
          return result;
     }

     public List findAll(){
          String sql="select * from question";
          PreparedStatement ps = util.createStatement(sql);
          List<Question> questions=new ArrayList<>();
          ResultSet rs=null;
          try {
               rs = ps.executeQuery();
               while (rs.next()){
                    Integer questionId=(Integer) rs.getInt("questionId");
                    String title =rs.getString("title");
                    String optionA=rs.getString("optionA") ;
                    String optionB =rs.getString("optionB");
                    String optionC =rs.getString("optionC");
                    String optionD =rs.getString("optionD");
                    String answer =rs.getString("answer");
                    questions.add(new Question(questionId,title,optionA,optionB,optionC,optionD,answer));
               }
          } catch (SQLException throwables) {
               throwables.printStackTrace();
          }finally {
               util.close(rs);
          }
          return questions;
     }

     public int deleteQuestion(Integer questionId){
          String sql="delete from question where questionId=?";
          PreparedStatement ps = util.createStatement(sql);
          int result=0;
          try {
               ps.setInt(1,questionId);
                result = ps.executeUpdate();
          } catch (SQLException throwables) {
               throwables.printStackTrace();
          }finally {
               util.close();
          }
          return result;
     }

     public Question findById(String questionId){
          String sql="select * from question where questionId=?";
          PreparedStatement ps = util.createStatement(sql);
          ResultSet rs=null;
          Question question=null;
          try {
               ps.setInt(1,Integer.valueOf(questionId));
               rs=ps.executeQuery();
               while (rs.next()){
                    Integer Id= rs.getInt("questionId");
                    String title =rs.getString("title");
                    String optionA=rs.getString("optionA") ;
                    String optionB =rs.getString("optionB");
                    String optionC =rs.getString("optionC");
                    String optionD =rs.getString("optionD");
                    String answer =rs.getString("answer");
                    question=new Question(Id,title,optionA,optionB,optionC,optionD,answer);
               }
          } catch (SQLException throwables) {
               throwables.printStackTrace();
          }finally {
               util.close(rs);
          }
          return question;
     }

     public int updateQuestion(Question q){
          String sql="update question set title=?, optionA=?, optionB=?,optionC=?,optionD=?,answer=? where questionId=?";
          PreparedStatement ps = util.createStatement(sql);
          int result=0;
          try {

               ps.setString(1,q.getTitle());
               ps.setString(2,q.getOptionA());
               ps.setString(3,q.getOptionB());
               ps.setString(4,q.getOptionC());
               ps.setString(5,q.getOptionD());
               ps.setString(6,q.getAnswer());
               ps.setInt(7,q.getQuestionId());

               result = ps.executeUpdate();
          } catch (SQLException throwables) {
               throwables.printStackTrace();
          }finally {
               util.close();
          }
          return result;
     }
}
