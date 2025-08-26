package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Helper;

public class UserPage extends Helper{
	
	@FindBy(xpath = "//button[text()='Add User']")
	private WebElement addUserButton;

	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddUserButton() {
		addUserButton.click();
	}

}
