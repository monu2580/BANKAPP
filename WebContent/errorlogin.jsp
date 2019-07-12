<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="cssfile1.css" type="text/css">
</head>
<body>
<h3>CustmerId or password can't be empty</h3>
<form action="Login">
	<table>
		<tbody>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="custid" required></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="pass" required></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</tbody>
	</table>
</form>
</body>
</html>