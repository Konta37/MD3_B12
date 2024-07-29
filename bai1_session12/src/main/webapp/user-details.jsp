<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 7/29/2024
  Time: 8:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Information</h1>
<p>ID: ${user.id}</p>
<p>User Name: ${user.username}</p>
<p>Password: ${user.password}</p>
<p>fullName: ${user.fullName}</p>
<p>address: ${user.address}</p>
<p>email: ${user.email}</p>
<p>Phone: ${user.phone}</p>
<a href="LoadUser">Back to User List</a>
</body>
</html>
