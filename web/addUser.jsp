<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>
<form action = "/users" method="post">
    <input required type="text" name="name" placeholder="Name">
    <input type="submit" value="Add">
</form>
</body>
</html>
