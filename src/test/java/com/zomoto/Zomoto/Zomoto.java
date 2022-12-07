package com.zomoto.Zomoto;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.base.Baseclass;

public class Zomoto extends Baseclass {

	public static void browser() throws InterruptedException {
		browserLaunch();
		launchUrl("https://www.zomato.com/");
		String search ="A2B";
		int count = 0;
		WebElement searchTab = webElement("//input[@placeholder='Search for restaurant, cuisine or a dish']");
		userInput(searchTab, "A2B");
		clickOnElement(searchTab);
		Thread.sleep(2000);
		List<WebElement> searchlist = webElements("//div[@class='sc-cgzHhG fUOrqs']//descendant::p[@class='sc-1hez2tp-0 sc-dlyikq jjaxIX']");
		
		for (WebElement listOfHotels : searchlist) {
			Thread.sleep(1000);
			String hotelName = listOfHotels.getText();
			System.out.println(hotelName);
		if (hotelName.contains(search)) {
			count++;
		}
		}
		System.out.println("================================================");
		System.out.println("No Of Matches: "+count);
		
		
		
		
		
		
		
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		browser();
	}

}
