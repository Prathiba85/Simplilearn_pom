package testcases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class LoginTest extends BaseClass {
	public LoginPage lp;

	@Test(priority = 2)
	public void test1() throws InterruptedException {
		lp = new LoginPage(driver);

		lp.LoginFunction("sanprathi@gmail.com", "Chifley08");
	}

	@Test(priority = 3)
	public void test2() throws InterruptedException {
		lp = new LoginPage(driver);

		lp.LoginFunction("sanprathi@gmail.com", "Chifley09");

		WebElement error = driver.findElement(By.xpath("//div[@class='error_msg']"));
		String actual_error = error.getText();
		String expected_error = "The email or password you have entered is invalid.";
		Assert.assertEquals(actual_error, expected_error);

	}

	@Test(priority = 4)
	public void test4() throws InterruptedException, FilloException {
		lp = new LoginPage(driver);
		Recordset recordset = connection.executeQuery("Select * from data where TestName = 'test04'");
				recordset.next();
		String username = recordset.getField("UserName");
		String password = recordset.getField("Password");
		System.out.println(username);
		lp.LoginFunction(username, password);

	}

}
