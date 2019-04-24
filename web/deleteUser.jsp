<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete user</title>
</head>
<body>
Delete user: ${param.id}?

&lform action="/users/${param.id}" method="post">
<input type="hidden" name="id" value="${param.id}">
<input type="hidden" name="_method" value="delete">
<input type="submit" value="Delete">
</form>
</body>
</html>
