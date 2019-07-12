package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Customer;

/**
 * Servlet implementation class ResetPass
 */
public class ResetPass extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			HttpSession session=request.getSession();
			String email=(String) session.getAttribute("email");
			String pass=request.getParameter("npass");
			
			Customer customer=new Customer();
			customer.setEmail(email);
			customer.setPass(pass);
			
			boolean ststus=customer.resetPass();
			if (ststus) {
				response.sendRedirect("/BANKAPP/changepasswordsuccessful.html");
			}else {
				response.sendRedirect("/BANKAPP/changepasswordfailure.html");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
