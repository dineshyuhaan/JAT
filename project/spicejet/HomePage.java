package spicejet;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	 public WebDriver driver;

	    @FindBy(xpath = "//div[contains(text(),'Signup')]")
	    private WebElement signUpButton;

	    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-1otgn73']")
	    private WebElement loginButton;

	    @FindBy(id = "logoutButton")
	    private WebElement logoutButton;

	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void navigateToHomePage() {
	        driver.get("https://www.spicejet.com/");
	    }

	    public void clickSignUp() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
	    }

	    public void clickLogin() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	    }

	    public boolean isLogoutButtonPresent() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        return wait.until(ExpectedConditions.visibilityOf(logoutButton)).isDisplayed();
	    }
	}

	


