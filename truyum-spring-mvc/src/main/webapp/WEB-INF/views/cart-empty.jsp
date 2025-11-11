<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
   
   <table  id="table1">
      <tr id="truyum"><td>truYum</td></tr>
      <tr id="logo"><td><img src="${pageContext.request.contextPath}/resources/images/truyum-logo-light.png" alt="logo" height="55px" width=55px></td></tr>
       <tr id="menu"><td><a href="/show-menu-list-customer">Menu</a></td></tr>
       <tr id="cart"><td><a href="/show-cart?cutomerId=1">Cart</a></td></tr>
    </table>
    

<div id="menuitems"><h2>Cart</h2></div>
<div id="cartempty"><caption>No items in cart. Use 'Add to Cart' option in</caption><a href="/show-menu-list-customer">Menu Item List</a></div>
<div id="copyright">Copyright © 2019</div>
    </body>
</html>