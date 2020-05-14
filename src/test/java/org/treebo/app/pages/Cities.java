package org.treebo.app.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Cities {
	

	private MobileDriver<MobileElement> driver;

	public Cities(MobileDriver<MobileElement> driver) {
		try {
			if (driver instanceof AndroidDriver){
				this.driver = (AndroidDriver<MobileElement>)driver;
			} else if (driver instanceof IOSDriver) {
				this.driver = (IOSDriver<MobileElement>)driver;
			}
			this.driver = driver;
			PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HomePage clickCity(String city) {
		driver.findElement(MobileBy.AccessibilityId(""));
		return new HomePage(driver);
	}

}
