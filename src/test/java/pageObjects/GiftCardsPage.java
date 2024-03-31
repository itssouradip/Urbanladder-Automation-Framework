package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import testBase.BasePage;

public class GiftCardsPage extends BasePage {
	
	public GiftCardsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[text() = 'Gift Cards']") WebElement buttonGiftCards;
	@FindBy(xpath = "//ul[@class='_2sedU']/li[3]/img") WebElement imgBirthday;
	@FindBy(xpath = "//div[@class = '_3jn98 _23tqD _3k9Vm']/button[1]") WebElement buttonPrice1;
	@FindBy(xpath = "//div[@class = '_3jn98 _23tqD _3k9Vm']/button[2]") WebElement buttonPrice2;
	@FindBy(xpath = "//div[@class = '_3jn98 _23tqD _3k9Vm']/button[3]") WebElement buttonPrice3;
	@FindBy(xpath = "//input[@id = 'ip_2251506436']") WebElement textboxPrice;
	@FindBy(xpath = "//select[@class = 'Upz18 _1hLiD UJU2v'][1]") WebElement selectMonth;
	@FindBy(xpath = "//select[@class = 'Upz18 _1hLiD UJU2v'][2]") WebElement selectDate;
	@FindBy(xpath = "//button[@class = '_1IFIb _1fVSi action-button _1gIUf _1XfDi']") WebElement buttonNext;
	
	@FindBy(xpath = "//input[@name = 'recipient_name']") WebElement txtReceiptName;
	@FindBy(xpath="//input[@name = 'recipient_email']") WebElement txtReceiptEmail;
	@FindBy(xpath="//input[@name = 'recipient_mobile_number']") WebElement txtMobileNumber;
	
	@FindBy(xpath="//input[@name = 'customer_name']") WebElement txtSenderName;
	@FindBy(xpath="//input[@name = 'customer_email']") WebElement txtSenderEmail;
	@FindBy(xpath="//input[@name = 'customer_mobile_number']") WebElement txtSenderMobile;
	@FindBy(xpath="//input[@name = 'customer_address']") WebElement txtSenderAddress;
	@FindBy(xpath="//input[@name = 'zip']") WebElement txtSenderZipCode;
	@FindBy(xpath="//input[@name = 'city']") WebElement txtSenderCity;
	
	@FindBy(xpath="//button[text()='Confirm']") WebElement buttonConfirm;
	@FindBy(xpath = "//div[@id='topnav_wrapper']") WebElement navbar;
		
	public void hoverOverNavBar() {
		Actions action = new Actions(driver);
		action.moveToElement(navbar);
	}
	
	public boolean isGiftCardsButtonVisible() {
		boolean status = buttonGiftCards.isDisplayed();
		return status;
	}
	
	public void clickGiftCardsButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", buttonGiftCards);
//		buttonGiftCards.click();
	}
		
	public void scrollToBirthdayOrAnniversaryOptions() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", imgBirthday);
	}
	
	public boolean isBirthdayOrAnniversaryOptionsDisplayed() {
		boolean status = imgBirthday.isDisplayed();
		return status;
	}
	
	public void chooseBirthdayOrAnniversaryOption() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", imgBirthday);
	}
	
	public void selectGiftCardPrice() {
		buttonPrice2.click();
	}
	
	public void selectMonth() {
		Select select = new Select(selectMonth);
		select.selectByIndex(2);
	}
	
	public void selectDate() {
		Select select = new Select(selectDate);
		select.selectByIndex(3);
	}
	
	public void clickNext() {
		buttonNext.click();
	}
	
	public void fillRecipientsName(String recipientName) {
		txtReceiptName.sendKeys(recipientName);
	}
	
	public void fillRecipientEmail(String recipientEmail) {
		txtReceiptEmail.sendKeys(recipientEmail);
	}
	
	public void fillRecipientMobile(String mobileNumber) {
		txtMobileNumber.sendKeys(mobileNumber);
	}
	
	public void fillSendersName(String senderName) {
		txtSenderName.sendKeys(senderName);
	}
	
	public void fillSendersEmail(String senderEmail) {
		txtSenderEmail.sendKeys(senderEmail);
	}
	
	public void fillSendersMobile(String senderMobileNumber) {
		txtSenderMobile.sendKeys(senderMobileNumber);
	}
	
	public void fillSendersAddress(String senderAddress) {
		txtSenderAddress.sendKeys(senderAddress);
	}
	
	public void fillSenderPin(String pincode) {
		txtSenderZipCode.sendKeys(pincode);
	}
	
	public void clickConfirmButton() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", buttonConfirm);
	}
	
	public String getErrorMessageWithoutNameInput() {
		String errorMessage;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		errorMessage = (String) js.executeScript("return arguments[0].validationMessage;", txtSenderName);
		return errorMessage;
	}
	public String getErrorMessageWithoutEmailInput() {
		String errorMessage;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		errorMessage = (String) js.executeScript("return arguments[0].validationMessage;", txtSenderEmail);
		return errorMessage;
	}
	public String getErrorMessageWithoutMobileNumberInput() {
		String errorMessage;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		errorMessage = (String) js.executeScript("return arguments[0].validationMessage;", txtSenderMobile);
		return errorMessage;
	}
	public String getErrorMessageWithoutAddressInput() {
		String errorMessage;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		errorMessage = (String) js.executeScript("return arguments[0].validationMessage;", txtSenderAddress);
		return errorMessage;
	}
	
	public String getErrorDetailsWithoutNameInput() {
		String errorDetails = txtSenderName.getAttribute("title");
		return errorDetails;
	}
	
	public String getErrorDetailsWithInvalidMobileNumber() {
		String errorDetails = txtSenderMobile.getAttribute("title");
		return errorDetails;
	}
	
	public String getErrorDetailsWithoutAddressInput() {
		String errorDetails = txtSenderAddress.getAttribute("title");
		return errorDetails;
	}
	
	public void clearRecipientDetails() {
		txtReceiptName.clear();
		txtReceiptEmail.clear();
		txtMobileNumber.clear();
	}
	
	public void clearSenderDetails() {
		txtSenderName.clear();
		txtSenderEmail.clear();
		txtSenderMobile.clear();
		txtSenderAddress.clear();
		txtSenderZipCode.clear();
	}
}
