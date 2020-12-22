package com.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class DialerTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		dc.setCapability(AndroidMobileCapabilityType.APPLICATION_NAME, "Phone");
		
		//launch dialer
		dc.setCapability("appPackage", "com.google.android.dialer");
		dc.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url,dc);
		Thread.sleep(5000);
		
		//click dialer button
		driver.findElementById("com.google.android.dialer:id/dialpad_fab").click();
		Thread.sleep(2000);
		//dial 0716135121
		driver.findElementById("com.google.android.dialer:id/zero").click();
		driver.findElementById("com.google.android.dialer:id/seven").click();
		driver.findElementById("com.google.android.dialer:id/one").click();
		driver.findElementById("com.google.android.dialer:id/six").click();
		driver.findElementById("com.google.android.dialer:id/one").click();
		driver.findElementById("com.google.android.dialer:id/three").click();
		driver.findElementById("com.google.android.dialer:id/five").click();
		driver.findElementById("com.google.android.dialer:id/one").click();
		driver.findElementById("com.google.android.dialer:id/two").click();
		driver.findElementById("com.google.android.dialer:id/one").click();
		
		Thread.sleep(2000);
		driver.findElementById("com.google.android.dialer:id/dialpad_voice_call_button").click();
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
