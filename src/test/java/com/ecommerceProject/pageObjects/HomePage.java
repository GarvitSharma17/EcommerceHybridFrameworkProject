package com.ecommerceProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
	
public class HomePage {
	
	WebDriver ldriver;
	public HomePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath="//span[contains(text(), \"My Account\")]")
	WebElement myacc;
	
	@FindBy(linkText = "Login")
	WebElement lgn;
	
	@FindBy(linkText = "Register")
	WebElement reg;
	
	@FindBy(xpath="//div[@class='input-group']/child::input")
	WebElement search;
	
	@FindBy(xpath="//span[@class='input-group-btn']/child::button")
	WebElement searchButton;
	
	public void clickMyAccountonHomePage()
	{
		myacc.click();
	}
	public LoginPage clickLoginonHomePage()
	{
		lgn.click();
		return new LoginPage(ldriver);
	}
	public RegistrationPage clickRegisteronHomePage()
	{
		reg.click();
		return new RegistrationPage(ldriver);
	}
	public void searchProduct(String searchproduct)
	{
		search.sendKeys(searchproduct);
	}
	public SearchPage clickSearchButton()
	{
		searchButton.click();
		return new SearchPage(ldriver);
	}

}
