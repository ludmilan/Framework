package com.FrameWorkTestV1.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FrameWorkTestV1.testCases.BaseClass;
import com.FrameWorkTestV1.pageObject.LoginPage;
import com.FrameWorkTestV1.utilities.XLUtils;

public class DataDrivenTest extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.txtUserName.sendKeys(user);
		logger.info("Entered the username");
		lp.txtPassword.sendKeys(pwd);
		logger.info("Entered the password");
		lp.btnLogin.click();
		//captureScreen(driver, "loginDDT");
		
		Thread.sleep(3000);	
	}
		
	public boolean isAlertPresent() //user defined method created to check alert is present or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
		
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/FrameWorkTestV1/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
				
		}
	return logindata;
	}
	
}
