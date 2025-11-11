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
			<td><a href="/show-menu-list-customer">Menu</a></td>
			
		</tr>
		<tr id="cart">
			<td><a href="/show-cart?cutomerId=1">Cart</a></td>
		</tr>
		<tr align="right" >
			<td><a href="/">Home</a></td>
			
			
		</tr>
	</table>


	<div id="menuitems">
		<h2>Menu Items</h2>
	</div>
	<c:if test="${status}">
	<div id="addtocart">Item added to Cart Successfully</div>
	</c:if>
	<table id="table2">
		<tr>
			<th>Name</th>
			<th>Free Delivery</th>
			<th>Price</th>
			<th>Category</th>
			<th>Action</th>
		</tr>
		
		<c:forEach items="${customer}" var="menuItemListCustomer">
			<tr>

				<td>${menuItemListCustomer.name}</td>
				<td>${menuItemListCustomer.freeDelivery ? 'Yes' : 'No'}</td>
				<td>Rs.<fmt:formatNumber type="number" pattern="##,###.00"
						value="${menuItemListCustomer.price}" /></td>
				<td>${menuItemListCustomer.category}</td>
				<td><a href="/add-to-cart?menuItemId=${menuItemListCustomer.id}&cutomerId=1">Add to Cart</a></td>

			</tr>
		</c:forEach>
	</table>
	<div id="copyright">Copyright © 2019</div>
</body>
</html>