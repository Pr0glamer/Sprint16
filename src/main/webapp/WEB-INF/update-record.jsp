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
    <title>Update record</title>
</head>
<body>
<%@include file="header.html"%>
<form action="/records/update" method="post">

    <table>
        <tr>
            <td>
                <label for="firstName">First name</label>
            </td>
            <td>
                <input type="text" id="firstName" name="firstName" value="<%=(String)request.getParameter("first-name")%>">
            </td>
        </tr>
        <tr>
        <td>
            <label for="lastName">Last name</label>
        </td>
        <td>
            <input type="text" id="lastName" name="lastName"value=<%=(String)request.getParameter("last-name")%>>
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
                <input type="submit" value="Update">
            </td>
            <td>
                <input type="submit" value="Clear">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
