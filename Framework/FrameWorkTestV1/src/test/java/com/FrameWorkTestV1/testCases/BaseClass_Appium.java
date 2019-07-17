package com.FrameWorkTestV1.testCases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.FrameWorkTestV1.utilities.ReadConfig;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass_Appium {

	ReadConfig readconfig=new ReadConfig();
	public String automationName= readconfig.getAutomationName();
	public String appiumURL= readconfig.getAppiumURL();
	public String mobilePlatformName= readconfig.getMobilePlatformName();
	public String mobilePlatformVersion= readconfig.getMobilePlatformVersion();
	public String mobileDeviceName= readconfig.getMobileDeviceName();
	public String appPackage= readconfig.getAppPackage();
	public String appActivity= readconfig.getAppActivity();
	
	public static Logger logger;
	public static AndroidDriver<WebElement> driver;
	
	@BeforeClass
	public void setup() throws MalformedURLException, InterruptedException	
	{	
		DesiredCapabilities dc =new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,readconfig.getAutomationName());
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, readconfig.getMobilePlatformName());
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, readconfig.getMobilePlatformVersion());
		dc.setCapability(MobileCapabilityType.DEVICE_NAME,readconfig.getMobileDeviceName() );
		//dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\MaheshikaD\\Desktop\\Appium\\MTeller-debug.apk");		
		dc.setCapability("appPackage", readconfig.getAppPackage());
		dc.setCapability("appActivity", readconfig.getAppActivity());		
		URL url=new URL(readconfig.getAppiumURL());
	    driver=new AndroidDriver<WebElement>(url,dc);
		Thread.sleep(5000);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
}
