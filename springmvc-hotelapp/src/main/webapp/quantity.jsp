<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form action="toOrder" method="post" modelAttribute="item">
		<br>
Food<form:input path="itemName" readonly="true"/>
		<br>
Quantity<form:input path="quantity" />
		<br>
Price<form:input path="price" readonly="true"/>
		<br>

		<input type="submit">
	</form:form>

</body>
</html>