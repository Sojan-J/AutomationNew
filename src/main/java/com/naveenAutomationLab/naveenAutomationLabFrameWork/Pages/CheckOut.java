package com.naveenAutomationLab.naveenAutomationLabFrameWork.Pages;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.naveenAutomationLab.naveenAutomationLabFrameWork.base.TestBase;
public class CheckOut extends TestBase {
	public CheckOut() {
		PageFactory.initElements(wd, this);
	}

	// ***login to check out*****
	@FindBy(id = "input-email")
	private WebElement inputEmailTxt;
	@FindBy(id = "input-password")
	private WebElement inpuPasswordTxt;
	@FindBy(id = "button-login")
	private WebElement loginBtn;
	// ******Billing details******
	
	 @FindBy(css="#collapse-payment-address>div>form>div:nth-of-type(1)>label>input[type='radio']")
	  private WebElement existingAddressBillingRadioBtn;
	  @FindBy(css=
	  "#collapse-payment-address>div>form>div:nth-of-type(3)>label>input[type='radio']")
	  private WebElement newAddressRadioBtn;
		@FindBy(id = "input-payment-firstname")
		private WebElement firstNameInputText;
		@FindBy(id = "input-payment-lastname")
		private WebElement lastNameInputText;
		@FindBy(id = "input-payment-address-1")
		private WebElement adress1InputText;
		@FindBy(id = "input-payment-city")
		private WebElement cityInputText;
		@FindBy(id = "input-payment-postcode")
		private WebElement postalCodeInputText;
		@FindBy(css = "select#input-payment-country")
		private WebElement selectCountryDropDown;
		@FindBy(css = "select#input-payment-zone")
		WebElement selectProvinceDropDown;
		@FindBy(id = "button-payment-address")
	    private WebElement continueBtn;
	// ****Delivery details*****
	@FindBy(css = "a[href='#collapse-shipping-address']")
	private WebElement deliveryDetailsCollapse;
	@FindBy(css = "#collapse-shipping-address>div>form>div:nth-of-type(1)>label>input[type='radio'] ")
	private WebElement useExistingAddressInDeliveryRadioBtn;
	@FindBy(css = "#collapse-shipping-address>div>form>div:nth-of-type(3)>label>input[type='radio']")
	private WebElement useNewAddressIndeliveryRadioBtn;
	@FindBy(id = "#button-shipping-address")
	private WebElement deliveryDetailsContinuebtn;

	// **Delivery method ******
	@FindBy(css = "a[href='#collapse-shipping-method']")
	private WebElement deliverymethodeCollapse;
	@FindBy(css = "div#collapse-shipping-method>div>p:nth-of-type(4)>textarea")
	private WebElement deliveryMethodCommentTextBox;
	@FindBy(id = "#button-shipping-method")
	private WebElement deliveryMethodContinueBtn;

	// *************payment Method details*********
	@FindBy(css = "a[href=\"#collapse-payment-method\"]")
	private WebElement paymentMethodCollapse;
	@FindBy(css = "div#collapse-payment-method>div>p:nth-of-type(3)>textarea")
	private WebElement cashOnDeliveryCommentTextBox;
	@FindBy(css = "input[name=agree]")
	private WebElement cashOnDeliveryAgreeChck;
	@FindBy(xpath = "//input[@id='button-payment-method']")
	private WebElement chashOnDeliveryContinueBtn;

	// ******confirmation *******
	@FindBy(css = "input#button-confirm")
	private WebElement OrderConfirmationBtn;

	// ******login methods******
	public void loginToCheckOut() {
		inputEmailTxt.sendKeys(testDataProp.getProperty("registeredEmail"));
		inpuPasswordTxt.sendKeys(testDataProp.getProperty("registeredPassword"));
		loginBtn.click();
		
	}

	// ******new Billing Address ******
	public void changeTheBillingAddress() {
		  newAddressRadioBtn.click();
		  firstNameInputText.sendKeys(TestDataProp.getProperty("FirstName"));
		  lastNameInputText.sendKeys(TestDataProp.getProperty("LastName"));
		 adress1InputText.sendKeys(TestDataProp.getProperty("Address"));
		  cityInputText.sendKeys(TestDataProp.getProperty("City"));
		  postalCodeInputText.sendKeys(TestDataProp.getProperty("Postal"));
		  selectFromDropDown(selectCountryDropDown, TestDataProp.getProperty("Country"));
		  selectFromDropDown(selectProvinceDropDown, TestDataProp.getProperty("Province"));
		continueBtn.click();
	}

	public void shippingAddressConfirmation() {
		deliveryDetailsContinuebtn.click();
	}

	public void deliveryMethodConfirmation() {
		deliveryDetailsContinuebtn.sendKeys(TestDataProp.getProperty("DeliveryInstructions"));
		deliveryMethodContinueBtn.click();
	}

	public void cashOnDeliveryConfirmation() {
		cashOnDeliveryAgreeChck.click();
		chashOnDeliveryContinueBtn.click();
	}

	public YourOrderHasBeenPlaced orderConfirmation() {
		chashOnDeliveryContinueBtn.click();
		return new YourOrderHasBeenPlaced();
	}
	
	public void selectFromDropDown(WebElement element, String text) {
		Select sc = new Select(element);
		try {
			sc.selectByVisibleText(text);
		} catch (NoSuchElementException e) {
			sc.selectByValue(text.toLowerCase());
		}
	}
	
}
