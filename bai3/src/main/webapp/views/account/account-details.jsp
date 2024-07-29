<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 7/29/2024
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Information</h1>
<p>ID: ${account.id}</p>
<p>User Name: ${account.username}</p>
<p>Password: ${account.password}</p>
<p>permission: ${account.permission}</p>
<p>Status: ${account.status ? "Active" : "Inactive"}</p>
<a href="LoadAccount">Back to Account List</a>
</body>
</html>
