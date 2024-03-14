package com.ecommerceProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver ldriver;
	
	public AccountPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(linkText="Edit your account information")
	WebElement editYourAccountInformationOption;
	
	public boolean getDisplayStatusofEditYourAccountInformationOption()
	{
		boolean displayStatus = editYourAccountInformationOption.isDisplayed();
		return displayStatus;
	}
}
