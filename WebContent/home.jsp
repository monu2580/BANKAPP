<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Banking Application</title>

<link rel="stylesheet" href="cssfile3.css" type="text/css">
<script type="text/javascript">
	
	let sid='<%= session.getId() %>'
	function acc() {
		var val=<%=session.getAttribute("acctno")%>
		if(val!=null){
			alert("Accno= "+val);
		}else{
			alert("Login Required");
		}
		
	}
	function sclear() {
		
	}
</script>
</head>
<body marginheight="500dp">

<center>
		<h3><a href="Balance"  target="content">Check Balance</a></h3>
		<h3><a href="transfer.jsp" target="content">Transfer Amount</a></h3>
		<h3><a href="applyforloan.jsp" onclick="acc()" target="content">Apply Loan</a></h3>
		<h3><a href="changepassword.jsp" target="content">Change Password</a></h3>
		<h3><a href="Statement" target="content">Get Statements</a></h3>
		<h3><a href="changepassword.jsp" target="content">Forgot Password</a></h3>
		<h3><a href="loginframe.jsp" name="lout" onmousedown="" onclick="parent.head.location='titleframe.jsp'; parent.content.location='login.jsp'">Logout</a></h3>
</center>
</body>
</html>