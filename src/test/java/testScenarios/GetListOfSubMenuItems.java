package testScenarios;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BookShelvesPage;
import testBase.BaseClass;
import utilities.AddFluentWait;
import utilities.ExcelUtility;

public class GetListOfSubMenuItems extends BaseClass {
	
	String path = ".//dataTables/testResult.xlsx";

	@Test(priority = 0,groups= {"Smoke Test", "Regression Test" , "Master"})
	public void isHomeDecorMenuPresent() {
		logger = LogManager.getLogger(this.getClass());
		logger.info("*** Starting of GetListOfSubMenuItems ***");
		try{
			bookShelves = new BookShelvesPage(driver);
			
			bookShelves.scrollToUlService();
			bookShelves.hoverOverLightingAndDecor();
			
			wait = new AddFluentWait();
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
	
	@Test(priority = 1,groups= {"Regression Test","Master"})
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

}
