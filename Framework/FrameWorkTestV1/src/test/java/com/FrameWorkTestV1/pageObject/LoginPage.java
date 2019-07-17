package com.FrameWorkTestV1.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
		
	@FindBy(xpath="//input[@name='txtuserName']")
	@CacheLookup
	public WebElement txtUserName;
	
	@FindBy(xpath="//input[@name='txtpassword']")
	@CacheLookup
	public WebElement txtPassword;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	@CacheLookup
	public WebElement btnLogin;
	
	
	@FindBy(xpath="//a[text()='Logout']")
	@CacheLookup
	public WebElement lnkLogout;
	
	/*
	 * public void setUserName(String uname) { txtUserName.sendKeys(uname); }
	 * 
	 * public void setPassword(String pwd) { txtPassword.sendKeys(pwd); }
	 * 
	 * public void clickSubmit() { btnLogin.click(); }
	 * 
	 * public void clickLogout() { lnkLogout.click(); }
	 */
	
	
}
