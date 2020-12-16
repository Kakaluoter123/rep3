<%--
  Created by IntelliJ IDEA.
  User: 18223
  Date: 2020/11/25
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String info = (String) request.getAttribute("info");
%>
<center>
    <font style="color: red;font-size: 40px"><%=info%></font>
</center>