package spicejet;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	   private static ExtentReports extent = new ExtentReports();
	    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	    static {
	        ExtentSparkReporter spark = new ExtentSparkReporter("SpiceJet/ExtentReports/SparkReport.html");
	        extent.attachReporter(spark);
	    }

	    @Override
	    public void onTestStart(ITestResult result) {
	        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
	        test.set(extentTest);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.get().pass("Test passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        test.get().fail(result.getThrowable());
	        String screenshotPath = "screenshots/" + result.getName() + ".png";
	        test.get().addScreenCaptureFromPath(screenshotPath);
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        test.get().skip(result.getThrowable());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	        extent.flush();
	    }
	}



