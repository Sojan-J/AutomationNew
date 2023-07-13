package com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenAutomationLab.naveenAutomationLabFrameWork.base.TestBase;

public class ShoppingCart extends TestBase {
	WebDriverWait wait;

	public ShoppingCart() {
		PageFactory.initElements(wd, this);
		wait = new WebDriverWait(wd, 20);
	}

	@FindBy(css = "a.btn.btn-primary")
	private WebElement checkOutBtn;

	public CheckOut clickOnCheckOutBtn() {
		wait.until(ExpectedConditions.visibilityOf(checkOutBtn)).click();
		return new CheckOut();
	}

}
