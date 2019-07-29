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

		<center>

		<form action="Login" name="loginform">
			<table>
				<tbody>
					<tr>
						<td><b><br>UserName</b></td>
						<td><br><input type="text" name="custid" value="abc001" required></td><br/><br/>
					</tr><br/>
					<tr>
						<td><br><b>Password</b></td>
						<td><br><input type="password" name="pass" required></td>
					</tr>
				</tbody>
			</table><br><br>
			<input type="submit" name="subm" onsubmit="parent.home.location='home.jsp'" >
			<a href="forgotpass.jsp">Forgot Password</a>	
		</form>
		</center>
		
	</body>
</html>
