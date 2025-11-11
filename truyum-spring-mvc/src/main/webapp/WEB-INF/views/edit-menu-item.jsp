<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>truYum</title>
<style>
.error {
	color: red
}
</style>
<link
	href="${pageContext.request.contextPath}/resources/style/style.css"
	type="text/css" rel="stylesheet">
</head>
<body>

	<script src="${pageContext.request.contextPath}/resources/js/script.js"></script>
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
			<td><a href=/show-menu-list-admin">Menu</a></td>
		</tr>
	</table>

	<div id="menuitems">
		<h2>Edit Menu Item</h2>
	</div>
	<form:form name="modifiedMenuItem" action="/edit-menu-item"
		method="post" modelAttribute="modifiedMenuItem"
		onsubmit="return confirm('If you click ok item saved to the menu item successfully');">
		
		<form:input type="hidden" path="id" value="${menuItem.id}" />

		<div id="name">
			<label for="name"><span id="demo1">Name</span></label><br>
			<form:input path="name" id="itemname"
				placeholder="Enter the item name" pattern="[A-Z,a-z, ]+"
				value="${menuItem.name}" />
			<br>
			<form:errors path="name" cssClass="error" />
			<br> <br> <br>
		</div>
		<table id=table3>
			<tr>


				<td><label for="price">Price (Rs.)</label><br> <form:input
						path="price" type="number" placeholder="Enter the price"
						title="Enter the price" id="price" value="${menuItem.price}" /> <form:errors
						path="price" cssClass="error" /></td>

			</tr>
			<tr>
				<td><label for="price"><span id="demo2">Active</span></label><br>
					<form:radiobutton path="active" id="yes" value="yes" />Yes <form:radiobutton
						path="active" id="no" value="no" />No <br>
			</tr>
			<tr>



				<td><label for="Date of Launch">Date of Launch</label><br>
					<form:input type="date" id="date" path="dateOfLaunch"
						placeholder="Enter the date of launch"
						value="${menuItem.dateOfLaunch}" />
			</tr>

			<tr>
				<td><label for="Category">Category</label><br> <form:select
						path="category" id="category">



						<option value="Main course">Main course</option>
						<option value="Starters">Starters</option>
						<option value="Dessert">Dessert</option>
						<option value="Drinks">Drinks</option>






					</form:select></td>
			</tr>


		</table>


		<div id="freedelivery">
			<form:checkbox path="freeDelivery" value="Free Delivery" />
			Free Delivery

		</div>


		<div id="save">
			<input type="submit" value="Save" onclick="cost()">
		</div>
	</form:form>

	<div id="copyright">Copyright © 2019</div>


</body>
</html>