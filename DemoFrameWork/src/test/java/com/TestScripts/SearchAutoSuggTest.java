package com.TestScripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepository.AmazonHomePg_POM;
import com.ObjectRepository.WingsoffirePg_POM;
import com.genricLib.BaseClass;
import com.genricLib.WebDriverCommonLib;


@Listeners(com.genricLib.ListnerImplementation.class)
public class SearchAutoSuggTest extends BaseClass
{
	@Test
	public void AutoSuggestionCount()
	{
		AmazonHomePg_POM ahomePg=PageFactory.initElements(driver, AmazonHomePg_POM.class);
		WingsoffirePg_POM abookPg=PageFactory.initElements(driver, WingsoffirePg_POM.class);
		WebDriverCommonLib wcl=new WebDriverCommonLib();
		WebElement SearchDropDown=ahomePg.getsearchDD();
		String Pg_Title=driver.getTitle();
		Reporter.log("Page Title: "+Pg_Title,true);
		SearchDropDown.click();
		wcl.SelectItemfromList(SearchDropDown,"Books");
		ahomePg.getsearchbox().sendKeys("Wings of Fire");
		int exp_result=10;
		Reporter.log("Expected Autosuggestion count is "+exp_result, true);
		int act_result=ahomePg.Sugglist_count();
		Reporter.log("Actual Autosuggestion count is "+act_result, true);
		Assert.assertEquals(act_result,exp_result);
		
	}
	
	
}
