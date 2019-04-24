<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>
<table border="2">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <td>Action</td>
    </tr>
    <c:forEach items="${users}" var = "user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getName()}</td>
            <td>
                <form action = "updateUser.jsp" method="post">
                    <input type="hidden" name="id" value="${user.getId()}">
                    <input type="hidden" name="name" value="${user.getName()}">
                    <input type="submit" value="Change" style="float:left">
                </form>
                <form action="deleteUser.jsp" method="post">
                    <input type="hidden" name="id" value="${user.getId()}">
                    <input type="submit" value="Delete" style="float:left">
                </form></td>
        </tr>
    </c:forEach>
</table>

<form action = "addUser.jsp">
    <input type="submit" value="Add new user">
</form>
</body>
</html>
