<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@page import="javax.print.attribute.standard.PDLOverrideSupported"%>
<%@page import="pojo.Transaction"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Statement Details</title>
<link rel="stylesheet" href="cssfile1.css" type="text/css">
</head>
<body>
<h1>All Transaction Statements </h1>
	<table>
		<tbody>
			<tr> 
				<th>Amount &nbsp &nbsp </th>
				<th>To_Account  &nbsp &nbsp </th>
				<th>Status    &nbsp &nbsp &nbsp &nbsp</th>
				<th>Date/Time</th>
			</tr>
		</tbody>	
	</table>
<%
ArrayList<Transaction> al=new ArrayList<>();
for(Transaction t:(ArrayList<Transaction>)session.getAttribute("al")){
	
	out.println("&nbsp &nbsp &nbsp"+t.getAmount()+" &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp ");
	out.println(t.getToaccno()+"&nbsp &nbsp &nbsp &nbsp &nbsp ");
	out.println(t.getStatus()+"&nbsp&nbsp&nbsp&nbsp &nbsp");
	out.println(t.getDate()+"<br>");
	
}
%>

</body>
</html>



