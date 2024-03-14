package com.ecommerceProject.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;

import com.ecommerceProject.Utilities.ReadConfig;
import com.ecommerceProject.Utils.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	ReadConfig read = new ReadConfig();
	
	public String baseURL = read.getURL();
	public String validEmail = read.getvalidEmail();
	public String validPassword = read.getPassword();
	
	public WebDriver driver;
	//public static Logger logger;
	public Properties propData;
	
	public Base()
	{
		propData = new Properties(); 
		File tdf = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ecommerceProject\\testdata\\testdata.properties");
		//
		try 
		{
			FileInputStream fis1 = new FileInputStream(tdf);
			propData.load(fis1);
		}
		catch(Exception x)
		{
			x.printStackTrace();
		}
	}
	//setup
	//@BeforeMethod
	//BasicConfigurator.configure();
    //PropertyConfigurator.configure("./src/main/resources/log4j2.properties");
	
	@Parameters("browser")
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName)
	{
		
		switch(browserName.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			
		default:
			try
			{
				driver=null;
			}
			catch (NullPointerException e)
			{
				System.out.println(e.getMessage());
			}
			break;
			}
		
		//logger = LogManager.getLogger("ecommerceProject");
		
		driver.manage().window().maximize();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		return driver;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	public static String captureScreenshot(WebDriver driver, String testName)
	{
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		try {
			FileHandler.copy(srcScreenshot, new File(destinationPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationPath;
		}
}
