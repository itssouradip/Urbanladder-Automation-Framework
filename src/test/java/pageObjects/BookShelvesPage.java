package pageObjects;

import testBase.BasePage;
import utilities.AddFluentWait;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class BookShelvesPage extends BasePage {
	
	public AddFluentWait wait = new AddFluentWait();
	
	// Constructor for BookShelvesPage
	public BookShelvesPage(WebDriver driver) {
		super(driver);
	}
	
	// Locating the elements
	@FindBy(xpath = "//a[@class = 'close-reveal-modal hide-mobile']") WebElement buttonPopupClose;
	@FindBy(xpath = "//h1[@class = 'withsubtext']") WebElement pageHeading;
	@FindBy(xpath = "(//li[@data-group = 'price'])[1]") WebElement dropdownPrice;
	@FindBy(xpath = "//div[contains(text(), 'Storage Type')]") WebElement dropdownStorageType;
	@FindBy(xpath = "//div[contains(text(), 'Brand')]") WebElement dropdownBrand;
	@FindBy(xpath = "//input[@id = 'filters_availability_In_Stock_Only']") WebElement checkboxOutOfStock;
	@FindBy(xpath = "//ul[@class = 'featuredLinksBar__linkContainer']/li[3]/a") WebElement buttonGiftCards;
	@FindBy(xpath = "//span[@class = 'filter-name' and text() = 'Price']") WebElement priceFilterMenu;
	@FindBy(xpath = "//div[@class = 'noUi-handle noUi-handle-upper']") WebElement priceSliderPointRight;
	@FindBy(xpath = "//span[@class = 'filter-name' and text() = 'Storage Type']") WebElement storageFilterMenu;
	@FindBy(xpath = "//input[@type = 'checkbox' and @value = 'Open']") WebElement openStorageType;
	@FindBy(xpath = "//li[contains(@class, 'product hovercard')]//div[@class = 'price-number']/span") static List<WebElement> productPrice;
	@FindBy(xpath = "//*[@id=\"content\"]/div[3]/ul/li/div/div[5]/a/div[1]/span") static List<WebElement> productName;
	@FindBy(xpath = "//li[@class = 'topnav_item lightingunit']/span") WebElement lightingAndDecorMenu;
	@FindBy(xpath = "//ul[@class = 'inline-list left']/li[5]//a[text() = 'Home Decor']") WebElement homeDecorMenuButton;
	@FindBy(xpath = "(//div[@class='taxontype'])[28] /following-sibling::ul//span") static List<WebElement> homeDecorSubMenu;
	@FindBy(xpath= "//a[text()=' UL Services ']") WebElement ulService;
	@FindBy(xpath = "//strong[text() = 'Click to shop.']") WebElement clickToShopLink;
	
	// Action methods
	public void handlePopup() {
			buttonPopupClose.click();
	}
	
	public String getHeading() {
		String headingText = pageHeading.getText();
		return headingText;
	}
	
	public boolean isPriceFilterVisible() {
		boolean status = dropdownPrice.isDisplayed();
		return status;
	}
	
	public boolean isStorageTypeFilterVisible() {
		boolean status = dropdownStorageType.isDisplayed();
		return status;
	}
	
	public boolean isBrandFilterVisible() {
		boolean status = dropdownBrand.isDisplayed();
		return status;
	}
	
	public boolean isOutOfStockCheckboxVisible() {
		boolean status = checkboxOutOfStock.isDisplayed();
		return status;
	}
	
	public void hoverOverPriceFilter() {
		Actions action = new Actions(driver);
		action.click(dropdownPrice).perform();
	}
		
	public boolean isPriceFilterOptionVisible() {
		boolean status = priceFilterMenu.isDisplayed();
		return status;
	}
		
	public void setPriceFilter() {
		Actions action = new Actions(driver);
		action.moveToElement(priceSliderPointRight).clickAndHold().moveByOffset(-273, 0).release().perform();
	}
	
	public void hoverOverStorageTypeFilter() {
		Actions action = new Actions(driver);
		action.moveToElement(dropdownStorageType).perform();
	}
	
	public boolean isStorageTypeFilterOptionVisible() {
		boolean status = storageFilterMenu.isDisplayed();
		return status;
	}
	
	public void selectOpenStorageType() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", openStorageType);
	}
	
	public void selectOutOfStockCheckbox() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", checkboxOutOfStock);
	}
	
	public List<WebElement> procutNameElements(){
		return productName;
	}
	
	public List<WebElement> procuctPriceElements(){
		return productPrice;
	}
	
	public List<String> getProductName(){
		List<String> productNames = new ArrayList<String>();
		for(int i = 0; i < productName.size(); i++) {
			productNames.add(i, productName.get(i).getText());
		}
		return productNames;
	}
	
	public List<String> getProductPrice(){
		List<String> productPrices = new ArrayList<String>();
		for(int i = 0; i < productPrice.size(); i++) {
			productPrices.add(i, productPrice.get(i).getText());
		}
		return productPrices;
	}
	
	public void hoverOverLightingAndDecor() {
		Actions action = new Actions(driver);
		action.moveToElement(lightingAndDecorMenu).perform();
	}
	
	public boolean isHomeDecorMenuPresent() {
		boolean status = homeDecorMenuButton.isDisplayed();
		return status;
	}
	
	public List<WebElement> listOfSubMenuElements(){
		return homeDecorSubMenu;
	}
	
	public List<String> homeDecorSubMenuItems(){
		List<String> decorSubMenuItems = new ArrayList<String>();
		for(int i = 0; i < homeDecorSubMenu.size(); i++) {
			decorSubMenuItems.add(i, homeDecorSubMenu.get(i).getText());
		}
		return decorSubMenuItems;
	}
	
	public void scrollToUlService() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", ulService);
	}
	
	public void scrollToGiftCardsButton() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", buttonGiftCards);
	}
	
	public boolean isGiftCardsButtonPresent() {
		boolean status = buttonGiftCards.isDisplayed();
		return status;
	}
}
