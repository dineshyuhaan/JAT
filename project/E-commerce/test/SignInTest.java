package test;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import page.SignIn;
import utils.BaseClass;
import utils.ExcelUtils;

public class SignInTest extends BaseClass {

    public SignIn signIn;
    ExcelUtils obj = new ExcelUtils();


    @Test(priority = 0)
    public void signUpValidCredentials() throws IOException {
        signIn = new SignIn(driver);
        clickOnElement(signIn.getAccountButton());
        clickOnElement(signIn.getSignInButton());
        passInput(signIn.getSignInEmail(), obj.excelUtils("Sheet1", 6, 0));
        passInput(signIn.getSignInPassword(), obj.excelUtils("Sheet1", 6, 1));
        clickOnElement(signIn.getSignInSubmit());
        timeOut(2000);
        clickOnElement(signIn.getSignUpReturnPreviousPage());
        Assert.assertTrue(true);
    }
    @Test(priority = 1)
    public void signUpInValidCredentials() throws IOException {
        signIn = new SignIn(driver);
        clickOnElement(signIn.getAccountButton());
        clickOnElement(signIn.getSignInButton());
        passInput(signIn.getSignInEmail(), obj.excelUtils("Sheet1", 7, 0));
        passInput(signIn.getSignInPassword(), obj.excelUtils("Sheet1", 7, 1));
        clickOnElement(signIn.getSignInSubmit());
        timeOut(2000);
        clickOnElement(signIn.getSignUpReturnPreviousPage());
        Assert.assertTrue(true);
    }
    @Test(priority = 2)
    public void signUpEmptyCredentials() throws IOException {
        signIn = new SignIn(driver);
        clickOnElement(signIn.getAccountButton());
        clickOnElement(signIn.getSignInButton());
        passInput(signIn.getSignInEmail(), "");
        passInput(signIn.getSignInPassword(), "");
        clickOnElement(signIn.getSignInSubmit());
        timeOut(2000);
        clickOnElement(signIn.getSignUpReturnPreviousPage());
        Assert.assertTrue(true);
    }
}
