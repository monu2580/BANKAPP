<%@page import="pojo.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Transfer Amount Page</title>
<link rel="stylesheet" href="cssfile1.css" type="text/css">
<script type="text/javascript">
	function validate() {
		let bal=<%= session.getAttribute("bal")%>
		let accno=document.transferform.accno2.value;
		let amount=document.transferform.amount.value;

		if(amount<=bal){
			document.transferform.subm.disabled=false;
		}else{
			document.transferform.subm.disabled=true;
			alert("Low Balance  \nyou have Entered amount : "+amount+"\nYour current balance is : "+bal);
		}
		if(amount==null){
			alert("Login First : ");
		}
	}
</script>
</head>
<body>
<form action="TransferBalance" name="transferform">
	<table>
		<tbody>
			<tr>
				<td><br/>Enter Account Number :</td>
				<td><br/><input type="number" name="accno2" onchange="validate()" required></td>
			</tr>
			<tr>
				<td><br/>Enter Amount :</td>
				<td><br/><input type="number" name="amount" onkeyup="validate()" required></td>
			</tr>
		</tbody>
	</table>
	<input  type="submit" name="subm" value="Transfer" disabled="disabled">
</form>
</body>
</html>