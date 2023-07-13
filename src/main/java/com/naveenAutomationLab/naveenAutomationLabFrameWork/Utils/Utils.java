package com.naveenAutomationLab.naveenAutomationLabFrameWork.Utils;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.naveenAutomationLab.naveenAutomationLabFrameWork.base.TestBase;

public class Utils extends TestBase{
	
	public static void takeScreenShots(String testName) {
		// String timeStamp=new SimpleDateFormat("dd/MM/yyy HH:mm:ss").format(new
		// Date());
		// Time Stamp
		Calendar c = Calendar.getInstance();
		String timeStamp = c.getTime().toString().replace(" ", "").replace(":", "");
		// take screen shots
		File screenshotFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile,
					new File("./FailedTestsScreenShots/" + timeStamp + "_" + testName + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static int returnNumericValueFromString(String str) {
		String num = "";
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				num += str.charAt(i);
			}
		}

		return Integer.parseInt(num);
	}

}
