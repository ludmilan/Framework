package com.FrameWorkTestV1.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PG_AppiumTest {

	WebDriver ldriver;
	
	public PG_AppiumTest(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
		
	public void clickOnCustomerButton(String AccountType)
	{
	    //String AccountType ="Customer";
		String path ="synapsys.com.wallet:id/iv"+AccountType;
		WebElement btnCustomer = ldriver.findElement(By.id(path));	
		btnCustomer.click();
	}
	
	@FindBy(id="synapsys.com.wallet:id/txtWalletNo")
	@CacheLookup
	public WebElement txtUserName;
	
	@FindBy(id="synapsys.com.wallet:id/txtPin")
	@CacheLookup
	public WebElement txtPassword;
	
	@FindBy(id="synapsys.com.wallet:id/btnLogin")
	@CacheLookup
	public WebElement btnLogin;
	
	
	
}
