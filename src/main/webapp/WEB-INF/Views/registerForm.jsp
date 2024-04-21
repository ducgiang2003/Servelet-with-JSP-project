<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/registerServlet">
<label>Tên đăng nhập </label>
<input type="text" name="username">
<label>Mật khẩu </label>
<input type="password" name="password">
<input type = "submit" value="Submit">
</form>

</body>
</html>