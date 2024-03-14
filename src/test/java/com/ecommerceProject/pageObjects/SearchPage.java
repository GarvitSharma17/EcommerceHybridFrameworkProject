package com.ecommerceProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {
	
	WebDriver ldriver;
	public SearchPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//input[@id='input-search']")
	WebElement searchBoxOnSearchPage;
	
	@FindBy(xpath="//input[@id='button-search']")
	WebElement searchBtn;
	
	@FindBy(xpath="//select[@name='category_id']")
	WebElement categoryDropDown;
	
	@FindBy(linkText="iMac")
	WebElement iMac;
	
	public boolean displayStatusofValidiMacProduct() 
	{
		boolean imacProduct = iMac.isDisplayed();
		return imacProduct;
	}
	
	public void searchProduct(String productName)
	{
		searchBoxOnSearchPage.sendKeys(productName);
	}
	
	public void clickOnSearchButton()
	{
		searchBtn.click();
	}
	
	public void selectCategory(String category)
	{
		categoryDropDown.click();
		Select drop = new Select(categoryDropDown);
		drop.selectByIndex(3);
	}
}
