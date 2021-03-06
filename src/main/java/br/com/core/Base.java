package br.com.core;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Base {
	
	public static ChromeDriver driver;
	
	public static ChromeDriver init() {
		System.setProperty("webdriver.chrome.driver", "./resources/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 return driver;
	}
	
	@Before
	public void start() {
		driver = init();
	}
	
	@After
	public void end() {
		if(driver != null) {
			driver.close();
		}
	}
}
