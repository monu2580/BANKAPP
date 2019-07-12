package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Customer;

/**
 * Servlet implementation class ChangePass
 */
public class ChangePass extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			HttpSession session=request.getSession();
			int accno=(int) session.getAttribute("acctno");
			String pass=request.getParameter("pass");
			
			Customer customer=new Customer();
			customer.setAccno(accno);
			
			boolean ststus=customer.changePass(accno, pass);
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
