package Utility;

import org.openqa.selenium.Alert;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

public class Helper {

    public static WebDriver driver;

    // ✅ Dropdown
    public static void selectByVisibleTextFromDropdown(WebElement wb, String value) {
        Select dropdown = new Select(wb);
        dropdown.selectByVisibleText(value);
    }

    // ✅ Alert
    public static void acceptAlert() {
        Alert al = driver.switchTo().alert();
        al.accept();
    }

    // ✅ Explicit waits
    public static void waitForElementToAppear(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementToBeClickable(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ Thread sleep
    public static void waitForSec(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // ✅ FIXED Screenshot method
    public String captureScreenshot(String screenshotName, String result) {
        String date = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        // ✅ Always use absolute path
        String destDir = System.getProperty("user.dir") + "/screenshots/" + result + "/";
        File directory = new File(destDir);
        if (!directory.exists()) {
            directory.mkdirs(); // create folder if missing
        }

        String destPath = destDir + screenshotName + "_" + date + ".png";
        File destFile = new File(destPath);

        try {
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("✅ Screenshot saved at: " + destPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destPath; // return absolute path for ExtentReport
    }

    // ✅ Misc utils
    public static String get_Month() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MMMMMMMMM");
        return formatter.format(date);
    }

    public static long currentTimeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }

    public static void clickUsingJS(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void enterUsingActionClass() {
        Actions obj = new Actions(driver);
        obj.sendKeys(Keys.ENTER).build().perform();
    }

    public static void selectValueFromIndexBasedOnIndex(WebElement wb, int index) {
        Select obj = new Select(wb);
        obj.selectByIndex(index);
    }

    public static void scrollToWebElement(WebElement wb) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", wb);
    }

    public static void enterValueUsingJS(WebElement wb) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", wb);
    }
}
