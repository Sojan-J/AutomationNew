package com.naveenAutomationLab.naveenAutomationLabFrameWork.Listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.naveenAutomationLab.naveenAutomationLabFrameWork.base.TestBase;

public class RetryFailedTests extends TestBase implements IRetryAnalyzer {
int maxCount=2;
int count =1;

@Override
public boolean retry(ITestResult result) {
	logger.info("Retrying !!!!!!! "+result.getMethod().getMethodName()+"for "+count +" tmes");
	if (count < maxCount) {
		count++;
		return true;
	}
	return false;

}

}
