<%@ page import="com.bjpowernode.entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: 18223
  Date: 2020/11/27
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Question question =(Question) request.getAttribute("key_update");
%>
<style type="text/css">

</style>
<form action="/myWeb/question/update" method="get" >
    <table border="2px" align="center">
        <tr>
            <td >题目编号:</td>
            <td><input type="text" name="questionId" value="<%=question.getQuestionId()%>" readonly></td>
        </tr>
        <tr>
            <td>题目:</td>
            <td><input type="text" name="title" value="<%=question.getTitle()%>"></td>
        </tr>
        <tr>
            <td>A:</td>
            <td><input type="text" name="optionA" value="<%=question.getOptionA()%>"></td>
        </tr>
        <tr>
            <td>B:</td>
            <td><input type="text" name="optionB" value="<%=question.getOptionB()%>"></td>
        </tr>
        <tr>
            <td>C:</td>
            <td><input type="text" name="optionC" value="<%=question.getOptionC()%>"></td>
        </tr>
        <tr>
            <td>D:</td>
            <td><input type="text" name="optionD" value="<%=question.getOptionD()%>"></td>
        </tr>
        <tr>
            <td>正确选项:</td>
            <td>
                A<input type="radio" name="answer" value="A" <%="A".equals(question.getAnswer())?"checked":""%>>
                B<input type="radio" name="answer" value="B" <%="B".equals(question.getAnswer())?"checked":""%>>
                C<input type="radio" name="answer" value="C" <%="C".equals(question.getAnswer())?"checked":""%>>
                D<input type="radio" name="answer" value="D" <%="D".equals(question.getAnswer())?"checked":""%>>
            </td>

        </tr>
        <tr>
            <td><input type="submit" value="修改试题"></td>
            <td><input type="reset"></td>
        </tr>
    </table>
</form>