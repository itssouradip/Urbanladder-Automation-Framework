package testScenarios;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BookShelvesPage;
import pageObjects.GiftCardsPage;
import testBase.BaseClass;

public class GiftCardCustomization extends BaseClass {
	
	@Test(priority = 0,groups= {"Smoke Test", "Regression Test", "Master"})
	public void validateGiftCardButton() {
		logger = LogManager.getLogger(this.getClass());
		logger.info("*** Starting of GiftCardCustomization ***");
		try{
			bookShelves = new BookShelvesPage(driver);
			bookShelves.scrollToGiftCardsButton();	
			
			boolean isGiftCardsButtonVisible = bookShelves.isGiftCardsButtonPresent();			
			Assert.assertEquals(isGiftCardsButtonVisible, true);
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 1,groups= {"Smoke Test", "Regression Test", "Master"})
	public void navigateToGiftCardsPage() {
		try {
			giftCards = new GiftCardsPage(driver);
			giftCards.clickGiftCardsButton();
			logger.info(" Gift card button clicked successfully ");
		}
		catch(Exception e) {
			logger.info(" Gift card button clicked failed ");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 2,groups= {"Regression Test","Master"})
	public void verifyBirthdayCardIsDisplayed() {
		try {
			giftCards = new GiftCardsPage(driver);
			giftCards.scrollToBirthdayOrAnniversaryOptions();
			boolean isBirthdayCardDisplayed = giftCards.isBirthdayOrAnniversaryOptionsDisplayed();
			Assert.assertEquals(isBirthdayCardDisplayed, true);
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 3,groups= {"Regression Test","Master"})
	public void giftCardCustomization() {
		try {
			logger.info(" Gift card Customization starts ");
			giftCards = new GiftCardsPage(driver);
			giftCards.chooseBirthdayOrAnniversaryOption();
			giftCards.selectGiftCardPrice();
			giftCards.selectMonth();
			giftCards.selectDate();
			giftCards.clickNext();
		}
		catch(Exception e) {
			logger.info(" Gift card Customization failed ");
			Assert.fail(e.getMessage());
		}
		logger.info("*** Ending of GiftCardCustomization ***");
	}
}
