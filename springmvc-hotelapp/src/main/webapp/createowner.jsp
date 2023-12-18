<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="saveOwner" modelAttribute="ownermodel">
	Email <form:input path="email"/><br>
	Password <form:input path="password"/><br>
	
	<input type ="submit">
	
	</form:form>
</body>
</html>