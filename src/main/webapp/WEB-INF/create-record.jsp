<%--
  Created by IntelliJ IDEA.
  User: Николай
  Date: 23.05.2020
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Create record</title>
</head>
<body>
<%@include file="header.html"%>
<form action="/records/create" method="post">

    <%
        Object err = request.getAttribute("error");
        if(err!=null) {
    %>
             <p><%=err%></p>
    <%
        } else {
    %>

    <%
        }
    %>


    <table>
        <tr>
            <td>
                <label for="firstName">First name</label>
            </td>
            <td>
                <input type="text" id="firstName" name="firstName">
            </td>
        </tr>
        <tr>
        <td>
            <label for="lastName">Last name</label>
        </td>
        <td>
            <input type="text" id="lastName" name="lastName">
        </td>
        </tr>
        <tr>
        <td>
            <label for="address">Address</label>
        </td>
        <td>
            <input type="text" id="address" name="address">
        </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Create">
            </td>
            <td>
                <input type="submit" value="Clear">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
