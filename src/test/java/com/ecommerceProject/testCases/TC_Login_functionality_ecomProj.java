package com.ecommerceProject.testCases;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerceProject.Utils.Utilities;
import com.ecommerceProject.pageObjects.AccountPage;
import com.ecommerceProject.pageObjects.HomePage;
import com.ecommerceProject.pageObjects.LoginPage;

public class TC_Login_functionality_ecomProj extends Base{
	
	LoginPage lp;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browserName)
	{
		driver=initializeBrowserAndOpenApplicationURL(browserName);
		HomePage hp = new HomePage(driver);
		hp.clickMyAccountonHomePage();
		lp = hp.clickLoginonHomePage();
	}
	
	@Test(priority=2,dataProvider="validCredentialsSupplier")
	public void loginWithValidCredentials (String email, String password) throws InterruptedException
	{
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		
		AccountPage ap = new AccountPage(driver);
		boolean result= ap.getDisplayStatusofEditYourAccountInformationOption();
		if(result==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData()
	{
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
		
	}
	
	
	@Test(priority=1)
	public void loginWithInvalidCredentials()
	{
		lp.setEmail(Utilities.generateEmail());
		lp.setPassword(propData.getProperty("InvalidPassword"));
		lp.clickLogin();
		
		String actualWarningMessage = lp.retrieveCredentialsMismatchWarning();
		String expectedWarningMessage = propData.getProperty("CredentialMismatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning is not displayed");
	}
	
	@Test(priority=3)
	public void browseBackAfterLogin()
	{
		lp.setEmail(validEmail);
		lp.setPassword(validPassword);
		lp.clickLogin();
		
		driver.navigate().back();
		
		boolean result = lp.returningCustomerDisplayed();
		if(result==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
}
