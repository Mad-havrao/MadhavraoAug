package TestScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.AdminLTEConstant;
import Pages.AddUserPage;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.UserPage;
import TestBase.BaseClass;
import Log.Log;


public class AddUserTestScript extends BaseClass{

	@Test
	public void verifyAddUser() throws InterruptedException {

		LoginPage LoginPageObj = new LoginPage(driver);

		LoginPageObj.Login(prop.getProperty("username"),prop.getProperty("password"));
		Log.info("User entered username and password.");
		
		Thread.sleep(AdminLTEConstant.MINI_WAIT);
		
		Assert.assertEquals(driver.getCurrentUrl(),
				"file:///C:/Users/Madhav.V/Desktop/Selenium/OfflineWebsite-20250805T125208Z-1-001/OfflineWebsite/pages/examples/dashboard.html");
		
		Log.info("User redirected to dashboard page.");
		
		DashboardPage DashboardPageObj = new DashboardPage(driver);

		DashboardPageObj.clickOnUserTab();
		Log.info("User clicked on user tab.");
		
		UserPage UsersPageObj = new UserPage(driver);

		UsersPageObj.clickOnAddUserButton();
		Log.info("User clicked on add user button.");

		AddUserPage AddUserPageObj = new AddUserPage(driver);

		AddUserPageObj.fillForm("Prashant", "99887776655", "prashnat@gmail.com", "1234","HP");
		Log.info("User filled all mandatory information.");

		Thread.sleep(AdminLTEConstant.MINOR_WAIT);
	}
}
