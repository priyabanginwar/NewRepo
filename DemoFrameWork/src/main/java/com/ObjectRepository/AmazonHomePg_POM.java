package com.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class AmazonHomePg_POM {

	@FindBy(id="twotabsearchtextbox")
	private WebElement SearchBox; 
	
	@FindBy(xpath="//span[contains(text(),'Account & Lists')][1]")
	private WebElement Acct_listLB;
	
	@FindBy(id="searchDropdownBox")
	private WebElement SearchDropDown;
	
	@FindBy(xpath="//span[contains(text(),'Go')]")
	private WebElement SearchIcon;
	
	@FindBys(@FindBy(xpath="//div[@class='s-suggestion']"))
	private List<WebElement> Suggestlist;
	
	public List<WebElement> getSuggestList()
	{
		return Suggestlist;
	}
	
	public WebElement getsearchbox()
	{
		return SearchBox;
	}
	
	public WebElement getaccount_ListLB()
	{
		return Acct_listLB;
	}	
	
	public WebElement getsearchDD()
	{
		return SearchDropDown;
	}
	
	public WebElement getsearchIcon()
	{
		return SearchIcon;
	}
	
	public int Sugglist_count()
	{
		int count=Suggestlist.size();
		//System.out.println(count);
		return count;
	}
	
	public void SuggestionList()
	{
		for(WebElement we:Suggestlist)
		{
			String list=we.getText();
			System.out.println(list);
			
		}
		
	}
	
}
