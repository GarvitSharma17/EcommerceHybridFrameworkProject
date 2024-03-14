package com.ecommerceProject.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	public RegistrationPage() {
		super();
	}
	
	WebDriver ldriver;
	
	public RegistrationPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(id="input-firstname")
	WebElement first_name;
	
	@FindBy(id="input-lastname")
	WebElement last_name;
	
	@FindBy(id="input-email")
	WebElement reg_email;
	
	@FindBy(id="input-telephone")
	WebElement teleph;
	
	@FindBy(id="input-password")
	WebElement pwd_reg;
	
	@FindBy(id="input-confirm")
	WebElement conf_pwd_reg;
	
	@FindBy(xpath="//label[@class='radio-inline']/child::input[@value=1]")
	WebElement dialog_yes;
	
	@FindBy(xpath="//label[@class='radio-inline']/child::input[@value=0]")
	WebElement dialog_no;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement check_privacy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement ctnu;
	
	public void setFirstName(String fname)
	{
		first_name.sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		last_name.sendKeys(lname);
	}
	public void setEmail(String eml)
	{
		reg_email.sendKeys(eml);
	}
	public void setTelephone(String tele)
	{
		teleph.sendKeys(tele);
	}
	public void setRegPassword(String rgpwd)
	{
		pwd_reg.sendKeys(rgpwd);
	}
	public void confirmRegPassword(String rgpwd)
	{
		conf_pwd_reg.sendKeys(rgpwd);
	}
	public void clickYesDialog()
	{
		dialog_yes.click();
	}
	public void clickNoDialog()
	{
		dialog_no.click();
	}
	public void checkboxPrivacy()
	{
		check_privacy.click();
	}
	public void clickContinue()
	{
		ctnu.click();
	}
}
