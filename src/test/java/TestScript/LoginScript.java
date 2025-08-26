package TestScript;

import org.testng.Assert;
import Log.Log;
import org.testng.annotations.Test;

import Constant.AdminLTEConstant;
import Pages.LoginPage;
import TestBase.BaseClass;

public class LoginScript extends BaseClass {

	@Test
	public void verifyLogin() throws InterruptedException {
		LoginPage LoginPageObj = new LoginPage(driver);

		LoginPageObj.Login(prop.getProperty("username"),prop.getProperty("password"));
		Log.info("User entered username and password.");
		 
		Thread.sleep(AdminLTEConstant.MINOR_WAIT);
		
		Assert.assertEquals(driver.getCurrentUrl(),
				"file:///C:/Users/Madhav.V/Desktop/Selenium/OfflineWebsite-20250805T125208Z-1-001/OfflineWebsite/pages/examples/dashboard.html");
		 Log.info("User redirected to dashboard page.");
	}

}
