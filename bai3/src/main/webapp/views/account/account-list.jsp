<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 7/29/2024
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<form action="LoadAccount" method="get">
    <input type="hidden" name="action" value="search">
    <input type="text" name="searchQuery" placeholder="Search User">
    <button type="submit">Search</button>
</form>
<div class="container">
    <h1>LIST ACCOUNTS!</h1>
    <table class="table table-bordered">
        <tr>
            <th>Id</th>
            <th>Username</th>
            <th>Password</th>
            <th>Permission</th>
            <th>Status</th>
            <th>Action</th>
        </tr>

        <c:forEach items="${accounts}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.username}</td>
                <td>${u.password}</td>
                <td>${u.permission}</td>
                <td>${u.status ? "Active" : "Inactive"}</td>
                <td>
                    <a href="LoadAccount?action=edit&id=${u.id}">Update</a>
                    <a href="LoadAccount?action=delete&id=${u.id}">Delete</a>
                    <a href="LoadAccount?action=details&id=${u.id}">Show Details</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="LoadAccount?action=create">Add new User</a>
    <button class="btn btn-primary">
        add
    </button>
    <button class="btn btn-warning">
        edit
    </button>
    <button class="btn btn-danger">
        delete
    </button>
    <button class="btn btn-success">
        details
    </button>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
