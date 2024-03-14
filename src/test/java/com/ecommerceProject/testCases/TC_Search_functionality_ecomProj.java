package com.ecommerceProject.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerceProject.pageObjects.HomePage;
import com.ecommerceProject.pageObjects.SearchPage;

public class TC_Search_functionality_ecomProj extends Base{
	
	SearchPage sp;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browserName)
	{
		driver=initializeBrowserAndOpenApplicationURL(browserName);
	}
	
	@Test(priority=1)
	public void searchWithExistingName()
	{
		HomePage hp = new HomePage(driver);
		hp.searchProduct(propData.getProperty("validProduct"));
		sp = hp.clickSearchButton();
		
		Assert.assertTrue(sp.displayStatusofValidiMacProduct());
	}
	
	@Test(priority=2)
	public void searchWithNonExistingName()
	{
		HomePage hp = new HomePage(driver);
		hp.searchProduct(propData.getProperty("invalidProduct"));
		sp=hp.clickSearchButton();
		Assert.assertTrue(driver.getPageSource().contains(propData.getProperty("noProductFoundWarning")));
	}
	
	@Test(priority=3)
	public void searchWithoutName()
	{
		HomePage hp = new HomePage(driver);
		hp.clickSearchButton();
		
		Assert.assertTrue(driver.getPageSource().contains(propData.getProperty("noProductFoundWarning")));
	}
	
	@Test(priority=4)
	public void searchWithCategory() throws InterruptedException
	{
		HomePage hp = new HomePage(driver);
		sp=hp.clickSearchButton();
		sp.searchProduct(propData.getProperty("validProduct"));
		sp.selectCategory(propData.getProperty("validCategory"));
		Thread.sleep(3000);
		sp.clickOnSearchButton();
		
		Assert.assertTrue(sp.displayStatusofValidiMacProduct());
	}
}
