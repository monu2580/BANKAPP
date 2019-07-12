package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Customer;

/**
 * Servlet implementation class Balance
 */
public class Balance extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) {
		try {
				
			HttpSession session=request.getSession();
			int accno=(int)session.getAttribute("acctno");
			
			Customer customer=new Customer();
			customer.setAccno(accno);
			
			boolean status=customer.balance(accno);
			if (status==true) {
				session.setAttribute("bal", customer.getBal());
				System.out.println("Your Current balance is : "+customer.getBal());
				response.sendRedirect("/BANKAPP/balancesuccess.jsp");
			}else {
				response.sendRedirect("/BANKAPP/balancefailure.jsp");
				System.out.println("Balance failure");
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
