package com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class ScrollTest extends Commands {
	@Test
	public void test_scroll() throws MalformedURLException, InterruptedException {
			DesiredCapabilities dc = new DesiredCapabilities();
		  dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		  dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		  dc.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"//apk//Advanced RecyclerView Examples_v1.0.0_apkpure.com.apk");
		  dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		  dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.h6ah4i.android.example.advrecyclerview");
		  dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".launcher.MainActivity");
		  dc.setCapability(MobileCapabilityType.NO_RESET, true);
		  
		  URL url = new URL("http://127.0.0.1:4723/wd/hub");
		  
		  AppiumDriver<MobileElement> driver = new AppiumDriver<MobileElement>(url,dc);
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  
		  Thread.sleep(2000);
		  click(driver,"//android.widget.TextView[@text='ADVANCED']");
		  click(driver,"//android.widget.Button[@text='DRAGGABLE + SWIPEABLE']");
		  
		  Thread.sleep(2000);
		  
		  List<MobileElement> list = driver.findElements(By.xpath("//android.widget.TextView"));
		  for(MobileElement e : list) {
			  System.out.println(e.getAttribute("text"));
		  }
		  //1st option
		  MobileElement listItem = (MobileElement)driver.findElement(
				  MobileBy.AndroidUIAutomator(
						  "new UiScrollable(new UiSelector()).scrollIntoView("
						  + "new UiSelector().text(\"25 - Z\"));"));
		  System.out.println(listItem.getLocation());
		  listItem.click();
		  
		  Thread.sleep(3000);
		  
		  
		  
	}
}
