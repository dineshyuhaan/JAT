package spicejet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {
	  WebDriver driver;

	    // Constructor to initialize the driver and web elements
	    public  SignupPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    // Locators for the elements on the Sign-Up page
	    @FindBy(xpath = "//div[@class='col-sm-4 mt-2 px-sm-4']//select[contains(@class,'form-control form-select')]")
	    public WebElement titleDropdown;

	    @FindBy(xpath = "//input[@id='first_name']")
	    public WebElement firstNameField;

	    @FindBy(xpath = "//input[@id='lastName']")
	    public WebElement lastNameField;

	    @FindBy(xpath = "//input[@id='mobileNumber']")
	    public WebElement mobileNumberField;

	    @FindBy(xpath = "//input[@name='email']")
	    public WebElement emailField;

	    @FindBy(xpath = "//input[@name='password']")
	    public WebElement passwordField;

	    @FindBy(xpath = "//input[@name='confirmPassword']")
	    public WebElement confirmPasswordField;

	    @FindBy(xpath = "//input[@name='dob']")
	    public WebElement dateOfBirthField;

	    @FindBy(xpath = "//input[@name='agreeToTerms']")
	    public WebElement agreeToTermsCheckbox;

	    @FindBy(xpath = "//button[@type='submit']")
	    public WebElement submitButton;

	    // Method to fill out the sign-up form
	    public void signUp(String title, String firstName, String lastName, String mobileNumber, String email, String password, String dob) {
	        // Select title from dropdown
	        Select selectTitle = new Select(titleDropdown);
	        selectTitle.selectByVisibleText(title);

	        // Fill in the first name
	        firstNameField.sendKeys(firstName);

	        // Fill in the last name
	        lastNameField.sendKeys(lastName);

	        // Fill in the mobile number
	        mobileNumberField.sendKeys(mobileNumber);

	        // Fill in the email
	        emailField.sendKeys(email);

	        // Fill in the password
	        passwordField.sendKeys(password);

	        // Fill in the confirm password
	        confirmPasswordField.sendKeys(password);

	        // Fill in the date of birth
	        dateOfBirthField.sendKeys(dob);

	        // Check the agree to terms checkbox
	        if (!agreeToTermsCheckbox.isSelected()) {
	            agreeToTermsCheckbox.click();
	        }

	        // Click the submit button
	        submitButton.click();
	    }

}
