package spicejet;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class loginPage {
	  public WebDriver driver;
	    
	    @FindBy(xpath = "//body/div[@id='react-root']/div[@id='main-container']"
	    		+ "/div[@class='css-1dbjc4n r-1niwhzg r-1jgb5lz r-r0h9e2 r-13qz1uu']"
	    		+ "/div[@class='css-1dbjc4n r-1p0dtai r-18u37iz r-1d2f490 r-u8s1d r-zchlnj r-ipm5af']"
	    		+ "/div[@class='css-1dbjc4n r-14lw9ot r-1p0dtai r-1pcd2l5 r-wk8lta r-u8s1d r-zchlnj r-ipm5af']"
	    		+ "/div[@class='css-1dbjc4n r-13awgt0 r-156q2ks']/div[@class='css-1dbjc4n r-wk8lta r-1xcajam']"
	    		+ "/div[@class='css-1dbjc4n r-150rngu r-eqz5dr r-16y2uox r-1wbh5a2 r-11yh6sk r-1rnoaur r-1sncvnh']"
	    		+ "/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n r-1d09ksm r-18u37iz']"
	    		+ "/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n']"
	    		+ "/div[@class='css-1dbjc4n r-1d09ksm r-1inuy60 r-1qxgc49']"
	    		+ "/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n r-18u37iz r-1w6e6rj r-p1pxzi']"
	    		+ "/div[2]/div[1]//*[name()='svg']//*[name()='circle' and contains(@cx,'9')]")
	    private WebElement radiobutton;


	    @FindBy(xpath = "//input[@type='email']")
	    private WebElement emailField;

	    @FindBy(xpath = "//input[@type='password']")
	    private WebElement passwordField;

	    @FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-184aecr "
	    		+ "r-z2wwpe r-1loqt21 r-18u37iz r-tmtnm0 r-1777fci r-1x0uki6 r-1w50u8q r-ah5dr5 r-1otgn73']")
	    private WebElement loginSubmitButton;

	    public  loginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void login(String email, String password) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(radiobutton)).click();
	        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
	        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
	        wait.until(ExpectedConditions.elementToBeClickable(loginSubmitButton)).click();
	    }

}
