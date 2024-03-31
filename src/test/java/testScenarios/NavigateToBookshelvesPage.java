package testScenarios;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BookShelvesPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class NavigateToBookshelvesPage extends BaseClass {
		
	@Test(priority = 0,groups = {"Smoke Test", "Regression Test", "Master"})
	public void isBookShelvesButtonPresent() {
		logger = LogManager.getLogger(this.getClass());
		logger.info("*** Starting of NavigateToBookshelvesPage ***");
		try{
			homePage = new HomePage(driver);
			boolean status = homePage.isBookshelvesVisible();
			Assert.assertEquals(status, true);
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 1, dependsOnMethods = {"isBookShelvesButtonPresent"},groups= {"Smoke Test", "Regression Test", "Master"})
	public void verifyBookshelvesPage() {
		try{
			homePage = new HomePage(driver);
			homePage.clickBookshelvesButton();
			
			bookShelves = new BookShelvesPage(driver);
			String actualHeading = bookShelves.getHeading();
			String expectedHeading = "Bookshelves";
			Assert.assertEquals(actualHeading, expectedHeading);
			logger.info("Bookshelve page loaded successfully");
		}
		catch(Exception e) {
			logger.info("Bookshelve page loading failed");
			Assert.fail(e.getMessage());
		}
		logger.info("*** Ending of NavigateToBookshelvesPage ***");
	}
}
