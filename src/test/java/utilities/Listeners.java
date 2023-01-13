package utilities;

import automationexercise.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {

    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    WebDriver driver = Driver.getDriver();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
                    .get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String filePath = null;
        try {
            filePath = getScreenShot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Screenshot,Attach to report (only the test fail it takes screenshot)

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }


}
