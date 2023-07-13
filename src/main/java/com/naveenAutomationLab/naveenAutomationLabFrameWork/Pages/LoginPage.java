package com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenAutomationLab.naveenAutomationLabFrameWork.base.TestBase;

public class LoginPage extends TestBase{
	WebDriverWait wait;
	 public LoginPage() {
		 PageFactory.initElements(wd, this);
	 }
	 @FindBy(id="input-email")
	 private WebElement emailTextInput;
	 @FindBy(id="input-password")
	 private WebElement passwordTextInput;
	 @FindBy(css="input[value='Login']")
	 private WebElement loginBtn;
	 
	 
	 public MyAccountPage loginWithValidCredentials(String registeredEmail,String registeredPassword) throws InterruptedException {
		 emailTextInput.sendKeys(registeredEmail);
		 passwordTextInput.sendKeys(registeredPassword);
		 Thread.sleep(5000);
		 loginBtn.submit();
		 return new MyAccountPage();
	 }



}
