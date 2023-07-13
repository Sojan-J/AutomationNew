package com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenAutomationLab.naveenAutomationLabFrameWork.base.TestBase;

public class MyAccountPage extends TestBase {
	WebDriverWait wait;
	public MyAccountPage() {
		PageFactory.initElements(wd, this);
		wait=new WebDriverWait(wd, 10);
	}
	@FindBy(css = "ul.nav.navbar-nav>li:nth-of-Type(6)")
	private WebElement phonePDAsBtn;
	@FindBy(css="#content h2:nth-child(1)")
	private WebElement accountLoginConfirmation;
	public PhonesAndPdas clickOnPhonesAndPdasBtn() {
		phonePDAsBtn.click();
		return new PhonesAndPdas();
	}
	public String getAccountConfirmText() {
		return  accountLoginConfirmation.getText();	
	}

}
