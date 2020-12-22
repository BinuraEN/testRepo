package com.test;


import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculatorTest extends Commands {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		
		//launch calc
		dc.setCapability("appPackage", "com.android.calculator2");
		dc.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url,dc);
		Thread.sleep(5000);
		
		//com.android.calculator2:id/digit_7
		WebElement num1 = driver.findElementById("com.android.calculator2:id/digit_7");
		num1.click();//click 7
		driver.findElementById("com.android.calculator2:id/op_add").click(); // click plus
		WebElement num2 = driver.findElementById("com.android.calculator2:id/digit_9");
		num2.click();//click 9
		driver.findElementById("com.android.calculator2:id/eq").click();//click equal
		
		WebElement result = driver.findElementById("com.android.calculator2:id/result");
		int expResult = Integer.parseInt(num1.getText()) + Integer.parseInt(num2.getText());
		if(Integer.parseInt(result.getText()) == expResult) {
			System.out.println("Test Passed :" + result.getText() );
		}else {
			System.out.println("Test Failed");
		}
		
		Thread.sleep(5000);
		driver.quit();
		
	}
}
