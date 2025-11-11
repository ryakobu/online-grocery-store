<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="${pageContext.request.contextPath}/resources/style/style.css"
	type="text/css" rel="stylesheet">
</head>
<body>
    
   <table  id="table1">
      <tr id="truyum"><td>truYum</td></tr>
      <tr id="logo"><td><img src="${pageContext.request.contextPath}/resources/images/truyum-logo-light.png" alt="logo" height="55px" width=55px></td></tr>
       <tr id="menu"><td><a href="/show-menu-list-admin">Menu</a></td></tr>
    </table>
    

<div id="menuitems"><h2>Edit Menu Item Status</h2></div>
<div id="menuitemstatus">Menu item details saved successfully</div>
<div id="copyright">Copyright © 2019</div>
    </body>
</html>