package com.test;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Commands {
	
	public void click(AppiumDriver<MobileElement> driver, String Locator) {
		MobileElement element = driver.findElement(By.xpath(Locator));
		element.click();
	}
}
