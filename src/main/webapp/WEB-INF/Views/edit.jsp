<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/editList">
 <input type="hidden" name="id" value="${et.id}" />
 <p>${et.id}</p>
<input type = "text" name ="name" placeholder="Ho va ten" values ="${et.hoTen}">
<input type = "number" min =140 max=2006 name ="year" placeholder="#" values ="${et.namSinh}" >
<input type = "text" name ="adress" placeholder="diachi" values ="${et.queQuan}">
<input type = "submit" value="Submit">
</form>
</body>
</html>