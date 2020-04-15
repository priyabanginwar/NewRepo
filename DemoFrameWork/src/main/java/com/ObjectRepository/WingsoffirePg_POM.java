package com.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WingsoffirePg_POM {

	@FindBy(linkText="Wings of Fire: An Autobiography of Abdul Kalam")
	private WebElement WingsOfFire;
	
	@FindBy(xpath="//div[@class='sg-col-inner']")
	private WebElement Records;
	
	@FindBy(xpath="//span[contains(text(),'results for')]")
	private WebElement NobofResults;
	
	@FindBy(xpath="//span[contains(text(),'Learning How to Fly: Life Lessons for the Youth')]")
	private WebElement BookName;	
	
	@FindBy(xpath="//span[contains(text(),'Wings of Fire #06: Moon Rising')]")
	private WebElement Book6;
	
	public WebElement getWingsofFire()
	{
		return WingsOfFire;
	}
	
	public WebElement getRecordText()
	{
		return Records;
	}
	
	public WebElement getnobOfResults()
	{
		return NobofResults;
	}
	
	public WebElement getBookName()
	{
		return BookName;
	}
	public WebElement getBook6()
	{
		return Book6;
	}
}
