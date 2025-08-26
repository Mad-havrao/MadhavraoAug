package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Helper;

public class DashboardPage extends Helper{
	
	@FindBy(xpath = "//span[text()='Users']")
	private WebElement usersTab;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnUserTab() {
		usersTab.click();
	}

}
