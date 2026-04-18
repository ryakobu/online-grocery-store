<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
			<td><a href="/show-menu-list-customer">Menu</a></td>
		</tr>
		<tr id="cart">
			<td><a href="cart.html">Cart</a></td>
		</tr>
	</table>


	<div id="menuitems">
	<c:if test="${status}">
	<div id="addtocart">Item removed from Cart Successfully</div>
	</c:if>
	
		<h2>Cart</h2>
	</div>
	<table id="table2">
		<tr>
			<th>Name</th>
			<th>Free Delivery</th>
			<th>Price</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${cartMenuList}" var="cartMenuItem">
			<tr>

				<td>${cartMenuItem.name}</td>
				<td>${cartMenuItem.freeDelivery ? 'Yes' : 'No'}</td>
				<td>Rs.<fmt:formatNumber type="number" pattern="##,###.00"
						value="${cartMenuItem.price}" /></td>

				<td><a
					href="/remove-cart?menuItemId=${cartMenuItem.id}&cutomerId=1">Delete</a></td>

			</tr>
		</c:forEach>
		<tr>
			<th></th>
			<th>Total</th>
			<th>Rs. ${total}</th>
		</tr>
	</table>
	<div id="copyright">Copyright © 2019</div>
</body>
</html>
</html>