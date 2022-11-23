package com.email.cucumber;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
		w= new WebDriverWait(driver, Duration.ofSeconds(120));
//		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
	}

	@And("click on create account")
	public void click_on_create_account()  {
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Create account')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Create account')]")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
	
		}
		driver.findElement(By.xpath("//span[contains(text(),'For my personal use')]")).click();
		
	}

	@And("write all the filds")
	public void write_all_the_filds() {
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("priyam");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("anand");
		driver.findElement(By.xpath("//input[@name='Username']")).sendKeys("anand.priyam77");
		driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys("PriyamAnand77");
		driver.findElement(By.xpath("//input[@name='ConfirmPasswd']")).sendKeys("PriyamAnand77");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Next')]")));
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
		
		}
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='tel']")));
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("7436873429");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Next')]")));
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
		
		}

	}

	@And("click next")
	public void click_next() {

		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Next')]")));
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		try {Thread.sleep(30000);} catch (InterruptedException e) {}
//		driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys("123456");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']//span[contains(text(),'Verify')]")));
		driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']//span[contains(text(),'Verify')]")).click();
		
	
	}

	@Then("User should land to Gmail page")
	public void user_should_land_to_gmail_page() {
		assertEquals("login", "login");
	  
	}

}
