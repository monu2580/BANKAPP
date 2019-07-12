package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojo.Transaction;

public class Statement extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		int accno=(int) session.getAttribute("acctno");
		
		Transaction transaction=new Transaction();
		transaction.setAccno(accno);
		
		ArrayList<Transaction> al=new ArrayList<>();
		al.addAll(transaction.getStatement());
		session.setAttribute("al", al);
		
		
		for(Transaction t:al) {
			System.out.println(t.getAccno());
			System.out.println(t.getAmount());
			System.out.println(t.getToaccno());
			System.out.println(t.getStatus());
			System.out.println(t.getDate());
			System.out.println("--------------------------");
		}
		if(al.isEmpty()==false) {
			try {
				response.sendRedirect("/BANKAPP/statementdetails.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
