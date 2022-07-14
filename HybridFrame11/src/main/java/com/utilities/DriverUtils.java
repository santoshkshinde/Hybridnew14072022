package com.utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;

public class DriverUtils extends BaseClass
{
	public static String getScreenshot(String name)
	{
		TakesScreenshot scrnShot= (TakesScreenshot)driver;
		File src= scrnShot.getScreenshotAs(OutputType.FILE);
		String path= System.getProperty("user.dir")+"/screenshots/"+name+".jpg";
		
		File dest= new File(path);
		try
		{
			FileUtils.copyFile(src, dest);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return path;
	}

}
