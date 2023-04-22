package testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class LoginTest extends BaseClass {
	@Test
	public void test1() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);

		lp.LoginFunction("sanprathi@gmail.com", "Chifley08");
	}

	@Test
	public void test2() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);

		lp.LoginFunction("sanprathi@gmail.com", "Chifley09");

		WebElement error = driver.findElement(By.xpath("//div[@class='error_msg']"));
		String actual_error = error.getText();
		String expected_error = "The email or password you have entered is invalid.";
		Assert.assertEquals(actual_error, expected_error);

	}

}
