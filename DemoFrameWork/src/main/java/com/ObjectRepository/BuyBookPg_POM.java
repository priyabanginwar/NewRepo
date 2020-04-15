package com.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuyBookPg_POM {

	@FindBy(xpath="//span[contains(text(),'Wings of Fire #06: Moon Rising')]")
	private WebElement Book;
	
	public WebElement getBookName()
	{
		return Book;
	}
	
}
