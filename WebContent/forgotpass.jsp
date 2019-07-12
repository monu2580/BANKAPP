<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>
<link rel="stylesheet" href="cssfile1.css" type="text/css">
</head>
<body>
<h1>Forgot Password</h1>
<form action="ForgotPass" name="fpass">
	<table>
		<tbody>
			<tr>
				<td>Enter email  : </td>
				<td><input type="email" name="emil" required="required"/></td>
			</tr>
			<tr>
				<td>Confirm email : </td>
				<td><input type="email" name="cemail" required="required"/></td>
			</tr>
		</tbody>
	</table>
	<input type="submit" />
</form>
</body>
</html>