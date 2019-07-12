package pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Customer {
	private int accno;
	private String custid;
	private String name;
	private int bal;
	private String email;
	private String pass;

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet res=null;
	
	String url="jdbc:mysql://localhost:3306/bankapp";
	String user="root";
	String password="monu9226";
	
	//-------Constructor---------
	public Customer() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//-------Setter & Getter-------
	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	//-----------Get Account no.------------------
	public boolean getAccountNo() {
		try {
			String sql="Select * from bankapp.customer Where custid=? and pass=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, custid);
			pstmt.setString(2, pass);
			res =pstmt.executeQuery();
			
			while (res.next()) {
				accno=res.getInt(1);
				
				return true;
			}
			return false;
		} catch (Exception e) {
			
		}
		
		return false;
	}
	
	//-----------Get Balance--------------
	public boolean balance(int accno1) {
		try {
			String sql="Select balance from bankapp.customer Where accno=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, accno1);
			res =pstmt.executeQuery();
			
			while (res.next()) {
				bal=res.getInt(1);
				
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public int getBalance(int accno1) {
		try {
			String sql="Select balance from bankapp.customer Where accno=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, accno1);
			res =pstmt.executeQuery();
			
			while (res.next()) {
				bal=res.getInt(1);
				
				return bal;
			}
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//-----------Transfer Amount------------------
	public boolean getTransferDetails(int accno1,int amount, int accno2 ) {
		try {
			
			String sql1="UPDATE bankapp.customer SET BALANCE=("
								+ "SELECT BALANCE-? FROM (SELECT * FROM bankapp.customer) as a "
										+ "WHERE a.ACCNO=?) WHERE ACCNO=?";
			pstmt=con.prepareStatement(sql1);
			pstmt.setInt(1, amount);
			pstmt.setInt(2, accno1);
			pstmt.setInt(3, accno1);
			int s1=pstmt.executeUpdate();
			
			
			String sql2="UPDATE bankapp.customer SET BALANCE=("
								+ "SELECT BALANCE+? FROM (SELECT * FROM bankapp.customer) as a "
										+ "WHERE a.ACCNO=?) WHERE ACCNO=?";
			
			pstmt=con.prepareStatement(sql2);
			pstmt.setInt(1, amount);
			pstmt.setInt(2, accno2);
			pstmt.setInt(3, accno2);
			int s2=pstmt.executeUpdate();
			
			Date date = new Date();  
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			//String date = java.time.LocalDate.now().toString();
			String date1=formatter.format(date);
			
			Transaction transaction=new Transaction();
			transaction.setAccno(accno1);
			transaction.setAmount(amount);
			transaction.setToaccno(accno2);
			transaction.setDate(date1);
			transaction.updateTransaction();
			//------------------------------------
			
			if(s1!=0) {
				
				System.out.println("Transfer Successful From "+accno1);
				if (s2!=0) {
					System.out.println("Transfer Successful To "+accno2);
				}else {
					System.out.println("Transfer UnSuccessful To "+accno2);
				}
				return true;
			}
			else {
				System.out.println("Transfer UnSuccessful1");
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Transfer UnSuccessful2");
		return false;
	}
	
	//-----------Change Password------------------
	public boolean changePass(int accno1, String npass){
		
		try {
			String sql1="UPDATE bankapp.customer SET PASS=? WHERE ACCNO=?";
			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1, npass);
			pstmt.setInt(2, accno1);
			int s1=pstmt.executeUpdate();
			if (s1!=0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//-----------Reset Password------------------
		public boolean resetPass(){
			
			try {
				String sql1="UPDATE bankapp.customer SET PASS=? WHERE EMAIL=?";
				pstmt=con.prepareStatement(sql1);
				pstmt.setString(1, pass);
				pstmt.setString(2, email);
				int s1=pstmt.executeUpdate();
				if (s1!=0) {
					return true;
				}
				return false;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
	
	//-----------Get Name Of Account Holder------------------
	public String getNameOfAcc(int accno1) {	
	try {
		String sql="SELECT NAME From bankapp.customer Where ACCNO=?";
		pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, accno1);
		res =pstmt.executeQuery();
		
		while (res.next()) {
			name=res.getString(1);
			
			return name;
		}
		return null;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
	}
	
}
