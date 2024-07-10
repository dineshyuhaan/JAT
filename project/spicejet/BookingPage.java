package spicejet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class BookingPage {
	 public WebDriver driver;

	    @FindBy(id = "firstName")
	    private WebElement firstNameField;

	    @FindBy(id = "lastName")
	    private WebElement lastNameField;

	    @FindBy(id = "email")
	    private WebElement emailField;

	    @FindBy(id = "cardNumber")
	    private WebElement cardNumberField;

	    @FindBy(id = "bookButton")
	    private WebElement bookButton;

	    @FindBy(id = "errorMessage")
	    private WebElement errorMessage;

	    public BookingPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void fillBookingForm(String firstName, String lastName, String email, String cardNumber) {
	        firstNameField.sendKeys(firstName);
	        lastNameField.sendKeys(lastName);
	        emailField.sendKeys(email);
	        cardNumberField.sendKeys(cardNumber);
	        bookButton.click();
	    }

	    public String getErrorMessage() {
	        return errorMessage.getText();
	    }
}
