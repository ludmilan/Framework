package com.FrameWorkTestV1.testCases;

import org.testng.annotations.Test;
import com.FrameWorkTestV1.pageObject.PG_AppiumTest;
import com.FrameWorkTestV1.utilities.XLUtils;

import java.io.IOException;

import org.testng.annotations.DataProvider;
public class TC_Appium extends BaseClass_Appium {
	
  @Test(dataProvider="DT_Appium")
  public void functionAppuim(String user,String pwd) {
	  
	  //driver.findElementById("synapsys.com.wallet:id/ivCustomer").click(); 
	  //logger.info("Start the appium test");
	  PG_AppiumTest pat=new PG_AppiumTest(driver);
	  pat.clickOnCustomerButton("Customer");
	  pat.txtUserName.sendKeys(user);
	  pat.txtPassword.sendKeys(pwd);
	  pat.btnLogin.click();
	  
  }
  
  	@DataProvider(name="DT_Appium")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/FrameWorkTestV1/testData/DT_Appium.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String Data[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				Data[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
				
		}
	return Data;
	}
}
