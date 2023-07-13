package com.naveenAutomationLab.naveenAutomationLabFrameWork.Test;

import java.awt.AWTException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages.LoginPage;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages.MyAccountPage;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages.MyWishList;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages.MyWishList.myWishListTableHead;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages.PhonesAndPdas;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages.YourStore;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.base.TestBase;

public class MyWishListTest extends TestBase {
	YourStore yourStore;
	LoginPage loginPage;
	PhonesAndPdas phoneAndPdas;
	MyWishList myWishList;
	MyAccountPage myAccountPage;

	@BeforeMethod
	public void setUp() {
		intialisation();
		yourStore = new YourStore();
	}

	@AfterMethod
	public void tearDown() {
		wd.close();
	}

	@Test
	public void validateWishListTable() throws InterruptedException, AWTException {
		yourStore.clickOnMyAccountBtn();
		loginPage = yourStore.ClickOnLoginBtn();
		myAccountPage = loginPage.loginWithValidCredentials(testDataProp.getProperty("registeredEmail"),
				testDataProp.getProperty("registeredPassword"));
		phoneAndPdas = myAccountPage.clickOnPhonesAndPdasBtn();
		phoneAndPdas.addAllItemToWishList();
		myWishList = phoneAndPdas.clickOnWishList();
		WebElement element = myWishList.getCellElementFromTable(testDataProp.getProperty("modelName"),
				myWishListTableHead.UNIT_PRICE);
		Assert.assertEquals(element.getText(), testDataProp.getProperty("productPrice"));

	}
}
