<%--
  Created by IntelliJ IDEA.
  User: gabri
  Date: 2016-02-14
  Time: 01:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>You searched for:</h4>
    <%=  request.getParameter("artistName")%>
    <jsp:useBean id="sb" class="beans.SearchBean" />
    <jsp:setProperty name="sb" property="name" value="<%= request.getParameter("artistName")%>" />
    <h3>Result:</h3>
    <jsp:getProperty name="sb" property="name"/>
</body>
</html>
