<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="3">
		<tr>
			<th>ID</th>
			<th>FOOD NAME</th>
			<th>DESCRIPTION</th>
			<th>COST</th>
			<th>FOOD TYPE</th>

			<th colspan="2">ACTION</th>

		</tr>
		<c:forEach items="${allproducts }" var="product">
			<tr>
				<td>${product.id }</td>
				<td>${product.foodName }</td>
				<td>${product.description }</td>
				<td>${product.cost }</td>
				<td>${product.foodType }</td>
				<td><a href="deleteProduct?id=${product.id }">
				<input type="submit" value="DELETE"></a></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>