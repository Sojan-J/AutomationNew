package com.naveenAutomationLab.naveenAutomationLabFrameWork.Listners;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportListner extends TestListenerAdapter{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	  @Override
	  //configure the extentReport
	  public void onStart(ITestContext testContext) {
		//generate timeStamp
		   String timeStamp= new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
		   // file name
		   String reportName="Report"+timeStamp+".html";
		   //save the file
		   htmlReporter=new ExtentHtmlReporter("./Reports/"+reportName);
		   //loaded the configuration file
		   htmlReporter.loadXMLConfig("./extent-config.xml");
		   extent=new ExtentReports();
		   extent.attachReporter(htmlReporter);
		   extent.setSystemInfo("Name of Tester", "sojan");
		   extent.setSystemInfo("Env","QA");
		   extent.setSystemInfo("Website","https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		   
	  }
	
	@Override
	  public void onTestSuccess(ITestResult tr) {
		test=extent.createTest(tr.getMethod().getMethodName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
	  }

	  @Override
	  public void onTestFailure(ITestResult tr) {
		  test=extent.createTest(tr.getMethod().getMethodName());
			test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	    
	  }

	  @Override
	  public void onTestSkipped(ITestResult tr) {
		  test=extent.createTest(tr.getMethod().getMethodName());
			test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	  
	  }
	

	  @Override
	  public void onFinish(ITestContext testContext) {
		  // generate the report
		  extent.flush();
	  }


}
