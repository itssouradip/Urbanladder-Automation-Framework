package testScenarios;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.GiftCardsPage;
import testBase.BaseClass;
import utilities.DataProviders;
import utilities.PropertyReader;

public class RecipientAndSenderDetailsDDT extends BaseClass{
		
	PropertyReader propertyReader;
	
	@Test(priority = 0,dataProvider = "RecipientDetails",dataProviderClass=DataProviders.class,groups= {"Regression Test","Master"})
	public void enterRecipientDetailsDDT(String name,String email,String mobile) {
		logger = LogManager.getLogger(this.getClass());
		logger.info("*** Starting of RecipientAndSenderDetails ***");
		try {
			logger.info(" Setting Recipient details through Data Driven Approach ");
			giftCards = new GiftCardsPage(driver);
			giftCards.fillRecipientsName(name);
			giftCards.fillRecipientEmail(email);
			giftCards.fillRecipientMobile(mobile);
		}
		catch(Exception e) {
			logger.info(" Setting Recipient details through Data Driven Approach got failed ");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 1,dataProvider = "SenderDetails",dataProviderClass=DataProviders.class,groups= {"Regression Test","Master"})
	public void enterSenderDetailsDDT(String name,String email,String mobile,String address) throws IOException {
		try {
		logger.info(" Setting Sender details through Data Driven Approach ");
		propertyReader = new PropertyReader();
		propertyReader.propertyReader();
		
		giftCards.fillSendersName(name);
		giftCards.fillSendersEmail(email);
		giftCards.fillSendersMobile(mobile);
		giftCards.fillSendersAddress(address);

		giftCards.fillSenderPin(propertyReader.readProperty("pincode"));
		
		giftCards.clickConfirmButton();
		
		if(name.isEmpty()) {
			System.out.println("Checking the Validity of the form without providing Sender's Name:");
			String errorMessage =giftCards.getErrorMessageWithoutNameInput();
			String errorDetails = giftCards.getErrorDetailsWithoutNameInput();
			System.out.println(errorMessage +"\n"+errorDetails +"\n");
		}
		else if(email.isEmpty()) {
			System.out.println("Checking the Validity of the form without providing Sender's Email:");
			String errorMessage = giftCards.getErrorMessageWithoutEmailInput();
			System.out.println(errorMessage +"\n");
		}
		else if(!email.endsWith("@gmail.com")) {
			System.out.println("Checking the Validity of the form with providing invalid Sender's Email:");
			String errorMessage = giftCards.getErrorMessageWithoutEmailInput();
			System.out.println(errorMessage +"\n");
		}
		else if(mobile.isEmpty()) {
			System.out.println("Checking the Validity of the form without providing Sender's Mobile Number:");
			String errorMessage = giftCards.getErrorMessageWithoutMobileNumberInput();
			String errorDetails = giftCards.getErrorDetailsWithInvalidMobileNumber();
			System.out.println(errorMessage + "\n" + errorDetails +"\n");
		}
		else if(mobile.length()!=10) {
			System.out.println("Checking the Validity of the form with providing invalid Sender's Mobile Number:");
			String errorMessage = giftCards.getErrorMessageWithoutMobileNumberInput();
			String errorDetails = giftCards.getErrorDetailsWithInvalidMobileNumber();
			System.out.println(errorMessage + "\n" + errorDetails +"\n");
		}
		else if(address.isEmpty()) {
			System.out.println("Checking the Validity of the form without providing Sender's Address:");
			String errorMessage = giftCards.getErrorMessageWithoutAddressInput();
			String errorDetails = giftCards.getErrorDetailsWithoutAddressInput();
			System.out.println(errorMessage + "\n" + errorDetails +"\n");
		}
		
		giftCards.clearSenderDetails();
		}
		catch(Exception e) {
			logger.info(" Setting Sender details through Data Driven Approach got failed ");
			Assert.fail(e.getMessage());
		}
		logger.info(" All error message got captured ");
		logger.info("*** Ending of RecipientAndSenderDetails ***");
	}

}
