package com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.naveenAutomationLab.naveenAutomationLabFrameWork.Utils.Utils;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.base.TestBase;

public class YourStore extends TestBase {
	WebDriverWait wait;

	public YourStore() {
		PageFactory.initElements(wd, this);
		wait= new WebDriverWait(wd, 10);
	}
   @FindBy(css="ul.list-inline>li:nth-of-type(2)")
   private WebElement MyAccountBtn;
   @FindBy(css="li.dropdown.open>ul>li:nth-of-type(2)")
   private WebElement loginBtn;
	@FindBy(css = "ul.nav.navbar-nav>li:nth-of-Type(6)")
	private WebElement phonePDAsBtn;
	@FindBy(css="#search > input")
	private WebElement searchInputText;
	@FindBy(css="span.input-group-btn>button.btn.btn-default.btn-lg")
	private WebElement searchBtn;
	@FindBy(css="div.caption>h4>a")
	private WebElement itemNameCaption;
	@FindBy(css="#cart-total")
	WebElement cartTotal;
	@FindBy(css="div.button-group > button:nth-of-type(1)")
	WebElement addToCartBtn;
	@FindBy(css="div.button-group>button:nth-of-type(2)")
	WebElement wishBtn;
	@FindBy(css="ul.list-inline>li:nth-of-type(3)>a>span")
	WebElement wishListBtn;
	@FindBy(css="div.swiper-pagination.slideshow0.swiper-pagination-clickable>span:nth-of-type(1)")
	WebElement iPhoneSlideBulletBtn;
	@FindBy(css="div.swiper-pagination.slideshow0.swiper-pagination-clickable>span:nth-of-type(2)")
	WebElement macBookSlideBulletBtn;
	@FindBy(css="div#slideshow0>div>div:nth-of-type(2)>a>img")
	WebElement iphoneImageSlide;
	@FindBy(css="div#slideshow0>div>div:nth-of-type(3)>img")
	WebElement macBookImageSlide;
	//@FindAllBy(css="div.row>div:nth-of-type(1)>ul>li>a")
	List<WebElement> informationLinks=wd.findElements(By.cssSelector("div.row>div:nth-of-type(1)>ul>li>a"));
	
	public void clickOnMyAccountBtn() {
		MyAccountBtn.click();
	}
public LoginPage ClickOnLoginBtn() {
	wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
	return new LoginPage();
}

	public PhonesAndPdas clickOnPhonesAndPdasBtn() {
		phonePDAsBtn.click();
		return new PhonesAndPdas();
	}
	public void  clickOnSearchBtn() {
	searchBtn.click();	
	}
	public void enterSearchItem(String itemName) {
		searchInputText.sendKeys(itemName);	
			}
	public boolean isItemDisplayed(String itemName) {
		if(itemNameCaption.getText().equalsIgnoreCase(itemName)) {
			return true;
		}return false;	
	}
	public boolean hasNewItemAddedToCart() {
		int currentCart= Integer.parseInt(Character.toString(cartTotal.getText().charAt(0)));
		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		int updatedCart=Integer.parseInt(Character.toString(cartTotal.getText().charAt(0)));
		if(updatedCart>currentCart) {
			return true;
		}return false;
	}
	
	public boolean hasNewItemAddedToWishList() {
		int currentWishlist=Utils.returnNumericValueFromString(wishListBtn.getText());
		wait.until(ExpectedConditions.visibilityOf(wishBtn)).click();;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}
		int updatedWishList=Utils.returnNumericValueFromString(wishListBtn.getText());
		if(updatedWishList>currentWishlist) {
			return true;
		}return false;
	}

	public void clickOniPhoneSlideBulletBtn() {
		iPhoneSlideBulletBtn.click();
	}

	public boolean hasiphoneImageDisplayed() {
		if (wait.until(ExpectedConditions.visibilityOf(iphoneImageSlide)).isDisplayed()) {
			return true;
		}
		return false;
	}
	public void clickOnMacbookSlideBulletbtn() {
		macBookSlideBulletBtn.click();
	}
	public boolean hasMacBookImageDisplayed() {
		if(wait.until(ExpectedConditions.visibilityOf(macBookImageSlide)).isDisplayed()) {
			return true;
		}return false;
	}
	public boolean haveAllLinksPresentUnderInformation(int numberOfLinks) {
		if(informationLinks.size()==numberOfLinks) {
			return true;
		}return false;
	}
	
}
