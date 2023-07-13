package com.naveenAutomationLab.naveenAutomationLabFrameWork.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages.LoginPage;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages.MyAccountPage;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages.YourStore;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.Utils.ExcelUtils;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.base.TestBase;

public class LoginPageTest extends TestBase {
	YourStore yourStore;
	LoginPage loginPage;
	MyAccountPage myAccountPage;

	@BeforeMethod
	public void setup() {
		intialisation();
		yourStore = new YourStore();
	}

	@DataProvider(name = "validLoginCredentials")
	public String[][] verifyLoginFunctionality() throws IOException {
		String filePath = "W:\\QAPivotTrainingMarch2023-Sept2023\\testData.xlsx";
		int rowCount = ExcelUtils.getRowCount(filePath, "Sheet1") - 1;
		int columnCount = ExcelUtils.getCellCount(filePath, "Sheet1", rowCount);
		String[][] virtualSheet = new String[rowCount][columnCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < columnCount; j++) {
				virtualSheet[i - 1][j] = ExcelUtils.getCellValue(filePath, "Sheet1", i, j);
			}
		}
		return virtualSheet;
	}

	@Test(dataProvider = "validLoginCredentials")
	public void validateIfCustomerIsAbleToLoginWithValidCredentilas(String username, String passWord)
			throws IOException, InterruptedException {
		yourStore = new YourStore();
		yourStore.clickOnMyAccountBtn();
		loginPage = yourStore.ClickOnLoginBtn();
		myAccountPage = loginPage.loginWithValidCredentials(username, passWord);
		Assert.assertEquals(myAccountPage.getAccountConfirmText(), "My Account", "could not login");

	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}

}
