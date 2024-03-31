package testScenarios;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BookShelvesPage;
import testBase.BaseClass;
import utilities.AddFluentWait;

public class VisibilityOfBookshelvesFilters extends BaseClass {
	
	@Test(priority = 0,groups= {"Smoke Test", "Regression Test", "Master"})
	public  void handlePopup() {
		logger = LogManager.getLogger(this.getClass());
		logger.info("*** Starting of VisibilityOfBookshelvesFilters ***");
		try {
			wait = new AddFluentWait();
			wait.addFluentWait(driver, "//a[@class = 'close-reveal-modal hide-mobile']");

			bookShelves = new BookShelvesPage(driver);
			bookShelves.handlePopup();
			logger.info("Pop-up handled successfully");
		}
		catch(Exception e) {
			System.out.println("No Pop-up appeared");
		}
	}
	
	@Test(priority = 1, dependsOnMethods = {"handlePopup"},groups= {"Smoke Test","Master"})
	public void isPriceFilterPresent() {
		try {
			boolean isPriceFilterVisible = bookShelves.isPriceFilterVisible();
			Assert.assertEquals(isPriceFilterVisible, true);	
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 2, dependsOnMethods = {"handlePopup"}, groups = {"Smoke Test","Master"})
	public void isStorageTypeFilterPresent() {
		try {
			boolean isStorageTypeFilterVisible = bookShelves.isStorageTypeFilterVisible();
			Assert.assertEquals(isStorageTypeFilterVisible, true);
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 3, dependsOnMethods = {"handlePopup"}, groups = {"Smoke Test","Master"})
	public void isBrandFilterPresent() {
		try {
			boolean isBrandFilterVisible = bookShelves.isBrandFilterVisible();
			Assert.assertEquals(isBrandFilterVisible, true);
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 4, dependsOnMethods = {"handlePopup"}, groups = {"Smoke Test","Master"})
	public void isOutOfStockCheckboxPresent() {
		try {
			boolean isOutOfStockCheckboxVisible = bookShelves.isOutOfStockCheckboxVisible();
			Assert.assertEquals(isOutOfStockCheckboxVisible, true);
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 5, dependsOnMethods = {"isPriceFilterPresent"}, groups = {"Smoke Test","Master"})
	public void isPriceFilterHoverable() {
		try {
			bookShelves.hoverOverPriceFilter();	
			wait.addFluentWait(driver, "//span[@class = 'filter-name' and text() = 'Price']");
			boolean isPriceFilterHoverable = bookShelves.isPriceFilterOptionVisible();
			Assert.assertEquals(isPriceFilterHoverable, true);
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}
		
	@Test(priority = 6, dependsOnMethods = {"isStorageTypeFilterPresent"}, groups = {"Smoke Test","Master"})
	public void isStorageTypeFilterHoverable() {
		try {
			bookShelves.hoverOverStorageTypeFilter();
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
}
