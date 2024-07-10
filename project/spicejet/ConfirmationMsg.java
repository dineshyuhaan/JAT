package spicejet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationMsg {
	  public WebDriver driver;

	    @FindBy(id = "confirmationMessage")
	    private WebElement confirmationMessage;

	    public ConfirmationMsg(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public boolean isBookingConfirmed() {
	        return confirmationMessage.isDisplayed();
	    }
}
