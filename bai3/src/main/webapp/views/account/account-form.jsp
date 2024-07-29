<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1>${account==null ? "Create new account" : "Update Account"}</h1>
<form action="LoadAccount" method="post">
  <input type="hidden" name="action" value="${account == null ? 'save' : 'update'}">
  <c:if test="${account != null}">
  <input type="hidden" name="id" value="${account.id}">
  </c:if>
  <label for="username">username: </label>
  <input type="text" name="username" id="username" value="${account != null ? account.username : ''}" required>
  <label for="password">password: </label>
  <input type="text" name="password" id="password" value="${account != null ? account.password : ''}" required>
  <label for="permission">permission: </label>
  <input type="text" name="permission" id="permission" value="${account != null ? account.permission : ''}" required>
  <label for="status">address: </label>
  <input type="checkbox" name="status" id="status" ${account != null && account.status ? 'checked' : ''}>
  <button type="submit">Save</button>
</body>
</html>
