<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>
<head>
<title>truYum</title>
<link
	href="${pageContext.request.contextPath}/resources/style/style.css"
	type="text/css" rel="stylesheet">
</head>
<body>

	<table id="table1">
		<tr id="truyum">
			<td>truYum</td>
		</tr>
		<tr id="logo">
			<td><img
				src="${pageContext.request.contextPath}/resources/images/truyum-logo-light.png"
				alt="logo" height="55px" width=55px></td>
		</tr>
		<tr id="menu">
			<td><a href="/show-menu-list-admin">Menu</a></td>
			
			
		</tr>
		<tr align="center" >
			<td><a href="/">Home</a></td>
			
			
		</tr>
		
	</table>


	<div id="menuitems">
		<h2>Menu Items</h2>
	</div>
	<table id="table2">

		<tr>
			<th>Name</th>
			<th>Price</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Category</th>
			<th>Free Delivery</th>
			<th>Action</th>
		</tr>



		<c:forEach items="${admin}" var="menuItem">
			<tr>

				<td>${menuItem.name}</td>
				<td>Rs.<fmt:formatNumber type="number" pattern="##,###.00"
						value="${menuItem.price}" /></td>
				<td>${menuItem.active ? 'Yes' : 'No'}</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy"
						value="${menuItem.dateOfLaunch}" /></td>
				<td>${menuItem.category}</td>
				<td>${menuItem.freeDelivery ? 'Yes' : 'No'}</td>

				<td><a href="/show-edit-menu-item?menuItemId=${menuItem.id}">Edit</a></td>

			</tr>
		</c:forEach>

	</table>

	<div id="copyright">Copyright © 2019</div>


</body>
</html>