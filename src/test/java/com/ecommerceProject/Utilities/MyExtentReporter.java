package com.ecommerceProject.Utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyExtentReporter {
	
	public static ExtentReports generateExtentReport()
	{
		ExtentReports extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialsNinja Test Automation Results Report");
		sparkReporter.config().setDocumentTitle("TN Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/YYYY hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		
		ReadConfig read = new ReadConfig();
		
		extentReport.setSystemInfo("Application URL", read.getURL());
		extentReport.setSystemInfo("Browser Name", read.getBrowser());
		extentReport.setSystemInfo("Email", read.getvalidEmail());
		extentReport.setSystemInfo("Password", read.getPassword());
		extentReport.setSystemInfo("Environment", "QA");
		extentReport.setSystemInfo("User", "Garvit");
		
		return extentReport;
		
	}

}
