package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class AddFluentWait {
	FluentWait<WebDriver> wait;
	
	public void addFluentWait(WebDriver driver, String xpath) {
		wait = new FluentWait<WebDriver> (driver);
		wait.withTimeout(Duration.ofSeconds(25));
		wait.pollingEvery(Duration.ofSeconds(5));
		wait.ignoring(NoSuchElementException.class);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
}