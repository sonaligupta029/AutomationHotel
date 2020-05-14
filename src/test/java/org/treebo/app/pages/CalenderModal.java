package org.treebo.app.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.treebo.app.global.Libraries;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class CalenderModal extends Libraries {

	@AndroidFindBy(accessibility = "stay-duration-text")
	private MobileElement stayDuration_text;

	@AndroidFindBy(accessibility = "t-dp-day-button-common")
	@iOSFindBy(accessibility = "yet to be")
	private List<MobileElement> dateEnabled_list;
	
	@AndroidFindBy (accessibility = "t-dp-day-button-checkoutAvailable")
	private List<MobileElement> checkoutEnabled_list;

	@AndroidFindBy(accessibility = "t-dp-month-header")
	private MobileElement month_text;

	@AndroidFindBy(accessibility = "t-dp-day-button-selected")
	private List<MobileElement> selectedDate_list;

	@Override
	public void init() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public CalenderModal(MobileDriver<MobileElement> driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		init();
	}

	public HomePage swipeDown() {
		int i = 0;
		while (i < retryCount) {
			try {
				waitElementToBeClickable(stayDuration_text);
				swipeVerticallyDown(driver);
				waitForSeconds(2000);
				return new HomePage(driver);
			} catch (StaleElementReferenceException e) {
				if (i < retryCount) {
					waitForSeconds(1000);
					init();
					continue;
				} else {
					throw e;
				}
			}
		}
		return null;
	}

	public int getNumberOfNights() {
		waitElementToBeVisible(stayDuration_text, driver);
		String text = getTextFromElement(stayDuration_text, driver);
		int nights = Integer.parseInt(text.split(" ")[0].trim());
		return nights;
	}

	public CalenderModal clickCheckinDateAfterSwipe() {
		swipeDown();
		swipeDown();
		waitElementToBeClickable(month_text);
		waitElementToBeClickable(dateEnabled_list.get(0));
		waitElementToBeClickable(dateEnabled_list.get(10));
		clickElement(dateEnabled_list.get(10), driver);
		return this;
	}

	public HomePage clickCheckOutDateAfterSwipe() {
		waitElementToBeClickable(checkoutEnabled_list.get(0));
		clickElement(checkoutEnabled_list.get(0), driver);
		return new HomePage(driver);
	}

	public CalenderModal clickCheckinDate(int daysFromToday) {
		int i = 0;
		while (true) {
			try {
				waitElementToBeClickable(month_text);
				waitElementToBeClickable(dateEnabled_list.get(0));
				waitElementToBeClickable(dateEnabled_list.get(daysFromToday));
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, daysFromToday);
				SimpleDateFormat sdf = new SimpleDateFormat("d");
				Date date = cal.getTime();
				String day = sdf.format(date);
				for (MobileElement enabled : dateEnabled_list) {
					MobileElement element = enabled.findElementByClassName("android.widget.TextView");
					String text = getTextFromElement(element, driver);
					if (text.equals(day)) {
						clickElement(element, driver);
						break;
					}
				}
				return new CalenderModal(driver);
			} catch (IndexOutOfBoundsException e) {
				if (i < 1) {
					i++;
					swipeDown();
					continue;
				} else {
					throw e;
				}
			}
		}
	}

	public HomePage clickCheckoutDate(int daysFromToday) {	
		waitElementToBeVisible(checkoutEnabled_list.get(0), driver);
		waitElementToBeClickable(checkoutEnabled_list.get(0));
		waitForSeconds(2000);
		clickElement(checkoutEnabled_list.get(0), driver);
		return new HomePage(driver);
	}
	
	
	public HomePage clickCheckoutDateForTesting() {	
		waitElementToBeVisible(checkoutEnabled_list.get(0), driver);
		waitForSeconds(2000);
		clickElement(checkoutEnabled_list.get(0), driver);
		return new HomePage(driver);
	}

}
