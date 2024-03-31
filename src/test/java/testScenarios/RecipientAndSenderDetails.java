package testScenarios;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.GiftCardsPage;
import testBase.BaseClass;
import utilities.PropertyReader;
import utilities.RandomInputGenerator;

public class RecipientAndSenderDetails extends BaseClass {
	
	PropertyReader propertyReader = new PropertyReader();
	
	@Test(priority = 0,groups= {"Regression Test","Master"})
	public void enterRecipientDetails() {
		logger = LogManager.getLogger(this.getClass());
		logger.info("*** Starting of RecipientAndSenderDetails ***");
		try {
			giftCards = new GiftCardsPage(driver);
			random = new RandomInputGenerator();
			
			giftCards.fillRecipientsName(random.randomString(5, 12));
			giftCards.fillRecipientEmail(random.randomEmail(5, 12));
			giftCards.fillRecipientMobile(random.randomMobileNumber(9));
			logger.info(" Setting Recipient details through random funcion ");
		}
		catch(Exception e) {
			logger.info(" Setting Recipient details through random funcion got failed");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 1,groups= {"Regression Test","Master"})
	public void validateErrorMessageWithoutNameInSenderDetails() {
		try {
			giftCards = new GiftCardsPage(driver);
			System.out.println("Checking the Validity of the form without providing Sender's Name:");
			giftCards.fillSendersEmail(random.randomEmail(5, 12));
			giftCards.fillSendersMobile(random.randomMobileNumber(9));
			propertyReader.propertyReader();
			giftCards.fillSendersAddress(propertyReader.readProperty("address"));
			giftCards.fillSenderPin(propertyReader.readProperty("pincode"));
			giftCards.clickConfirmButton();
			String errorMessage = giftCards.getErrorMessageWithoutNameInput();
			String errorDetails = giftCards.getErrorDetailsWithoutNameInput();
			System.out.println(errorMessage + "\n" + errorDetails + "\n");
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 2,groups= {"Regression Test","Master"})
	public void validateErrorMessageWithoutEmailInSenderDetails() {
		try {
			giftCards = new GiftCardsPage(driver);
			giftCards.clearSenderDetails();
			System.out.println("Checking the Validity of the form without providing Sender's Email:");
			giftCards.fillSendersName(random.randomString(5, 12));
			giftCards.fillSendersMobile(random.randomMobileNumber(9));
			propertyReader.propertyReader();
			giftCards.fillSendersAddress(propertyReader.readProperty("address"));
			giftCards.clickConfirmButton();
			String errorMessage = giftCards.getErrorMessageWithoutEmailInput();
			System.out.println(errorMessage + "\n");
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 3,groups= {"Regression Test","Master"})
	public void validateErrorMessageWithInvalidEmailInSenderDetails() {
		try {
			giftCards = new GiftCardsPage(driver);
			giftCards.clearSenderDetails();
			System.out.println("Checking the Validity of the form with providing invalid Sender's Email:");
			giftCards.fillSendersName(random.randomString(5, 12));
			giftCards.fillSendersEmail(random.randomEmail(0,0));
			giftCards.fillSendersMobile(random.randomMobileNumber(9));
			propertyReader.propertyReader();
			giftCards.fillSendersAddress(propertyReader.readProperty("address"));
			giftCards.clickConfirmButton();
			String errorMessage = giftCards.getErrorMessageWithoutEmailInput();
			System.out.println(errorMessage + "\n");
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 4,groups= {"Regression Test","Master"})
	public void validateErrorMessageWithoutMobileNumberInSenderDetails() {
		logger.info(" Sending invalid Sender details through random funcion in different combination ");
		try {
			giftCards = new GiftCardsPage(driver);
			giftCards.clearSenderDetails();
			System.out.println("Checking the Validity of the form without providing Sender's Mobile Number:");
			giftCards.fillSendersName(random.randomString(5, 12));
			giftCards.fillSendersEmail(random.randomEmail(5, 12));
			propertyReader.propertyReader();
			giftCards.fillSendersAddress(propertyReader.readProperty("address"));
			giftCards.clickConfirmButton();
			String errorMessage = giftCards.getErrorMessageWithoutMobileNumberInput();
			String errorDetails = giftCards.getErrorDetailsWithInvalidMobileNumber();
			System.out.println(errorMessage + "\n" + errorDetails + "\n");
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 5,groups= {"Regression Test","Master"})
	public void validateErrorMessageWithInvalidMobileNumberInSenderDetails() {
		try {
			giftCards = new GiftCardsPage(driver);
			giftCards.clearSenderDetails();
			System.out.println("Checking the Validity of the form with providing invalid Sender's Mobile Number:");
			giftCards.fillSendersName(random.randomString(5, 12));
			giftCards.fillSendersEmail(random.randomEmail(5, 12));
			giftCards.fillSendersMobile(random.randomMobileNumber(6));
			propertyReader.propertyReader();
			giftCards.fillSendersAddress(propertyReader.readProperty("address"));
			giftCards.clickConfirmButton();
			String errorMessage = giftCards.getErrorMessageWithoutMobileNumberInput();
			String errorDetails = giftCards.getErrorDetailsWithInvalidMobileNumber();
			System.out.println(errorMessage + "\n" + errorDetails + "\n");
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 6,groups= {"Regression Test","Master"})
	public void validateErrorMessageWithoutAddressInSenderDetails() {
		try {
			giftCards = new GiftCardsPage(driver);
			propertyReader = new PropertyReader();
			giftCards.clearSenderDetails();
			System.out.println("Checking the Validity of the form without providing Sender's Address:");
			giftCards.fillSendersName(random.randomString(5, 12));
			giftCards.fillSendersEmail(random.randomEmail(5, 12));
			giftCards.fillSendersMobile(random.randomMobileNumber(9));
			propertyReader.propertyReader();
			giftCards.clickConfirmButton();
			String errorMessage = giftCards.getErrorMessageWithoutAddressInput();
			String errorDetails = giftCards.getErrorDetailsWithoutAddressInput();
			System.out.println(errorMessage + "\n" + errorDetails + "\n");
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
		logger.info(" All error message got captured ");
		logger.info("*** Ending of RecipientAndSenderDetails ***");
	}
}
