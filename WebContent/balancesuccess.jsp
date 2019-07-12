<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="cssfile1.css" type="text/css">
</head>
<body>
<h1>Your Account Balance is : </h1>
<%int balance=(int)session.getAttribute("bal");%>
<h1>
<%out.println(balance);%>
</h1>
</body>
</html>