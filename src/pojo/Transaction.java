package pojo;

import java.sql.*;
import java.util.ArrayList;

public class Transaction {
	private int accno;
	private int amount;
	private int toaccno;
	private String status;
	private String date;
	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet res=null;
	 
	String url="jdbc:mysql://localhost:3306/bankapp";
	String un="root";
	String pw="monu9226";
	 
	//--------Constructor--------
	public Transaction() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, un, pw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Transaction(int accno, int amount, int toaccno, String status, String date) {
		super();
		this.accno = accno;
		this.amount = amount;
		this.toaccno = toaccno;
		this.status = status;
		this.date = date;
	}



	//--------Setter & Getter--------
	
	

	public void setToaccno(int toaccno) {
		this.toaccno = toaccno;
	}


	public void setAccno(int accno) {
		this.accno = accno;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getAccno() {
		return accno;
	}
	public int getToaccno() {
		return toaccno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String string) {
		this.date = string;
	}
	
	public void updateTransaction() {
		
		try {
			
			String sql="Insert into transaction values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, accno);
			pstmt.setInt(2, amount);
			pstmt.setInt(3, toaccno);
			pstmt.setString(4, "debit");
			pstmt.setString(5, date);
			pstmt.executeUpdate();
			
			
			
			String sql1="Insert into transaction values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql1);
			pstmt.setInt(1, toaccno);
			pstmt.setInt(2, amount);
			pstmt.setInt(3, accno);
			pstmt.setString(4, "credit");
			pstmt.setString(5, date);
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Transaction> getStatement() {
		Transaction t1=null;
		ArrayList<Transaction> al=new ArrayList<>();
		
		try {
			String sql="SELECT * FROM transaction Where accno=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, accno);
			
			res=pstmt.executeQuery();
			while (res.next()) {
				int a=res.getInt(1);
				int b=res.getInt(2);
				int c=res.getInt(3);
				String d=res.getString(4);
				String e=res.getString(5);
				t1=new Transaction(a,b,c,d,e);
				al.add(t1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	
}













