<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change user</title>
</head>
<body>

Update user

<form action="/users/${param.id}" method="post">
    <input type="hidden" name = "id" value="${param.id}">
    <input type="text" name="name" value="${param.name}" placeholder=${param.name}>
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="Update">
</form>
</body>
</html>
