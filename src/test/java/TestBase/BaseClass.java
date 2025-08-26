package TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
    public static Properties prop;
    public static FileInputStream fis;
    
	@BeforeClass
	@Parameters({ "browser" })
	public void OpenBrowser(String Browser) throws IOException {

		prop = new Properties();
		fis = new FileInputStream("C:\\Users\\Madhav.V\\Desktop\\Selenium\\AdminLTE\\resources\\projectconfig.properties");
		
		prop.load(fis);
		
		// cross browser testing implementation
		if (Browser.equalsIgnoreCase("chrome")) {
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Selenium\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();

		driver.get(prop.getProperty("url"));

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
