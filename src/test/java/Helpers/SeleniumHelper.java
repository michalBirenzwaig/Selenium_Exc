package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelper {

	public WebElement waitForElement(WebDriver driver, By locator, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, timeout);
	    return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
}
