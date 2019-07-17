package com.FrameWorkTestV1.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
	String username=pro.getProperty("username");
	return username;
	}
	
	public String getPassword()
	{
	String password=pro.getProperty("password");
	return password;
	}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}

	//Mobile automation configuration data
	
	public String getAutomationName()
	{
	String automationName=pro.getProperty("automationName");
	return automationName;
	}	
	
	public String getAppiumURL()
	{
	String appiumURL=pro.getProperty("appiumURL");
	return appiumURL;
	}	
	public String getMobilePlatformName()
	{
	String mobilePlatformName=pro.getProperty("mobilePlatformName");
	return mobilePlatformName;
	}
	
	public String getMobilePlatformVersion()
	{
	String mobilePlatformVersion=pro.getProperty("mobilePlatformVersion");
	return mobilePlatformVersion;
	}
	
	public String getMobileDeviceName()
	{
	String mobileDeviceName=pro.getProperty("mobileDeviceName");
	return mobileDeviceName;
	}
	
	public String getAppPackage() 
	{
		String appPackage=pro.getProperty("appPackage");
		return appPackage;
	}

	public String getAppActivity() 
	{
		String appActivity=pro.getProperty("appActivity");
		return appActivity;
	}

	
}




