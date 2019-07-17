package com.FrameWorkTestV1.testCases;

import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connection {
	
		 String dbURL = "jdbc:sqlserver://192.168.202.211;databaseName=MWalletNew";
		 String username = "sa"; 
		 String password = "abcd@1234";
  @Test
  public String[] getSMSoutDetails(String reciever) throws ClassNotFoundException, SQLException {
	
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        Connection con = DriverManager.getConnection(dbURL,username,password);
	        ////System.out.println("Connection passed");
		    Statement st = con.createStatement();
		    String selectquery = "SELECT top 1 Message FROM [Transaction].[SmsOut] WHERE [Receiver] ='"+reciever+"' ORDER BY SmsID DESC";
		    ResultSet rs = st.executeQuery(selectquery);
		    String code = null,message =null;
		    while (rs.next()) {
		    message =rs.getString("Message");
		    String Message[]= rs.getString("Message").split(" ");
		    code = Message[9];
		    //System.out.println("The pin generated: "+ code);
		    System.out.println("The message generated: "+ message);
		    }
		    con.close();
		    return new String[] {code,message};
  }
  
  @Test
  public String[] getOTPDetails(String reciever) throws ClassNotFoundException, SQLException {
	
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        Connection con = DriverManager.getConnection(dbURL,username,password);
	        ////System.out.println("Connection passed");
		    Statement st = con.createStatement();
		    String selectquery = "SELECT top 1 Message FROM [Transaction].[SmsOut] WHERE [Receiver] ='"+reciever+"' ORDER BY SmsID DESC";
		    ResultSet rs = st.executeQuery(selectquery);
		    String code = null,message =null,code2=null;
		    while (rs.next()) {
		    message =rs.getString("Message");
		    String Message[]= rs.getString("Message").split(" ");
		    code = Message[0];
		    String RES = Message[4];
		    String cd[] = RES.split(".");
		    code2 = cd[0];
		    //System.out.println("The pin generated: "+ code);
		    System.out.println("The message generated: "+ message);
		    }
		    con.close();
		    return new String[] {code,message,code2};
  }
  
  @Test
  public String[] getNotification(String reciever) throws ClassNotFoundException, SQLException {
	
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        Connection con = DriverManager.getConnection(dbURL,username,password);
	        ////System.out.println("Connection passed");
		    Statement st = con.createStatement();
		    String selectquery = "SELECT top 1 Message,AddedDate FROM [Transaction].[Notifications] WHERE [Receiver] ='"+reciever+"' ORDER BY Id DESC";
		    ResultSet rs = st.executeQuery(selectquery);
		    String message =null,date = null;
		    while (rs.next()) {
		    message =rs.getString("Message");
		    date = rs.getString("AddedDate");
		    }
		    con.close();
		    return new String[] {date,message};
  }
  
  @Test
  public String getHoldAmount(String mobileNo) throws ClassNotFoundException, SQLException {
	  
	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      Connection con = DriverManager.getConnection(dbURL,username,password);
      //System.out.println("Connection passed");
	  Statement st = con.createStatement();
	  String selectquery = "SELECT HoldAmount FROM [BusinessEntity].[Accounts] WHERE [MobileNo]='"+mobileNo+"'";
	  ResultSet rs = st.executeQuery(selectquery);
	  String holdAmount =null;
	  while (rs.next()) {
		  holdAmount =rs.getString("HoldAmount");		  
		  System.out.println("Hold Amount is : "+ holdAmount);
	    }
	    con.close();	
	    return holdAmount;
  }
  
  @Test
  public String getBalanceAmount(String mobileNo) throws ClassNotFoundException, SQLException {
	  
	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      Connection con = DriverManager.getConnection(dbURL,username,password);
      //System.out.println("Connection passed");
	  Statement st = con.createStatement();
	  String selectquery = "SELECT Balance FROM [BusinessEntity].[Accounts] WHERE [MobileNo]='"+mobileNo+"'";
	  ResultSet rs = st.executeQuery(selectquery);
	  String balanceAmount =null;
	  while (rs.next()) {
		  balanceAmount =rs.getString("Balance");
		  System.out.println("Balance Amount is : "+ balanceAmount);
	    }
	    con.close();
	    return balanceAmount;
  }
  
  @Test
  public String getRferenceCode(String mobileNo) throws ClassNotFoundException, SQLException {
	  
	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      Connection con = DriverManager.getConnection(dbURL,username,password);
      //System.out.println("Connection passed");
	  Statement st = con.createStatement();
	  String selectquery = "SELECT ReferenceCode FROM [BusinessEntity].[Accounts] WHERE [MobileNo]='"+mobileNo+"'";
	  ResultSet rs = st.executeQuery(selectquery);
	  String refCode =null;
	  while (rs.next()) {
		  refCode =rs.getString("ReferenceCode");
		 // System.out.println("Balance Amount is : "+ refCode);
	    }
	    con.close();
	    return refCode;
  }
  
  @Test
  public String getRegNumber(String businessEntityCode) throws ClassNotFoundException, SQLException {
	  
	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      Connection con = DriverManager.getConnection(dbURL,username,password);
      //System.out.println("Connection passed");
	  Statement st = con.createStatement();
	  String selectquery = "SELECT RegistrationNo FROM [BusinessEntity].[BusinessEntity] WHERE [BusinessEntityCode]='"+businessEntityCode+"'";
	  ResultSet rs = st.executeQuery(selectquery);
	  String regNo =null;
	  while (rs.next()) {
		  regNo =rs.getString("ReferenceCode");
		 // System.out.println("Balance Amount is : "+ refCode);
	    }
	    con.close();
	    return regNo;
  }
  
  @Test
  public String[] getPreTransactionDetails(String mobileNo) throws ClassNotFoundException, SQLException {
	  
	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      Connection con = DriverManager.getConnection(dbURL,username,password);
      //System.out.println("Connection passed");
	  Statement st = con.createStatement();
	  String selectquery = "SELECT top 1 PreTransactionID,Amount,Receiver,TypeCode FROM [Transaction].[PreTransactions] WHERE [Sender]='"+mobileNo+"'and [CategoryId]='5' ORDER BY PreTransactionID DESC";
	  ResultSet rs = st.executeQuery(selectquery);
	  String preTransactionID = null,amount = null,receiver = null,typeCode=null;
	  while (rs.next()) {
		  preTransactionID =rs.getString("PreTransactionID");
		  amount=rs.getString("Amount");
		  receiver=rs.getString("Receiver");
		  typeCode=rs.getString("TypeCode");	  
		  System.out.println("PreTransactionID is : "+ preTransactionID);
		  System.out.println("amount is : "+ amount);
		  System.out.println("receiver is : "+ receiver);
		  System.out.println("typeCode is : "+ typeCode);
	    }
	    con.close();	
	    return new String [] {preTransactionID,amount,receiver,typeCode};
  }
  
  @Test
  public String[] getTransactionDetails(String RefNo) throws ClassNotFoundException, SQLException {
	  
	  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      Connection con = DriverManager.getConnection(dbURL,username,password);
      //System.out.println("Connection passed");
	  Statement st = con.createStatement();
	  String selectquery = "SELECT Status,TypeCode,Amount,CreatedDate FROM [Transaction].[Transactions] WHERE [RefNo]='"+RefNo+"'";
	  ResultSet rs = st.executeQuery(selectquery);
	  String status= null,amount= null,typeCode=null,createdDate=null;
	  while (rs.next()) {
		  status =rs.getString("Status");
		  amount=rs.getString("Amount");
		  typeCode=rs.getString("TypeCode");	 
		  createdDate=rs.getString("CreatedDate");
	    }
	    con.close();	
	    return new String[] {status,amount,typeCode,createdDate};
  }
    
  
}
