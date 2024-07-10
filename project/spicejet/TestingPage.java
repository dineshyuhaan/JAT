package spicejet;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestingPage extends BaseTest {
	 //@Test
    public void testSignUp() {
        homePage.navigateToHomePage();
        
        try {
            homePage.clickSignUp();
        } catch (Exception e) {
            System.out.println("SignUp button not found: " + e.getMessage());
            System.out.println(driver.getPageSource());
            Assert.fail("SignUp button not found");
        }
        
        signUpPage.signUp("Mr", "Dinesh", "DR", "9597318456", "dineshr1725@gmail.com", "Yuhaan@1725", "17/10/1994");
        // Add assertions to verify successful sign-up (modify as needed)
    }

   // @Test
    public void testLogin() {
        homePage.navigateToHomePage();
        
        try {
            homePage.clickLogin();
        } catch (Exception e) {
            System.out.println("Login button not found: " + e.getMessage());
            System.out.println(driver.getPageSource());
            Assert.fail("Login button not found");
        }
        
        loginPage.login("dineshr1725@gmail.com", "Yuhaan@1725");
        //Assert.assertTrue(homePage.isLogoutButtonPresent(), "Login failed!");
    }

    @Test
    public void testSearchAndBookFlight() {
        
		homePage.navigateToHomePage();
        
        try {
            homePage.clickLogin();
        } catch (Exception e) {
            System.out.println("Login button not found: " + e.getMessage());
            System.out.println(driver.getPageSource());
            Assert.fail("Login button not found");
        }
        
        loginPage.login("dineshr1725@gmail.com", "Yuhaan@1725");
        searchingFlight.searchingOneWayFlight("Chennai", "Bangalore", "05/10/2024");
        
        bookingPage.fillBookingForm("Dinesh", "DR", "dineshr1725@gmail.com", "17259414122023");
        Assert.assertTrue(confirmationPage.isBookingConfirmed(), "Booking confirmation failed!");
    }
}
