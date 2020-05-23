<%@ page import="java.util.Iterator" %>
<%@ page import="com.softserve.itacademy.AddressBook" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.html"%>

<p>Sort by: <a href="/records/list?sort=asc">ascending</a> | <a href=/records/list?sort=desc"">descending</a></p>

<table  border="1">
    <th>No.</th>
    <th>First name</th>
    <th>Last name</th>
    <th>Address</th>
    <th colspan="3">Options</th>

    <%
        int i = 1;
        for(String[] iter : (List<String[]>)request.getAttribute("recordsIterator")) {

    %>


    <tr>
        <td><%=i++%></td>
        <td><%=iter[0]%></td>
        <td><%=iter[1]%></td>
        <td><%=iter[2]%></td>

        <td><a href="/records/read?first-name=<%= iter[0] %> &last-name= <%= iter[1] %>">Read</a> </td>
        <td><a href="/records/update?first-name=<%= iter[0] %> &last-name= <%= iter[1] %>">Update</a> </td>
        <td><a href="/records/delete?first-name=<%= iter[0] %> &last-name= <%= iter[1] %>">Delete</a> </td>


    </tr>
    <%

        }

    %>


</table>

</body>
</html>
