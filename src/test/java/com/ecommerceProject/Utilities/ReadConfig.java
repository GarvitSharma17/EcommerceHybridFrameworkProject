package com.ecommerceProject.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	public Properties pro;
	
	public ReadConfig()
	{
		pro = new Properties();
		File src = new File("./Configuration/config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String getURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getvalidEmail()
	{
		String email = pro.getProperty("validEmail");
		return email;
	}
	
	public String getPassword()
	{
		String pass = pro.getProperty("validPassword");
		return pass;
	}
	
	public String getBrowser()
	{
		String brow = pro.getProperty("browserName");
		return brow;
	}
}
