package com.ecommerceProject.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerceProject.Utils.Utilities;
import com.ecommerceProject.pageObjects.HomePage;
import com.ecommerceProject.pageObjects.RegistrationPage;

public class TC_Registration_functionality_ecomProj extends Base{
	
	RegistrationPage rp;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browserName)
	{
		driver=initializeBrowserAndOpenApplicationURL(browserName);
		HomePage hp = new HomePage(driver);
		hp.clickMyAccountonHomePage();
	    rp = hp.clickRegisteronHomePage();
	}
	
	@Test(priority=1)
	public void WithMandatoryFields()
	{
		rp.setFirstName(propData.getProperty("firstname"));
		rp.setLastName(propData.getProperty("lastname"));
		rp.setEmail(Utilities.generateEmail());
		rp.setTelephone(Utilities.randomPhnumber());
		rp.setRegPassword("setRegistrationPassword");
		rp.confirmRegPassword("setRegistrationPassword");
		rp.checkboxPrivacy();
		rp.clickContinue();
		
		boolean actual_Success_Message = driver.getPageSource().contains(propData.getProperty("accountSuccessfullyCreatedMessage"));
		if(actual_Success_Message==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority=2)
	public void registerWithAllFields() 
	{
		rp.setFirstName(propData.getProperty("firstname"));
		rp.setLastName(propData.getProperty("lastname"));
		rp.setEmail(Utilities.generateEmail());
		rp.setTelephone(Utilities.randomPhnumber());
		rp.setRegPassword(propData.getProperty("setRegistrationPassword"));
		rp.confirmRegPassword(propData.getProperty("setRegistrationPassword"));
		rp.clickYesDialog();
		rp.checkboxPrivacy();
		rp.clickContinue();
		
		boolean actual_Success_Message = driver.getPageSource().contains(propData.getProperty("accountSuccessfullyCreatedMessage"));
		if(actual_Success_Message==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		}
	
	@Test(priority=3)
	public void registerWithExistingDetails()
	{
		rp.setFirstName(propData.getProperty("firstname"));
		rp.setLastName(propData.getProperty("lastname"));
		rp.setEmail(validEmail);
		rp.setTelephone(Utilities.randomPhnumber());
		rp.setRegPassword(propData.getProperty("setRegistrationPassword"));
		rp.confirmRegPassword(propData.getProperty("setRegistrationPassword"));
		rp.clickYesDialog();
		rp.checkboxPrivacy();
		rp.clickContinue();
		
		Assert.assertTrue(driver.getPageSource().contains(propData.getProperty("duplicateEmailWarning")));
	}
	
	@Test(priority=4)
	public void registerWithoutProvidingDetails()
	{
		rp.clickContinue();
		
		Assert.assertTrue(driver.getPageSource().contains(propData.getProperty("privacyPolicyWarning")));
		Assert.assertTrue(driver.getPageSource().contains(propData.getProperty("firstNameWarning")));
	}
}
