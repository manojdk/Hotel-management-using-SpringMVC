<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Product</title>
</head>
<body>

	<% Object id = session.getAttribute("ownerid"); %>
	<form:form action="saveProduct" modelAttribute="productmodel">
	Food Name<form:input path="foodName" />
		<br>
	Description <form:input path="description" />
		<br>
	Cost <form:input path="cost" />
		<br>
	Food Type <form:input path="foodType" />
		<br>
		
	Owner id<input type = "text" readonly="readonly" value="<%= id%>">
		<input type="submit">

	</form:form>

</body>
</html>