<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"/>
</head>

<body class="container mt-5">

<h2 class="text-center">User List</h2>

<a href="/add-user" class="btn btn-success mb-3">Add User</a>

<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th>UserName</th>
        <th>First</th>
        <th>Last</th>
        <th>Email</th>
        <th>SSN</th>
        <th></th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${users}" var="u">
        <tr>
            <td>${u.userid}</td>
            <td>${u.username}</td>
            <td>${u.firstname}</td>
            <td>${u.lastname}</td>
            <td>${u.email}</td>
            <td>${u.ssn}</td>

            <td>
                <a href="/update-user?userid=${u.userid}" class="btn btn-primary btn-sm">Edit</a>
                <a href="/delete-user?userid=${u.userid}" class="btn btn-danger btn-sm">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>

</body>
</html>
