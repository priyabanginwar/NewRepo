package com.genricLib;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	FileLib f=new FileLib();
	public static WebDriverCommonLib cb=new WebDriverCommonLib(); 
	public static WebDriver driver;
	
	@BeforeSuite
	public void connectDb()
	{
		System.out.println("-----DB Connection Successful----");
	}
	
	@BeforeClass
	public void BrowserLaunch() throws IOException
	{	
		System.setProperty("webdriver.chrome.driver","E:\\Qspider\\JarFiles\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(f.fetchDatafromProperty("url"));
		System.out.println("---Browser Launch Successfully---");
	}
	
	@BeforeMethod
	public void login() throws IOException
	{
		/*WebElement AccountLink =driver.findElement(By.xpath("//span[contains(text(),'Account & Lists')][1]"));
		cb.MoveMouseOverPointer(AccountLink);
		driver.findElement(By.linkText("Sign in")).click();
		WebElement EmailTB=driver.findElement(By.id("ap_email"));
		cb.WaitForElement(EmailTB);
		EmailTB.clear();
		EmailTB.sendKeys(f.fetchDatafromProperty("un"));
		driver.findElement(By.id("continue")).click();
		WebElement PasswordTB=driver.findElement(By.id("ap_password"));
		cb.WaitForElement(PasswordTB);
		PasswordTB.sendKeys(f.fetchDatafromProperty("pwd"));
		driver.findElement(By.id("signInSubmit")).click();*/
		System.out.println("--Login Successfull--");
	}
		
	@AfterMethod
	public void logout()
	{	
		/*WebElement AccountLink =driver.findElement(By.xpath("//span[contains(text(),'Account & Lists')][1]"));
		cb.MoveMouseOverPointer(AccountLink);
		driver.findElement(By.linkText("Sign Out")).click();*/
		System.out.println("--Logout--");
	}
	
	
	@AfterClass
	public void BrowserClose()
	{
		driver.close();
		System.out.println("----Browser Close----");
	}
	
	
	@AfterSuite
	public void DBConnectionClose()
	{
		System.out.println("-----DB Connection Close-----");
	}
}
