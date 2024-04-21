<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trang đăng nhập</title>
</head>
<body>
<p color = "red">${errorString}</p>
<form action=""${pageContext.request.contextPath}/loginServlet" method="post">
<label>Tên đăng nhập </label>
<input type="text" name="username">
<label>Mật khẩu </label>
<input type="password" name="password">
<input type = "submit" value="Submit">
</form>
</body>
</html>