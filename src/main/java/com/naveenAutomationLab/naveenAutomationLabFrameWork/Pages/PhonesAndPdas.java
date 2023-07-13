package com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenAutomationLab.naveenAutomationLabFrameWork.base.TestBase;

public class PhonesAndPdas extends TestBase {
	WebDriverWait wait;

	public PhonesAndPdas() {
		PageFactory.initElements(wd, this);
		wait = new WebDriverWait(wd, 10);
	}

	@FindBy(css = "div:nth-of-type(3) > div > div:nth-of-type(2) > div.button-group > button:nth-of-type(1)")
	private WebElement palmTreoTroAddToCartBtn;
	@FindBy(css = "div.alert.alert-success.alert-dismissible")
	private WebElement addToCartSuccessMessage;
	@FindBy(css = "div.alert.alert-success.alert-dismissible>a:nth-of-type(2)")
	private WebElement shoppingCartBtn;
	List<WebElement> wishBtns = wd.findElements(By.cssSelector("div.button-group>button:nth-of-type(2)"));
	@FindBy(css = "ul.list-inline>li:nth-of-type(3)")
	private WebElement wishList;
	
	public void clickOnAddToCart() {
		palmTreoTroAddToCartBtn.click();
	}

	public boolean isSuccessMessageIsDisplayedWhenItemAdd() {
		String successMessage = addToCartSuccessMessage.getText();
		if (successMessage.contains("Success:")) {	return true;
		}else
		return false;
	}

	public ShoppingCart clickOnShopingCartBtn() {
		wait.until(ExpectedConditions.visibilityOf(shoppingCartBtn)).click();
		return new ShoppingCart();
	}

	public void addAllItemToWishList() {
		if (wishBtns != null) {
			for (WebElement wishBtn : wishBtns) {
				wishBtn.click();
			}
		} else
			throw new NoSuchElementException();
	}
	public MyWishList clickOnWishList() {
		wait.until(ExpectedConditions.elementToBeClickable(wishList)).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new MyWishList();
	}

}
