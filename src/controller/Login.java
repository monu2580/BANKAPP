package controller;


import javax.servlet.http.*;

import pojo.Customer;

public class Login extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			String custid=request.getParameter("custid");
			String pass=request.getParameter("pass");
			
			Customer customer=new Customer();
			customer.setCustid(custid);
			customer.setPass(pass);
			
			
			Boolean result=customer.getAccountNo();
			if (result) {
				HttpSession session=request.getSession(true);
				session.setAttribute("acctno", customer.getAccno());
				session.setAttribute("bal", customer.getBalance(customer.getAccno()));
				response.sendRedirect("/BANKAPP/loginsuccessful.jsp");
			}else {
				response.sendRedirect("/BANKAPP/loginfailure.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
