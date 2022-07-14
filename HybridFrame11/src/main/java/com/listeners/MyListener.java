package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.utilities.DriverUtils;

public class MyListener extends BaseClass implements ITestListener
{

	public void onTestStart(ITestResult result) 
	{
		
		//create report when test starts
		test=report.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) 
	{
		//when test succedes save status and name of result
		test.log(Status.PASS, "test case passed with name as"+result.getName());
		
	}

	public void onTestFailure(ITestResult result) 
	{
		
		test.log(Status.FAIL, "test case failed with name as"+result.getName());
		// result name to get screen shot method it will return path
		String path=DriverUtils.getScreenshot(result.getName());
		//add screen shot to above path
		test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) 
	{
		
		test.log(Status.SKIP, "testcase skipped with name as "+result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
		
	}

	public void onStart(ITestContext context) 
	{
		
		
	}

	public void onFinish(ITestContext context) 
	{
		
		
	}

}
