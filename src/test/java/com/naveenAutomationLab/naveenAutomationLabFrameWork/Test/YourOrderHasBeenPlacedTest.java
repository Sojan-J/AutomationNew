package com.naveenAutomationLab.naveenAutomationLabFrameWork.Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages.CheckOut;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages.PhonesAndPdas;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages.ShoppingCart;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages.YourOrderHasBeenPlaced;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages.YourStore;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.base.TestBase;

public class YourOrderHasBeenPlacedTest extends TestBase {
	YourStore yourStore;
	PhonesAndPdas phoneAndPdas;
	ShoppingCart shoppingCart;
	CheckOut checkOut;
	YourOrderHasBeenPlaced yourOrderHasBeenPlaced;


	@BeforeMethod
	public void setUp() {
		intialisation();
		yourStore = new YourStore();
	}

	@AfterMethod
	public void tearDown() {
		wd.quit();
	}
	@Test
	public void verifyCustomerCanSelectItemAndAddToCart() {
		phoneAndPdas = yourStore.clickOnPhonesAndPdasBtn();
		phoneAndPdas.clickOnAddToCart();
		Assert.assertTrue(phoneAndPdas.isSuccessMessageIsDisplayedWhenItemAdd(), "product did not add to the cart");
	}

	@Test(enabled=false)
	public void verifyCustomerCanAddItemToShoppingCartAndCheckOut() {
		phoneAndPdas = yourStore.clickOnPhonesAndPdasBtn();
		phoneAndPdas.clickOnAddToCart();
		shoppingCart = phoneAndPdas.clickOnShopingCartBtn();
		checkOut = shoppingCart.clickOnCheckOutBtn();
		checkOut.loginToCheckOut();
		checkOut.changeTheBillingAddress();
		checkOut.shippingAddressConfirmation();
		checkOut.deliveryMethodConfirmation();
		checkOut.cashOnDeliveryConfirmation();
		yourOrderHasBeenPlaced = checkOut.orderConfirmation();
		Assert.assertEquals(yourOrderHasBeenPlaced.getOrderConfirmationMessage(), TestDataProp.getProperty("OrderConfirmationText"));

	}

}
