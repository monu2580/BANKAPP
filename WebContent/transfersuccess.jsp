<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transaction Details</title>
<link rel="stylesheet" href="cssfile1.css" type="text/css">
</head>
<body>
<h1>Balance Transfer Details</h1>
<%
int amount=(int)session.getAttribute("amount");
int pbal1=(int)session.getAttribute("pbal1");
int nbal1=(int)session.getAttribute("nbal1");
int pbal2=(int)session.getAttribute("pbal2");
int nbal2=(int)session.getAttribute("nbal2");
int accno1=(int)session.getAttribute("accno1");
int accno2=(int)session.getAttribute("accno2");
String name1=(String)session.getAttribute("name1");
String name2=(String)session.getAttribute("name2");
%>

<% out.println("Payer Details :"); %><br/>
<% out.println("Account No. :"+accno1); %><br/>
<% out.println("Name : "+name1); %><br/>
<%out.println("Previous Balance : "+pbal1+"\n"); %><br/>
<%out.println("New Balance : "+nbal1+"\n"); %><br/><br>

<%out.println("Transfer Amount : "+amount+"\n"); %><br/>
<% out.println("Time :" +LocalDateTime.now() ); %><br/><br>

<% out.println("Payee Details :"); %><br/>
<% out.println("Account No. :"+accno2); %><br/>
<% out.println("Name : "+name2); %><br/>

</body>
</html>