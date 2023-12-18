<%@page import="com.hotel.mvc.springmvc_hotelapp.util.BillService"%>
<%@page import="com.hotel.mvc.springmvc_hotelapp.dto.FoodItem"%>
<%@page import="java.util.ArrayList"%>
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

	<table border="3">
		<tr>
			<th>Worker Name</th>
			<th>To Customer</th>
			<th>Order Date</th>
			<th>Time</th>



		</tr>
		<tr>
			<form:form modelAttribute="ordermodel">

				<td><form:input path="workerName" readonly="true" /></td>
				<td><form:input path="customerName" readonly="true" /></td>
				<td><form:input path="orderDate" readonly="true" /></td>
				<td><form:input path="time" readonly="true" /></td>

			</form:form>


		</tr>
		<%
		ArrayList<FoodItem> items = (ArrayList) session.getAttribute("allitems");

		BillService service = new BillService();

		double bill = service.totalBill(items);
		%>
	</table>
	<br>

	<table border="2">
		<tr>
			<th>Food Name</th>
			<th>Quantity</th>
			<th>Total Cost</th>
		</tr>
		<%
		for (FoodItem item : items) {
		%>

		<tr>
			<td><%=item.getItemName()%></td>
			<td><%=item.getQuantity()%></td>
			<td><%=item.getTotalCost()%></td>

		</tr>
		<%
		}
		%>

		<tr>
			<td colspan="2">Total Bill</td>
			<td colspan="2"><%= bill %></td>
		</tr>
	</table>

	<center>
		<a href="confirm"><input type="submit" value="Confirm Order"></a>
	</center>

</body>
</html>