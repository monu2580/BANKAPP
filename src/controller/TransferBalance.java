package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Customer;

/**
 * Servlet implementation class TransferBalance
 */
public class TransferBalance extends HttpServlet {
	public void service(HttpServletRequest request,HttpServletResponse response) {
		
		try {
			
			HttpSession session=request.getSession();
			int accno1=(int)session.getAttribute("acctno");
			int amount=Integer.valueOf(request.getParameter("amount"));
			int accno2=Integer.valueOf(request.getParameter("accno2"));

			Customer customer=new Customer();
			int bal1=customer.getBalance(accno1);
			int bal2=customer.getBalance(accno2);
			String name1=customer.getNameOfAcc(accno1);
			String name2=customer.getNameOfAcc(accno2);
			
			boolean result=customer.getTransferDetails(accno1, amount, accno2);
			if (bal1!=0) {
				session.setAttribute("acctno", customer.getAccno());
				if (result) {
					session.setAttribute("amount", amount);
					session.setAttribute("pbal1", bal1);
					session.setAttribute("nbal1", bal1-amount);
					session.setAttribute("pbal2", bal2);
					session.setAttribute("nbal2", bal2+amount);
					session.setAttribute("accno1", accno1);
					session.setAttribute("accno2", accno2);
					session.setAttribute("name1", name1);
					session.setAttribute("name2", name2);
					
					response.sendRedirect("/BANKAPP/transfersuccess.jsp");
				}else {
					response.sendRedirect("/BANKAPP/transferfailure.jsp");
				}
			}else {
				response.sendRedirect("/BANKAPP/loginfailure.jsp");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
