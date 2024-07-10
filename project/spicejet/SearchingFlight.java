package spicejet;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SearchingFlight {
	 public WebDriver driver;

	    @FindBy(xpath = "")
	    private WebElement fromCityField;

	    @FindBy(xpath = "[@id=\\\"main-container\\\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[3]/div/div[2]/input")
	    private WebElement toCityField;

	    @FindBy(xpath = "//*[@id=\\\"main-container\\\"]/div/div[1]/div[3]/div[2]/div[4]/div/div/div[1]")
	    private WebElement departureDateField;

	    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-1w50u8q r-ah5dr5 r-1otgn73']")
	    private WebElement searchButton;

	    @FindBy(xpath = "//input[@id='inlineRadio2']")
	    private WebElement oneWayRadioButton;

	    @FindBy(id = "errorMessage")
	    private WebElement errorMessage;

	    public SearchingFlight(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public  void searchingOneWayFlight (String from, String to, String date) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        wait.until(ExpectedConditions.elementToBeClickable(fromCityField)).click();
	        fromCityField.sendKeys(from);

	        wait.until(ExpectedConditions.elementToBeClickable(toCityField)).click();
	        toCityField.sendKeys(to);

	        wait.until(ExpectedConditions.elementToBeClickable(departureDateField)).click();
	        departureDateField.sendKeys(date);
	        
	        wait.until(ExpectedConditions.elementToBeClickable(oneWayRadioButton)).click();

	        // Check and wait for any overlay to disappear
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'r-1loqt21')]")));

	        // Scroll to the search button to ensure it's in view
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchButton);

	        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
	    }

	    

		public String getErrorMessage() {
	        return errorMessage.getText();
	    }
}
