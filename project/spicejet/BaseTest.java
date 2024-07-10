
	package spicejet;

	import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

	public class BaseTest {
	    public static WebDriver driver;
	    public HomePage homePage;
	    public  SignupPage signUpPage;
	    public  loginPage loginPage;
	    public SearchingFlight searchingFlight;
	    public BookingPage bookingPage;
	    public  ConfirmationMsg confirmationPage;
	    
	    public static WebDriver launchBrowser(String browser) {

			if (browser.equalsIgnoreCase("Chrome")) {
				ChromeOptions op = new ChromeOptions();
				// op.addArguments("--headless=new");
				op.addArguments("--disable-notifications");
				op.addArguments("start-maximized");
				driver = new ChromeDriver(op);
			} else if (browser.equalsIgnoreCase("Edge")) {
				EdgeOptions op = new EdgeOptions();
				// op.addArguments("--headless");
				op.addArguments("--disable-notifications");
				op.addArguments("start-maximized");
				driver = new EdgeDriver(op);
			} else if (browser.equalsIgnoreCase("Firefox")) {
				FirefoxOptions op = new FirefoxOptions();
				// op.addArguments("--headless");
				op.addArguments("--disable-notifications");
				op.addArguments("start-maximized");
				driver = new FirefoxDriver(op);
			}
			return driver;
		}

		@BeforeMethod
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        homePage = new HomePage(driver);
	        signUpPage = new SignupPage(driver);
	        loginPage = new loginPage(driver);
	        searchingFlight = new SearchingFlight(driver);
	        bookingPage = new BookingPage(driver);
	        confirmationPage = new ConfirmationMsg(driver);
	    }

		@AfterMethod
	    public void tearDown(ITestResult result) {
	        if (ITestResult.FAILURE == result.getStatus()) {
	            takeScreenshot(result.getName());
	        }
	        driver.quit();
	    }
		
	    public void takeScreenshot(String testName) {
	    	TakesScreenshot ts = (TakesScreenshot) driver;
	        File srcFile = ts.getScreenshotAs(OutputType.FILE);
	        try {
	        	// Ensure the directory exists
	            Files.createDirectories(Paths.get("screenshots"));

	            Files.copy(srcFile.toPath(), Paths.get("screenshots", testName + ".png"),StandardCopyOption.REPLACE_EXISTING);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}



