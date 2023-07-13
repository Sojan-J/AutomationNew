package com.naveenAutomationLab.naveenAutomationLabFrameWork.Listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.naveenAutomationLab.naveenAutomationLabFrameWork.Utils.Utils;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.base.TestBase;

public class CustomListners extends TestBase implements ITestListener{
	
	 public void onTestStart(ITestResult result) {
		 logger.info("test started for :"+result.getMethod().getMethodName());
		 
	 }

	 
	  public void onTestSuccess(ITestResult result) {
		  logger.info("Test "+result.getMethod().getMethodName());
		  
	  }

	  
	  public void onTestFailure(ITestResult result) {
		 Utils.takeScreenShots(result.getMethod().getMethodName());
		  
	  }

	 
	  public void onTestSkipped(ITestResult result) {
		  logger.info("Test "+result.getMethod().getMethodName());
		  
	  }
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		  logger.info("Test "+result.getMethod().getMethodName());
		  
	  }


	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
