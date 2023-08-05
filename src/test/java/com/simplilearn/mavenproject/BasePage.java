package com.simplilearn.mavenproject;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	
	public ChromeDriver driver;
	
	@Before
	public void InitDriver()
	{
		System.setProperty("webdriver.chrome.driver","C:\\eclipse\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("http://www.w3schools.com/html/html_tables.asp");
	}
	
	@After
	public void TestCleanUp()
	{
		driver.close();
	}
	
	
}
