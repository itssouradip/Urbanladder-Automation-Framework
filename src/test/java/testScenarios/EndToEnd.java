package testScenarios;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BookShelvesPage;
import pageObjects.GiftCardsPage;
import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.DataProviders;
import utilities.ExcelUtility;
import utilities.PropertyReader;

public class EndToEnd extends BaseClass {
	
	String path = ".//dataTables/testResult.xlsx";
	PropertyReader propertyReader;
	
	@Test(priority = 0,groups= {"Smoke Test", "Regression Test", "Master"})
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
	
	@Test(priority = 2,groups= {"Smoke Test", "Regression Test", "Master"})
	public  void handlePopup() {
		logger = LogManager.getLogger(this.getClass());
		logger.info("*** Starting of VisibilityOfBookshelvesFilters ***");
		try {
			bookShelves = new BookShelvesPage(driver);
			wait = new AddFluentWait();
			wait.addFluentWait(driver, "//a[@class = 'close-reveal-modal hide-mobile']");
			bookShelves.handlePopup();
			logger.info("Pop-up handled successfully");
		}
		catch(Exception e) {
			System.out.println("No Pop-up appeared");
		}
	}
	
	@Test(priority = 3, dependsOnMethods = {"handlePopup"},groups= {"Smoke Test","Master"})
	public void isPriceFilterPresent() {
		try {
			bookShelves = new BookShelvesPage(driver);
			boolean isPriceFilterVisible = bookShelves.isPriceFilterVisible();
			Assert.assertEquals(isPriceFilterVisible, true);	
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 4, dependsOnMethods = {"handlePopup"}, groups = {"Smoke Test","Master"})
	public void isStorageTypeFilterPresent() {
		try {
			bookShelves = new BookShelvesPage(driver);
			boolean isStorageTypeFilterVisible = bookShelves.isStorageTypeFilterVisible();
			Assert.assertEquals(isStorageTypeFilterVisible, true);
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 5, dependsOnMethods = {"handlePopup"}, groups = {"Smoke Test","Master"})
	public void isBrandFilterPresent() {
		try {
			bookShelves = new BookShelvesPage(driver);
			boolean isBrandFilterVisible = bookShelves.isBrandFilterVisible();
			Assert.assertEquals(isBrandFilterVisible, true);
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 6, dependsOnMethods = {"handlePopup"}, groups = {"Smoke Test","Master"})
	public void isOutOfStockCheckboxPresent() {
		try {
			bookShelves = new BookShelvesPage(driver);
			boolean isOutOfStockCheckboxVisible = bookShelves.isOutOfStockCheckboxVisible();
			Assert.assertEquals(isOutOfStockCheckboxVisible, true);
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 7, dependsOnMethods = {"isPriceFilterPresent"}, groups = {"Smoke Test","Master"})
	public void isPriceFilterHoverable() {
		try {
			bookShelves = new BookShelvesPage(driver);
			bookShelves.hoverOverPriceFilter();	
			wait = new AddFluentWait();
			wait.addFluentWait(driver, "//span[@class = 'filter-name' and text() = 'Price']");
			boolean isPriceFilterHoverable = bookShelves.isPriceFilterOptionVisible();
			Assert.assertEquals(isPriceFilterHoverable, true);
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
		
	@Test(priority = 8, dependsOnMethods = {"isStorageTypeFilterPresent"}, groups = {"Smoke Test","Master"})
	public void isStorageTypeFilterHoverable() {
		try {
			bookShelves = new BookShelvesPage(driver);
			bookShelves.hoverOverStorageTypeFilter();
			wait = new AddFluentWait();
			wait.addFluentWait(driver, "//span[@class = 'filter-name' and text() = 'Storage Type']");
			boolean isStorageTypeFilterOptionVisible = bookShelves.isStorageTypeFilterOptionVisible();
			Assert.assertEquals(isStorageTypeFilterOptionVisible, true);
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
		logger.info("*** All filters in Bookshelve page is interactable ***");
		logger.info("*** Ending of VisibilityOfBookshelvesFilters ***");
	}

	@Test(priority = 9,groups= {"Regression Test","Master"})
	public void setPriceSlider() {
		logger = LogManager.getLogger(this.getClass());
		logger.info("*** Starting of SettingTheRequiredFilters ***");
		try {
			bookShelves = new BookShelvesPage(driver);
			bookShelves.hoverOverPriceFilter();	
			bookShelves.setPriceFilter();
			logger.info(" Setting price filter successfully ");
		}
		catch(Exception e) {
			logger.info(" Setting price filter got failes ");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 10,groups= {"Regression Test","Master"})
	public void setStorageType() {
		try {
			bookShelves = new BookShelvesPage(driver);
			bookShelves.hoverOverStorageTypeFilter();
			bookShelves.selectOpenStorageType();
			logger.info(" Setting storage type as open ");
		}
		catch(Exception e) {
			logger.info(" Setting storage type as open got failed ");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 11,groups= {"Regression Test","Master"})
	public void checkOutOfStock() {
		try {
			bookShelves = new BookShelvesPage(driver);
			bookShelves.selectOutOfStockCheckbox();
			logger.info(" Exclude out of stock product ");
		}
		catch(Exception e) {
			logger.info(" Exclude out of stock product got failed ");
			Assert.fail(e.getMessage());
		}
		logger.info("*** Ending of SettingTheRequiredFilters ***");
	}
	
	@Test(priority = 12,groups= {"Regression Test","Master"})
	public void displayBookshelvesDetails() {
		logger = LogManager.getLogger(this.getClass());
		logger.info("*** Starting of DisplayBookShelvesDetails ***");
		try {
			excelUtility = new ExcelUtility(path);
			bookShelves = new BookShelvesPage(driver);
			List<String> productName = bookShelves.getProductName();
			List<String> productPrice = bookShelves.getProductPrice();
			
			excelUtility.setCellData("BookshelveDetails", 0, 0, "Bookshelve Name");
			excelUtility.setCellData("BookshelveDetails", 0, 1, "Bookshelve Price");
			logger.info(" Printing bookshelves on console ");
			logger.info(" Printing bookshelves on excel sheet ");
			for(int i = 0; i <=2; i++) {
				System.out.println(productName.get(i) + "\t\t" + productPrice.get(i));
				excelUtility.setCellData("BookshelveDetails", i+1, 0, productName.get(i));
				excelUtility.setCellData("BookshelveDetails", i+1, 1, productPrice.get(i));
			}
		
		}catch(Exception e) {
			logger.info(" Printing bookshelves on console got failed ");
			logger.info(" Printing bookshelves on excell sheet got failed ");
			Assert.fail(e.getMessage());
		}
		logger.info("*** Ending of DisplayBookShelvesDetails ***");
	}
	
	@Test(priority = 13,groups= {"Smoke Test", "Regression Test" , "Master"})
	public void isHomeDecorMenuPresent() {
		logger = LogManager.getLogger(this.getClass());
		logger.info("*** Starting of GetListOfSubMenuItems ***");
		try{
			bookShelves = new BookShelvesPage(driver);
			bookShelves.scrollToUlService();
			bookShelves.hoverOverLightingAndDecor();
			wait.addFluentWait(driver, "//ul[@class = 'inline-list left']/li[5]//a[text() = 'Home Decor']");
			boolean isHomeDecorMenuPresent = bookShelves.isHomeDecorMenuPresent();
			Assert.assertEquals(isHomeDecorMenuPresent, true);
			logger.info(" Home Decore menu and sub-menu loaded successfully ");
		}
		catch(Exception e) {
			logger.info(" Home Decore menu and sub-menu loading failed ");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 14,groups= {"Regression Test","Master"})
	public void getHomeDecorSubMenuItems() {
		try {
			excelUtility = new ExcelUtility(path);
					
			bookShelves = new BookShelvesPage(driver);
			List<String> homeDecorSubMenuItems = bookShelves.homeDecorSubMenuItems();
			System.out.println("\nList of Sub-Menu items under the Home Decor Menu:");
			excelUtility.setCellData("SubMenuItems", 0, 0, "Sub-Menu items");
			logger.info(" Printing Home decore items on console ");
			logger.info(" Printing Home decore items on excel sheets ");
			for(int i = 0; i < homeDecorSubMenuItems.size(); i++) {
				System.out.println(homeDecorSubMenuItems.get(i));
				excelUtility.setCellData("SubMenuItems", i+1, 0, homeDecorSubMenuItems.get(i));
			}
			System.out.println("\n");
		}
		catch(Exception e) {
			logger.info(" Printing Home decore items loading failed ");
			Assert.fail(e.getMessage());
		}
		logger.info("*** Ending of GetListOfSubMenuItems ***");
	}

	@Test(priority = 15,groups= {"Smoke Test", "Regression Test", "Master"})
	public void validateGiftCardButton() {
		logger = LogManager.getLogger(this.getClass());
		logger.info("*** Starting of GiftCardCustomization ***");
		try{
			giftCards = new GiftCardsPage(driver);
			bookShelves = new BookShelvesPage(driver);
			giftCards.hoverOverNavBar();
			bookShelves.scrollToUlService();
			boolean isGiftCardsButtonVisible = giftCards.isGiftCardsButtonVisible();
			Assert.assertEquals(isGiftCardsButtonVisible, true);
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 16,groups= {"Smoke Test", "Regression Test", "Master"})
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
	
	@Test(priority = 17,groups= {"Regression Test","Master"})
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
	
	@Test(priority = 18,groups= {"Regression Test","Master"})
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

	@Test(priority = 19,dataProvider = "RecipientDetails",dataProviderClass=DataProviders.class,groups= {"Regression Test","Master"})
	public void enterRecipientDetailsDDT(String name,String email,String mobile) {
		logger = LogManager.getLogger(this.getClass());
		logger.info("*** Starting of RecipientAndSenderDetailsDDT ***");
		try {
			logger.info(" Setting Recipient details through Data Driven Approach ");
			giftCards = new GiftCardsPage(driver);
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
	
	@Test(priority = 20,dataProvider = "SenderDetails",dataProviderClass=DataProviders.class,groups= {"Regression Test","Master"})
	public void enterSenderDetailsDDT(String name,String email,String mobile,String address) throws IOException {
		try {
		logger.info(" Setting Sender details through Data Driven Approach ");
		propertyReader = new PropertyReader();
		propertyReader.propertyReader();
		
		giftCards = new GiftCardsPage(driver);
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
		logger.info("*** Ending of RecipientAndSenderDetailsDDT ***");
	}

}
