package org.treebo.app.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.treebo.app.global.Libraries;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Payment extends Libraries {
	
	@AndroidFindBy(accessibility = "debit-credit-card-button")
	private MobileElement debitCard_button;

	@AndroidFindBy(accessibility = "pay-at-hotel-section")
	private MobileElement payAtHotel_section;

	@AndroidFindBy(accessibility = "pay-at-hotel-proceed-button")
	private MobileElement payAtHotelProceed_button;
	
	@AndroidFindBy(accessibility = "prepaid-payment-options-section")
	private MobileElement prepaidPayment_section;

	@Override
	public void init() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	public Payment(MobileDriver<MobileElement> driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		init();
	}
	
	
	public Payment assertPayAtHotelSectionDisplayed() {
		waitElementToBeVisible(payAtHotel_section, driver);
		Assert.assertTrue(payAtHotel_section.isDisplayed(),
				"Pay at Hotel Section is not displayed in Itinerary Step 3");
		return this;
	}

	public Payment clickPayAtHotelSection() {
		waitElementToBeVisible(payAtHotel_section, driver);
		clickElement(payAtHotel_section, driver);
		return this;
	}

	public Payment clickPayAtHotelProceedButton() {
		swipeVerticallyDownTillElementDisplayed(driver, payAtHotelProceed_button, 3);
		waitElementToBeVisible(payAtHotelProceed_button, driver);
		clickElement(payAtHotelProceed_button, driver);
		return this;
	}
	
	public Confirmation clickPayAtHotelProceedButtonWithoutOtp() {
		clickPayAtHotelProceedButton();
		return new Confirmation(driver);
	}

	public Payment assertPrepaidPaymentSectionDisplayed() {
		waitElementToBeVisible(prepaidPayment_section, driver);
		Assert.assertTrue(prepaidPayment_section.isDisplayed(),
				"Prepeaid Payment Section is not displayed in Itinerary Step 3");
		return this;
	}
}
