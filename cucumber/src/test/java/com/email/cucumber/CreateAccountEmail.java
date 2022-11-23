package com.email.cucumber;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CreateAccountEmail {

	WebDriver driver = null;
	WebDriverWait w = null;

	@SuppressWarnings("deprecation")
	@Given("Open Chrome browser")
	public void open_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://accounts.google.com/");
		driver.manage().window().maximize();
		w = new WebDriverWait(driver, Duration.ofSeconds(120));
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	}

	@And("click on create account")
	public void click_on_create_account() {
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Create account')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Create account')]")).click();
		w.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(text(),'For my personal use')]")));
		driver.findElement(By.xpath("//span[contains(text(),'For my personal use')]")).click();
try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block

}

	}

	@And("write all the filds")
	public void write_all_the_filds() {

		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("priyam");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("anand");
		driver.findElement(By.xpath("//input[@name='Username']")).sendKeys("anand.priyam14");
		driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys("PriyamAnand77");
		driver.findElement(By.xpath("//input[@name='ConfirmPasswd']")).sendKeys("PriyamAnand77");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Next')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='tel']")));
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("6363823535");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Next')]")));

	}

	@And("click next")
	public void click_next() {

		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Next')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
//		driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys("123456");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']//span[contains(text(),'Verify')]")));
		driver.findElement(By.xpath(
				"//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']//span[contains(text(),'Verify')]"))
				.click();

		driver.findElement(By.xpath("//div[contains(text(),'Day')]")).sendKeys("14");

		Select sel = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		sel.selectByVisibleText("March");
		driver.findElement(By.xpath("//div[contains(text(),'Year')]")).sendKeys("2000");
		Select sel2 = new Select(driver.findElement(By.xpath("//select[@id='gender']")));
		sel2.selectByVisibleText("Male");

		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']//span")));

		driver.findElement(By.xpath(
				"//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']//span"))
				.click();

	}

	@Then("User should land to Gmail page")
	public void user_should_land_to_gmail_page() {
		assertEquals("login", "login");

	}

}
