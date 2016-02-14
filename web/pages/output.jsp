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
    <%= request.getParameter("item")%>

    <jsp:useBean id="nb" class="ejb.SearchBean" />
    <jsp:setProperty name="nb" property="item" value="<%= request.getParameter("item")%>" />
    <h3>Result:</h3>
    <jsp:getProperty name="nb" property="item"/>
</body>
</html>
