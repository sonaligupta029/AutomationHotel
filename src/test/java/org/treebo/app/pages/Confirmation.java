package org.treebo.app.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.treebo.app.global.Libraries;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Confirmation extends Libraries {

	@AndroidFindBy(accessibility = "booking-id-text")
	private MobileElement trbId_text;

	@AndroidFindBy(accessibility = "hotel-name-text")
	private MobileElement hotelName_text;

	@AndroidFindBy(accessibility = "booking-checkin-date-text")
	private MobileElement checkinDate_text;

	@AndroidFindBy(accessibility = "booking-no-of-nights-text")
	private MobileElement numberOfNights_text;

	@AndroidFindBy(accessibility = "booking-checkout-date-text")
	private MobileElement checkoutDate_text;

	@AndroidFindBy(accessibility = "booking-guest-name-text")
	private MobileElement primaryTravellerName_text;

	@AndroidFindBy(accessibility = "treebo-points-text")
	private MobileElement treeboPoints_text;

	@AndroidFindBy(accessibility = "booking-total-adults-children-text")
	private MobileElement guestConfig_text;

	@AndroidFindBy(accessibility = "booking-room-info-text")
	private MobileElement roomConfig_text;

	@AndroidFindBy(accessibility = "total-payable-amount-text")
	private MobileElement payableAmount_text;

	@AndroidFindBy(accessibility = "rate-plan-tag")
	private MobileElement ratePlan_tag;

	@AndroidFindBy(accessibility = "back-to-home-button")
	private MobileElement backToHome_button;

	@AndroidFindBy(accessibility = "part-pay-button")
	private MobileElement partPay_button;

	@AndroidFindBy (accessibility = "t-close-feedback-sheet-button")
	private MobileElement closeExperienceRateModal;
	
	private MobileDriver<MobileElement> driver;
	
	

	private String guestConfig = null;
	private String roomConfig = null;
	
	@Override
	public void init() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public Confirmation(MobileDriver<MobileElement> driver) {
		this.driver = driver;
		init();
	}

	public String getTrbId() {
		waitElementToBeVisible(trbId_text, driver);
		String text = getTextFromElement(trbId_text, driver);
		text = text.split(": ")[1];
		return text;
	}
	
	public Confirmation printTrb(){
		String trb = getTrbId();
		System.out.println("TRB id is : " + trb);
		return this;
	}

	public String getHotelName() {
		waitElementToBeVisible(hotelName_text, driver);
		String text = getTextFromElement(hotelName_text, driver);
		return text;
	}
	
	public Confirmation clickExperienceRateModal(){
		waitElementToBeClickable(closeExperienceRateModal);
		waitForSeconds(1000);
		clickElement(closeExperienceRateModal, driver);
		return this;
	}

	public Date getCheckInDate() {
		waitElementToBeVisible(checkinDate_text, driver);
		String text = getTextFromElement(checkinDate_text, driver);
		text = text + " 2018";
		SimpleDateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy");
		Date date = null;
		try {
			date = df.parse(text);
		} catch (ParseException e) {
		}
		return date;
	}

	public Date getCheckOutDate() {
		waitElementToBeVisible(checkoutDate_text, driver);
		String text = getTextFromElement(checkoutDate_text, driver);
		text = text + " 2018";
		SimpleDateFormat df = new SimpleDateFormat("EEE, dd MMM yyyy");
		Date date = null;
		try {
			date = df.parse(text);
		} catch (ParseException e) {
		}
		return date;
	}

	public String getPrimaryTravellerName() {
		waitElementToBeVisible(primaryTravellerName_text, driver);
		String text = getTextFromElement(primaryTravellerName_text, driver);
		return text;
	}

	public String getTreeboPointsText() {
		waitElementToBeVisible(treeboPoints_text, driver);
		String text = getTextFromElement(treeboPoints_text, driver);
		return text;
	}

	public String getGuestConfig() {
		swipeVerticallyDownTillElementDisplayed(driver, guestConfig_text, 3);
		waitElementToBeVisible(guestConfig_text, driver);
		guestConfig = getTextFromElement(guestConfig_text, driver);
		return guestConfig;
	}

	public String getRoomConfig() {
		swipeVerticallyDownTillElementDisplayed(driver, roomConfig_text, 3);
		waitElementToBeVisible(roomConfig_text, driver);
		roomConfig = getTextFromElement(roomConfig_text, driver);
		return roomConfig;
	}

	public int getNumberOfRooms() {
		if (roomConfig == null || roomConfig.isEmpty()) {
			getRoomConfig();
		}
		String text = roomConfig.split("x")[0].trim();
		int rooms = Integer.parseInt(text);
		return rooms;
	}

	public String getRoomType() {
		if (roomConfig == null || roomConfig.isEmpty()) {
			getRoomConfig();
		}
		String text = roomConfig.split("x")[1].trim();
		return text;
	}

	public int getNumberOfAdults() {
		if (guestConfig == null || guestConfig.isEmpty()) {
			getGuestConfig();
		}
		String text = guestConfig.split("Adult")[0].trim();
		int adults = Integer.parseInt(text);
		return adults;
	}

	public int getNumberOfKids() {
		if (guestConfig == null || guestConfig.isEmpty()) {
			getGuestConfig();
		}
		String text = guestConfig.split("Kid")[0].trim().split(",")[1].trim();
		int kids = Integer.parseInt(text);
		return kids;
	}

	public String getPayableAmount() {
		waitElementToBeVisible(payableAmount_text, driver);
		String text = getTextFromElement(payableAmount_text, driver);
		return text;
	}

	public String getRatePlan() {
		waitElementToBeVisible(ratePlan_tag, driver);
		String text = getTextFromElement(ratePlan_tag, driver);
		return text;
	}

	public HomePage clickBackToHome() {
		swipeVerticallyDownTillElementDisplayed(driver, backToHome_button, 5);
		waitElementToBeClickable(backToHome_button);
		clickElement(backToHome_button, driver);
		return new HomePage(driver);
	}

	public Confirmation clickPartPay() {
		waitElementToBeClickable(partPay_button);
		clickElement(partPay_button, driver);
		return this;
	}

	public Confirmation assertHotelName(String expected) {
		String fetched = getHotelName().trim().toLowerCase();
		Assert.assertTrue(expected.toLowerCase().contains(fetched),
				"Fetched hotel name : " + fetched + ". But expected : " + expected);
		return this;
	}

	public Confirmation assertCheckinDate(Date expected) {
		Date fetched = getCheckInDate();
		Assert.assertTrue(expected.equals(fetched),
				"Fetched check in date : " + fetched + ". But expected : " + expected);
		return this;
	}

	public Confirmation assertCheckOutDate(Date expected) {
		Date fetched = getCheckOutDate();
		Assert.assertTrue(expected.equals(fetched),
				"Fetched check out date : " + fetched + ". But expected : " + expected);
		return this;
	}

	public int getNumberOfNights() {
		waitElementToBeVisible(numberOfNights_text, driver);
		String text = getTextFromElement(numberOfNights_text, driver);
		text = text.split(" ")[0];
		int nights = Integer.parseInt(text);
		return nights;
	}

	public Confirmation assertNumberOfNights(int expected) {
		int fetched = getNumberOfNights();
		Assert.assertTrue(expected == fetched,
				"Number of nights fetched is : " + fetched + ". But expected : " + expected);
		return this;
	}

	public Confirmation assertGuestConfig(int expectedAdults, int expectedKids) {
		assertNumberOfAdults(expectedAdults);
		assertNumberOfKids(expectedKids);
		return this;
	}
	
	public Confirmation assertNumberOfAdults(int expectedAdults) {
		int fetchedAdults = getNumberOfAdults();
		Assert.assertTrue(fetchedAdults == expectedAdults, "Number of adults expected : " + expectedAdults + ". But fetched : " + fetchedAdults);
		return this;
	}
	
	public Confirmation assertNumberOfKids(int expectedKids) {
		int fetchedKids = getNumberOfKids();
		Assert.assertTrue(fetchedKids == expectedKids, "Number of kids expected : " + expectedKids + ". But fetched : " + fetchedKids);
		return this;
	}
	
	public Confirmation assertNumberOfRooms(int expectedNumberOfRooms) {
		int fetched = getNumberOfRooms();
		Assert.assertTrue(fetched ==  expectedNumberOfRooms, "Expected number of rooms is : " + expectedNumberOfRooms + ". But fetched : " + fetched);
		return this;
	}
	

}
