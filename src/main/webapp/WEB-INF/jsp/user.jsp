<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User Form</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"/>
</head>

<body class="container mt-5">

<h2 class="text-center">
    <c:choose>
        <c:when test="${edit}">Edit User</c:when>
        <c:otherwise>Add User</c:otherwise>
    </c:choose>
</h2>

<form method="post" action="${edit ? '/update-user' : '/add-user'}">

    <input type="hidden" name="userid" value="${user.userid}"/>

    <div class="form-group">
        <label>Username</label>
        <input name="username" class="form-control" value="${user.username}" required>
    </div>

    <div class="form-group mt-2">
        <label>Password</label>
        <input name="password" class="form-control" value="${user.password}" required>
    </div>

    <div class="form-group mt-2">
        <label>First Name</label>
        <input name="firstname" class="form-control" value="${user.firstname}">
    </div>

    <div class="form-group mt-2">
        <label>Last Name</label>
        <input name="lastname" class="form-control" value="${user.lastname}">
    </div>

    <div class="form-group mt-2">
        <label>Email</label>
        <input name="email" class="form-control" value="${user.email}">
    </div>

    <div class="form-group mt-2">
        <label>SSN</label>
        <input name="ssn" class="form-control" value="${user.ssn}">
    </div>

    <button class="btn btn-primary mt-3">
        <c:choose>
            <c:when test="${edit}">Update</c:when>
            <c:otherwise>Add</c:otherwise>
        </c:choose>
    </button>

</form>

</body>
</html>
