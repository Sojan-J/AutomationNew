 package com.naveenAutomationLab.naveenAutomationLabFrameWork.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.BeforeClass;
import org.testng.internal.Systematiser;

import com.naveenAutomationLab.naveenAutomationLabFrameWork.Listners.WebDriverEvents;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.Utils.Browsers;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.Utils.Enviornment;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver wd;
	private FileInputStream fileInputConfig;
	private FileInputStream fileInputTestData;
	public static Properties TestDataProp;
	public static Properties testDataProp;
	public static Logger logger;
	private WebDriverEvents events;
	private EventFiringWebDriver eDriver;
	//private String browserName = Browsers.CHROME.getNameOfBrowser();//use enum class to get the browse rname

	public TestBase() {
		TestDataProp = new Properties();
		testDataProp = new Properties();
		try {
			fileInputConfig = new FileInputStream(
					"./src\\main\\java\\com\\naveenAutomationLab\\naveenAutomationLabFrameWork\\Config\\config.properties");
			fileInputTestData = new FileInputStream(
					"./src\\main\\java\\com\\naveenAutomationLab\\naveenAutomationLabFrameWork\\Config\\testData.properties");
		} catch (FileNotFoundException e) {
		}
		try {
			TestDataProp.load(fileInputConfig);
			testDataProp.load(fileInputTestData);
		} catch (IOException e) {

		}
	}

	public void intialisation() {
		String browserName1 = System.getProperty("BrowserName") != null ? System.getProperty("BrowserName")
				: Browsers.CHROME.getNameOfBrowser();
		switch (browserName1) {
		case "Chrome":
			wd = WebDriverManager.chromedriver().create();
			break;
		case "Edge":
			wd = WebDriverManager.edgedriver().create();
			break;
		default:
			System.out.println("in valid browser");
			break;
		}

		eDriver = new EventFiringWebDriver(wd);
		events = new WebDriverEvents();
		eDriver.register(events);
		wd = eDriver;

		wd.get(Enviornment.PRODUCTION.getUrl());
		wd.manage().timeouts().implicitlyWait(Long.parseLong(TestDataProp.getProperty("wait")), TimeUnit.SECONDS);
		wd.manage().window().maximize();
	}
@BeforeClass
	public void setupLogger() {
		logger=Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
	}

	public void tearDown() {
		wd.quit();
	}
}
