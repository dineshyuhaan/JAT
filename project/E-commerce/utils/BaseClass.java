package utils;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import test.SearchItemTest;

public class BaseClass {

    public static WebDriver driver;
    public static ExtentSparkReporter reporter;
    public static ExtentReports extent;

    public void launchBrowser(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dinesh\\eclipse-workspace\\Ecommerce\\chromedriver\\chromedriver.exe");
            ChromeOptions chromeOp = new ChromeOptions();
            chromeOp.addArguments("--headless=new");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\Dinesh\\eclipse-workspace\\Ecommerce\\edgedriver\\msedgedriver.exe");
            EdgeOptions edgeOp = new EdgeOptions();
            edgeOp.addArguments("--headless");
            driver = new EdgeDriver(edgeOp);
            driver.manage().window().maximize();
        }
    }

    public static void launchUrl(String url) {
        driver.get(url);
    }

    @Parameters({"browser", "url"})
    @BeforeTest
    public void setUp(String browser, String url) throws IOException {
        ConfigProperty config = FileReaderManager.getInstance().getConfigReader();
        launchBrowser(browser);
        launchUrl(url);
    }

    public static void implicitlyWait(int value) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(value));
    }

    public static void explicitlyWait(int value, WebElement visibilityOfElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(value));
        wait.until(ExpectedConditions.visibilityOf(visibilityOfElement));
    }

    public static void explicitlyWaitAll(int value, WebElement visibilityOfAllElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(value));
        wait.until(ExpectedConditions.elementToBeClickable(visibilityOfAllElement));
    }

    public static void scrollDownorUp(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }

    public static void verifyUrlLink(String url, String value, String valueOneOfOne, String valueTwoOfTwo)
            throws IOException {
        try {
            URL urlObject = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) urlObject.openConnection();
            urlConnection.connect();
            if (urlConnection.getResponseCode() >= 400) {
                System.out.println(url + value + urlConnection.getResponseMessage() + valueOneOfOne);
            } else {
                System.out.println(url + value + urlConnection.getResponseMessage() + valueTwoOfTwo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void urlVerify() throws IOException {
        String url = FileReaderManager.getInstance().getConfigReader().getUrl();
        verifyUrlLink(url, "--Website--", " Link is broken", " Link has been verified successfully");
    }

    public static void clickOnElement(WebElement brandsListItems) {
        if (brandsListItems == null) {
            throw new IllegalArgumentException("WebElement passed to clickOnElement is null.");
        }
        try {
            System.out.println("Attempting to click on element: " + brandsListItems);
            brandsListItems.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", brandsListItems);
            js.executeScript("arguments[0].click();", brandsListItems);
        }
    }

    public static void passInput(WebElement element, String value) {
        if (element == null) {
            throw new IllegalArgumentException("WebElement passed to passInput is null.");
        }
        System.out.println("Entering value: " + value + " into element: " + element);
        element.sendKeys(value);
    }

    public static void sendPhoneNumber(WebElement element, String phoneNumber) {
        if (element == null) {
            throw new IllegalArgumentException("WebElement passed to sendPhoneNumber is null.");
        }
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            element.clear();
            element.sendKeys(phoneNumber);
        } else {
            System.out.println("Phone number cannot be null or empty.");
        }
    }

    public static void pageSource(String containsValue, String sysoMessageOne, String sysoMessageTwo) {
        if (driver.getPageSource().contains(containsValue)) {
            System.out.println(sysoMessageOne);
        } else {
            System.out.println(sysoMessageTwo);
        }
    }

    public static void selectOperation(WebElement element, String value) {
        if (element == null) {
            throw new IllegalArgumentException("WebElement passed to selectOperation is null.");
        }
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement opt : options) {
            if (opt.getText().contains(value)) {
                opt.click();
                break;
            }
        }
    }

    public static void timeOut(int value) {
        try {
            Thread.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String takeScreenShot(String testCaseName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        File scrFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        File destinationFile = new File("C:\\Users\\Dinesh\\eclipse-workspace\\Ecommerce\\screenshots\\" + testCaseName + ".png");
        try {
            FileUtils.copyFile(scrFile, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String path = "<img src= " + destinationFile.getAbsolutePath() + " width = 200px height=200px />";

        Reporter.log(path);
        return destinationFile.getAbsolutePath();
    }

    public static void sleep(int value) throws InterruptedException {
        Thread.sleep(value);
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }

}
