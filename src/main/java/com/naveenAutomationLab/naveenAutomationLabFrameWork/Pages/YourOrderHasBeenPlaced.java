package com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenAutomationLab.naveenAutomationLabFrameWork.base.TestBase;

public class YourOrderHasBeenPlaced extends TestBase {

	public YourOrderHasBeenPlaced() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "div#content>h1")
	private WebElement orderConfirmationText;

	public String getOrderConfirmationMessage() {
		return orderConfirmationText.getText();
	}
}
