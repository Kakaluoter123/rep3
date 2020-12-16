<%--
  Created by IntelliJ IDEA.
  User: 18223
  Date: 2020/11/26
  Time: 23:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int result= 0;
    try {
        result = Integer.valueOf(request.getParameter("key_delete"));
    } catch (NumberFormatException e) {
        e.printStackTrace();
    }
    if(result==1){
%>
<font style="color: red;font-size: 40px">删除成功</font>
<%
}else{
%>
<font style="color: red;font-size: 40px">删除成功</font>
<%
    }
%>