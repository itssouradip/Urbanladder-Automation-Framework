package testScenarios;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BookShelvesPage;
import testBase.BaseClass;
import utilities.AddFluentWait;

public class SettingTheRequiredFilters extends BaseClass {
		
	@Test(priority = 0,groups= {"Regression Test","Master"})
	public void setPriceSlider() {
		logger = LogManager.getLogger(this.getClass());
		logger.info("*** Starting of SettingTheRequiredFilters ***");
		try {
			bookShelves = new BookShelvesPage(driver);
			
			bookShelves.hoverOverPriceFilter();
			wait = new AddFluentWait();
			wait.addFluentWait(driver, "//span[@class = 'filter-name' and text() = 'Price']");
			bookShelves.setPriceFilter();
			logger.info(" Setting price filter successfully ");
		}
		catch(Exception e) {
			logger.info(" Setting price filter got failes ");
			Assert.fail(e.getMessage());
		}
	}
	
	@Test(priority = 1,groups= {"Regression Test","Master"})
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
	
	@Test(priority = 2,groups= {"Regression Test","Master"})
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
}
