package com.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtils 
{
	public static Properties prop = null;
	public static FileInputStream fis=null;
	
	//reads property file and reurns key value
	//accepts key as parameter
	public static String readProperty(String key)
	{
		try
		{
			prop = new Properties();
			//user.dir gives project path
			fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
			
			prop.load(fis);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
	
	public static void main(String[] args) {
		
		System.out.println(readProperty("browser"));
	}

}
