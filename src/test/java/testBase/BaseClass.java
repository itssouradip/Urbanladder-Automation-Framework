package testBase;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.BookShelvesPage;
import pageObjects.GiftCardsPage;
import pageObjects.HomePage;
import utilities.AddFluentWait;
import utilities.ExcelUtility;
import utilities.PropertyReader;
import utilities.RandomInputGenerator;


public class BaseClass {
	
	public static WebDriver driver;
	public HomePage homePage;
	public BookShelvesPage bookShelves;
	public GiftCardsPage giftCards;
	public AddFluentWait wait;
	public ExcelUtility excelUtility;
	public RandomInputGenerator random;
	public PropertyReader readProperty = new PropertyReader();
	public static Logger logger;
	
	@BeforeClass(groups= {"Smoke Test" ,"Regression Test" , "Master"})
	@Parameters({"Browser", "OS"})
	public void setup(String browser, String OS) throws IOException {
		readProperty.propertyReader();
		if(readProperty.readProperty("environment").equalsIgnoreCase("local")){
			switch(browser.toLowerCase()) {
				case "chrome":{
					driver = new ChromeDriver();
					break;
				}
				case "edge":{
					driver = new EdgeDriver();
					break;
				}
				default: {
					System.out.println("No matching browser found");
					return;
				}
			}
		}
		else if(readProperty.readProperty("environment").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			if(OS.equalsIgnoreCase("Windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(OS.equalsIgnoreCase("Mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("No matching OS");
				return;
			}
			switch(browser.toLowerCase()) {
				case "chrome": capabilities.setBrowserName("chrome");
				break;
				case "edge": capabilities.setBrowserName("MicrosoftEdge");
				break;
				default: System.out.println("No matching browser");
				return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		}
		logger = LogManager.getLogger(this.getClass());
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));

		driver.navigate().to(readProperty.readProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Smoke Test" , "Regression Test" , "Master"})
	public void teardown() {
		driver.quit();
	}
	
	public String captureScreen(String name) throws IOException{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\" + name + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
}
