package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public static WebDriver driver;
	// ========================Objects=========================//
	@FindBy(xpath = ("//a[text()=' Log in']"))
	WebElement loginlink;

	@FindBy(name = "user_login")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(className = "rememberMe")
	WebElement rememberme;
	@FindBy(name = "btn_login")
	WebElement login;

	// =======================Methods==========================//

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void LoginFunction(String usernameval, String passwordval) throws InterruptedException {

		Thread.sleep(2000);

		loginlink.click();
		// 4.enter the username

		username.sendKeys(usernameval);

		// step 5-enter the password

		// password.sendKeys("Chifley08");
		password.sendKeys(passwordval);

		rememberme.click();

		// 6.click on login button.

		login.click();

	}

}
