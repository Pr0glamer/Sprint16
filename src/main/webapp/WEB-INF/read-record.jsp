<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Read record from Address book</title>
</head>
<body>
<%@include file="header.html"%>
<p>First name: <b><%=request.getParameter("first-name")%></b></p>
<p>Last name:  <b><%=request.getParameter("last-name")%></b></p>
<p>Address:    <b><%=request.getAttribute("address")%></b></p>

</body>
</html>