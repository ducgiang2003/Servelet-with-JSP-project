<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
    <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1", cellpadding ="1",cellspacing="1" >
<tr>
<td>id</td>
<td>Họ và tên</td>
<td>Year</td>
<td>Adress</td>
</tr>
<c:forEach items="${emps}" var ="emp">
<tr>
<td>${emp.id}</td>
<td>${emp.hoTen}</td>
<td>${emp.namSinh}</td>
<td>${emp.queQuan}</td>
<td><a href="delete?id=${emp.id}">Xoa</a></td>
<td><a href="insertList">Thêm nhân viên</a></td>
<td><a href="editList?id=${emp.id}">Sửa nhân viên </a></td>
</tr>
</c:forEach>
<tr>

</tr>
</table>
</body>
</html>