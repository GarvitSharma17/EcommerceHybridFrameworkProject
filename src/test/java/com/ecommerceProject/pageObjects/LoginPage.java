package com.ecommerceProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage() {
		super();
	}
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-password")
	WebElement pwd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement lgn_btn;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	WebElement credentialsMismatchWarning;
	
	@FindBy(xpath="//div[@class='well']/child::h2[contains(text(),'Returning Customer')]")
	WebElement returning_customer;
	
	public void setEmail(String eml)
	{
		email.sendKeys(eml);
	}
	
	public void setPassword(String pass)
	{
		pwd.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		lgn_btn.click();
	}
	
	public String retrieveCredentialsMismatchWarning()
	{
		String credMismatchWarning = credentialsMismatchWarning.getText();
		return credMismatchWarning;
	}
	
	public boolean returningCustomerDisplayed()
	{
		boolean returningCustomer = returning_customer.isDisplayed();
		return returningCustomer;
	}
}
