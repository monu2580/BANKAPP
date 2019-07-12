<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Frame</title>
<link rel="stylesheet" href="cssfile.css" type="text/css">

<script type="text/javascript">
	function  removeattr() {
		document.getElementById("alogin").removeAttribute('href');	
	}
	function  setattr() {
		document.getElementById("alogin").setAttribute('href','home.jsp');	
	}
	let sid='<% session.getId(); %>'
	
</script>
</head>
<body>
<center>
<a href="home.jsp" id="alogin" onmouseover="check()" onclick="parent.content.location='login.jsp" ><h1>Login</h1></a>
</center>
</body>
</html>