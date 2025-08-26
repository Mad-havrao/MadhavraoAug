package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import Reports.ExtentTestManager;


import java.util.Date;

public class TestListener implements ITestListener {

    Helper helper = new Helper();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.startTest(result.getMethod().getMethodName(), result.getMethod().getDescription());

        // ✅ set test start time
        ExtentTestManager.getTest().getModel().setStartTime(new Date(result.getStartMillis()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String screenshotPath = helper.captureScreenshot(result.getMethod().getMethodName(), "passed");
        ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
        ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);

        // ✅ set test end time
        ExtentTestManager.getTest().getModel().setEndTime(new Date(result.getEndMillis()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotPath = helper.captureScreenshot(result.getMethod().getMethodName(), "failed");
        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed: " + result.getThrowable());
        ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);

        // ✅ set test end time
        ExtentTestManager.getTest().getModel().setEndTime(new Date(result.getEndMillis()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String screenshotPath = helper.captureScreenshot(result.getMethod().getMethodName(), "skipped");
        ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
        ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);

        // ✅ set test end time
        ExtentTestManager.getTest().getModel().setEndTime(new Date(result.getEndMillis()));
    }

    @Override
    public void onFinish(ITestContext context) {
        // ✅ flush once after suite execution
        ExtentTestManager.flush();
    }
}
