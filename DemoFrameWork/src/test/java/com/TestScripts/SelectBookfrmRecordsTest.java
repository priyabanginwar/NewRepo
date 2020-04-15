package com.TestScripts;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ObjectRepository.AmazonHomePg_POM;
import com.ObjectRepository.BuyBookPg_POM;
import com.ObjectRepository.WingsoffirePg_POM;
import com.genricLib.BaseClass;
import com.genricLib.WebDriverCommonLib;

public class SelectBookfrmRecordsTest extends BaseClass {
	@Test
	public void SelectItemfrmRecords() throws InterruptedException
	{
	AmazonHomePg_POM ahPg=PageFactory.initElements(driver, AmazonHomePg_POM.class);
	WingsoffirePg_POM abkPg=PageFactory.initElements(driver, WingsoffirePg_POM.class);
	BuyBookPg_POM abbkPg=PageFactory.initElements(driver, BuyBookPg_POM.class);
	WebDriverCommonLib wcl=new WebDriverCommonLib();
	String Pg_Title=driver.getTitle();
	Reporter.log("Page Title: "+Pg_Title,true);
	WebElement SearchDropDown=ahPg.getsearchDD();
	SearchDropDown.click();
	wcl.SelectItemfromList(SearchDropDown,"Books");
	ahPg.getsearchbox().sendKeys("Wings of Fire");
	Reporter.log("Autosuggestion count is "+ahPg.Sugglist_count(), true);
	ahPg.SuggestionList();
	String exp_Book="wings of fire book 6";
	List<WebElement> Suggestions=ahPg.getSuggestList();
	for(WebElement wb:Suggestions)
	{
		String BookName=wb.getAttribute("data-keyword");
		if(BookName.equals(exp_Book))
		{
			wb.click();
			break;
		}
	}

	 WebElement recordtext=abkPg.getRecordText();
	 WebDriverWait wait=new WebDriverWait(driver,60);
	 wait.until(ExpectedConditions.visibilityOf(recordtext));
	 String Page_Title=driver.getTitle();
	 Reporter.log("Page Title: "+Page_Title,true);
	 WebElement book6=abkPg.getBook6();
	 book6.click();
	 wcl.NavigatotoChildWindow();
	 WebDriverWait wait1=new WebDriverWait(BaseClass.driver,60);
	 WebElement bookname=abbkPg.getBookName();
	 wait1.until(ExpectedConditions.visibilityOf(bookname));
	 String NextPageExp_Title=driver.getTitle();
	 Reporter.log(NextPageExp_Title);
	 String NextPageAct_Title="Buy Wings of Fire #06: Moon Rising Book";
	 Assert.assertTrue(NextPageExp_Title.contains(NextPageAct_Title));
}
}