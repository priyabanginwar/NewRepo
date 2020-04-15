package com.genricLib;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplementation implements ITestListener
{
	public void onFinish(ITestContext arg0)
	{}
	
	public void onStart(ITestContext arg0)
	{}
	
	public void onTestFailedButWithinSuccess(ITestResult arg0)
	{}
	
	public void onTestFailure(ITestResult itr)
	{
		Date d=new Date();
		String currentdate=d.toString();
		String reqdate=currentdate.replaceAll(" ","").replaceAll(":","");
		String TC_name=itr.getName();
		EventFiringWebDriver web=new EventFiringWebDriver(BaseClass.driver);
		File Src=web.getScreenshotAs(OutputType.FILE);
		File Dest=new File("./src/main/resources/testCaseData/Screenshots/"+TC_name+reqdate+".png");
		try {
			FileUtils.copyFile(Src,Dest);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult arg0)
	{}
	
	public void onTestStart(ITestResult arg0)
	{}
	
	public void onTestSuccess(ITestResult arg0)
	{}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
}
