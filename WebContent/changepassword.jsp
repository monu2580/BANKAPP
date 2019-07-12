<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="cssfile1.css" type="text/css">
<script type="text/javascript">
	function checkPass() {
		let pw=document.loginform.npass.value;
		let cpw=document.loginform.cpass.value;
		if(pw==cpw){
			document.loginform.subm.disabled=false;
		}else{
			document.loginform.subm.disabled=true;
		}
		
	}
	let npw=document.table2.npw.value;
    let cpw=document.table2.cpw.value;
    
    function validatePassword1() {
    	var regularExpression  = /^[a-zA-Z]$/;
        var p = document.getElementById('npass').value,
            errors = [];
        if (p.length < 8) {
            errors.push("Your password must be at least 8 characters");
        }
        if (p.search(/[a-z]/i) < 0) {
            errors.push("Your password must contain at least one letter."); 
        }

        if (p.search(/[!@#$%^&*]/) < 0) {
            errors.push("Your password must contain at least one Special Character."); 
        }
        if (p.search(/[0-9]/i) < 0) {
            errors.push("Your password must contain at least one digit.");
        }
        if (errors.length > 0) {
            alert(errors.join("\n"));
            return false;
        }
        return true;
    }
</script>
<style type="text/css">
    input#search
    {
        width: 100px;
        height: 80em;
    }
</style>
</head>


<body>
<center style="margin: 50px">
<form action="ChangePass" name="loginform">
	<table>
		<tbody>
			<tr>
				<td><lable>New Password</lable></td>
				<td><input type="text" name="npass" id="npass" required></td>
			</tr>
			<tr>
				<td><lable><br/>Confirm Password</lable></td>
				<td><br/><input type="text" name="cpass" reuired></td>
			</tr>
		</tbody>
	</table>
	<br/><br/>
	<input  type="submit"  onclick="validatePassword1()" name="subm" ></td>
</form>
</center>
</body>
</html>