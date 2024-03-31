package pageObjects;

import testBase.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	// Constructor for the HomePage
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	// Locating the WebElements
	@FindBy(xpath = "//h4[text() = 'Bookshelves']//ancestor::a") WebElement btnBookshelves;
	
	// Action Methods
	public boolean isBookshelvesVisible() {
		boolean status = btnBookshelves.isDisplayed();
		return status;
	}
	
	public void clickBookshelvesButton() {
		btnBookshelves.click();
	}
}
