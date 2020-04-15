package com.genricLib;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib {
	public void WaitForElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(BaseClass.driver,60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void MoveMouseOverPointer(WebElement element)
	{
		Actions act=new Actions(BaseClass.driver);
		act.moveToElement(element).perform();
	}
	
	public void SelectItemfromList(WebElement element,String item)
	{
		Select s=new Select(element);
		s.selectByVisibleText(item);
	}
	
	public void AcceptAlert()
	{
		Alert alt=BaseClass.driver.switchTo().alert();
		alt.accept();
	}
	
	public void RejectAccept()
	{
		Alert alt=BaseClass.driver.switchTo().alert();
		alt.dismiss();
	}
	
	public String getAlertText()
	{
		Alert alt=BaseClass.driver.switchTo().alert();
		return alt.getText();
	}
	
	public void NavigatotoChildWindow()
	{
		Set<String> allId=BaseClass.driver.getWindowHandles();
		String mainId=BaseClass.driver.getWindowHandle();
		Iterator<String> it=allId.iterator();
		while(it.hasNext())
		{
		
		String id=it.next();
		if(!id.equals(mainId))
		{
		BaseClass.driver.switchTo().window(id);
		}}
	}
	
	public void navigateToParentWindow()
	{
		String ParentId=BaseClass.driver.getWindowHandle();
		BaseClass.driver.switchTo().window(ParentId);	
	}
	
	public void ScrollWindow(int x,int y)
	{
		JavascriptExecutor exe=(JavascriptExecutor)BaseClass.driver;
		exe.executeScript("Window.scrollBy(x,y)");
		
	}
	
}
