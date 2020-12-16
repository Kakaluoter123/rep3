<%@ page import="com.bjpowernode.entity.Question" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 18223
  Date: 2020/11/26
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Question> key1 = (List<Question>)request.getAttribute("key1");
%>
<style type="text/css">
    td{
        text-align: center;
    }
</style>
<table border="2px" align="center">
    <tr>
        <th>题目编号</th>
        <th>题目信息</th>
        <th>A</th>
        <th>B</th>
        <th>C</th>
        <th>D</th>
        <th>正确答案</th>
        <th colspan="2">操作</th>
    </tr>
    <%
    for (int i=0;i<key1.size();i++){
         if(i%2==0){
    %>
    <tr style="background-color: green">
        <%
            }else{
        %>
        <tr style="background-color: yellow">
        <%
            }
        %>
        <td><%=key1.get(i).getQuestionId()%></td>
        <td><%=key1.get(i).getTitle()%></td>
        <td><%=key1.get(i).getOptionA()%></td>
        <td><%=key1.get(i).getOptionB()%></td>
        <td><%=key1.get(i).getOptionC()%></td>
        <td><%=key1.get(i).getOptionD()%></td>
        <td><%=key1.get(i).getAnswer()%></td>
        <td><a href="/myWeb/question/delete?questionId=<%=key1.get(i).getQuestionId()%>">试题删除</a></td>
        <td><a href="/myWeb/question/findById?questionId=<%=key1.get(i).getQuestionId()%>">详细信息</a></td>
    </tr>
    <%
        }
    %>
</table>