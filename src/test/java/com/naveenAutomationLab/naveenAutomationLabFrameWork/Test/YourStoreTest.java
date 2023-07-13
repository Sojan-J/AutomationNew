package com.naveenAutomationLab.naveenAutomationLabFrameWork.Test;

import org.testng.Assert;
//import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages.YourStore;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.base.TestBase;

public class YourStoreTest extends TestBase {
	
	YourStore yourStore;
	@BeforeMethod
	public void setup() {
		intialisation();
		yourStore=new YourStore();
	}
	@AfterMethod
	public void tearDown() {
		wd.quit();
	}

	@Test
	public void validateCorrespondingSearchItemIsDisplayed() {
		yourStore.enterSearchItem(testDataProp.getProperty("SearchItem"));
		yourStore.clickOnSearchBtn();
		Assert.assertTrue(yourStore.isItemDisplayed(testDataProp.getProperty("SearchItem")),
				"Corresponding item is not displayed");
	}
	@Test
	public void validateCartIsUpdatedWhenNewItemAdded() {
		yourStore.enterSearchItem(testDataProp.getProperty("SearchItem"));
		yourStore.clickOnSearchBtn();
		
		Assert.assertTrue(yourStore.hasNewItemAddedToCart(), "cart not updated");
	}
	@Test()
	public void validateIfWishListUpdatedWhenItemAdded() {
		yourStore.enterSearchItem(testDataProp.getProperty("SearchItem"));
		yourStore.clickOnSearchBtn();
		Assert.assertTrue(yourStore.hasNewItemAddedToWishList(), "Wish list didn't get updated");
	}
	@Test(enabled=false)
	public void verifyIfiPhoneImageDisplayedWhenClickOnSlideBulletBtn() {
		yourStore.clickOniPhoneSlideBulletBtn();
		Assert.assertTrue(yourStore.hasiphoneImageDisplayed(), "iphone image not dispalyed in the slide");
	}
	@Test(enabled =false)
	public void varifyIfMacbookImageDisplayedWhenClickOnSlideBulletbtn() {
		yourStore.clickOnMacbookSlideBulletbtn();
		Assert.assertTrue(yourStore.hasMacBookImageDisplayed(), "Macbook image not displayed");
	}
	
	@Test(enabled=false)
	public void verifyIfAllLinksPresentUnderInformation() {
		Assert.assertTrue(
				yourStore.haveAllLinksPresentUnderInformation(
						Integer.parseInt(TestDataProp.getProperty("numberOfLinksUnderInformation"))),
				"All links are not present");
	}
}
