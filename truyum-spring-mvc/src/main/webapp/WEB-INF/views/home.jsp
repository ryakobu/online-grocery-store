<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
    <title>truYum</title>
    <link
	href="${pageContext.request.contextPath}/resources/style/style.css"
	type="text/css" rel="stylesheet">
    </head>
<body>
    
   <table  id="table1">
      <tr id="truyum"><td>truYum</td></tr>
      <tr id="logo"><td><img src="${pageContext.request.contextPath}/resources/images/truyum-logo-light.png" alt="logo" height="55px" width=55px></td></tr>

    </table>
 <div id="admin"><a href="/show-menu-list-admin">Admin</a></div>
     <div id="customer"><a href="/show-menu-list-customer">Customer</a></div>
    <div id="copyright">Copyright © 2019</div>
</body>
</html>