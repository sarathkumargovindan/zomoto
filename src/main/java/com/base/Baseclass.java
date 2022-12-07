package com.base;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Baseclass {
	public static WebDriver driver = null;

	public static void userInput(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static WebDriver browserLaunch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sriva\\eclipse-workspace\\Amazon\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public static void launchUrl(String Value) {
		driver.get(Value);

	}

	public static Dimension size(WebElement element) {
		Dimension size = element.getSize();
		return size;
	}

	public static WebElement webElement(String value) {
		WebElement element = driver.findElement(By.xpath(value));
		return element;
	}

	public static List<WebElement> webElements(String path) {
		List<WebElement> Elements = driver.findElements(By.xpath(path));

		return Elements;
	}

	public static void clickOnElement(WebElement element) {
		element.click();

	}

	public static void implicitywait() {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	public static String getTextOnElement(WebElement element) {
		String text = element.getText();
		return text;

	}

	public static void dropdown(WebElement element, String options, String value) {
		Select s = new Select(element);
		if (options.equalsIgnoreCase("value")) {
			s.selectByValue(value);

		} else if (options.equalsIgnoreCase("text")) {
			s.selectByVisibleText(value);

		} else if (options.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(value);
			s.selectByIndex(index);
		}

	}

	public static List<WebElement> dropdownoptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		return options;
	}

	public static void draganddrop(WebElement drag, WebElement drop) {
		Actions a = new Actions(driver);
		a.dragAndDrop(drag, drop).perform();
	}

	public static void movetoElement(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element);
	}

	public static void doubleclickonElement(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element);
	}

	public static void rightOnElement(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element);
	}

	public static void clickonElementjs(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void scrollbyheight(int value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,value)", "");
	}

	public static void scrollbyElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	public static void close() {
		driver.close();
	}

	public static void capture(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File from = ts.getScreenshotAs(OutputType.FILE);
		File to = new File("C:\\Users\\sriva\\eclipse-workspace\\Amazon\\screenshot\\" + name + ".png");
		FileHandler.copy(from, to);
	}

	public static void popupAlert(String value) {
		if (value.equalsIgnoreCase("ok")) {
			driver.switchTo().alert().accept();

		} else if (value.equalsIgnoreCase("cancel")) {
			driver.switchTo().alert().dismiss();

		}
	}

	public static void frameswitch(WebElement Element) {
		driver.switchTo().frame(Element);

	}

	public static void quit() {
		driver.quit();
	}

}
