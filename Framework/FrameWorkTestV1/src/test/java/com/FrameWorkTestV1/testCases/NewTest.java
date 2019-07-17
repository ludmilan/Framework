package com.FrameWorkTestV1.testCases;

import java.sql.SQLException;

import org.testng.annotations.Test;

import com.FrameWorkTestV1.utilities.Reporting;
import com.aventstack.extentreports.Status;

public class NewTest extends BaseClass {
	
	     
	        
	    @Test
	    public void stepLogsGeneration() throws ClassNotFoundException, SQLException
	    {
	    	DB_Connection db = new DB_Connection();
	    	String retrievePreTransData[] = db.getPreTransactionDetails("0718888888");
	    	System.out.println(retrievePreTransData);
	    }
	         
	   

	 
}
