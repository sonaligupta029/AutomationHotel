package org.treebo.app.pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.treebo.app.global.Libraries;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSFindBy;



public class HomePage extends Libraries {

	// @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	@iOSFindBy(accessibility = "search-button")
	// @AndroidFindBy(accessibility = "search-btn")
	@AndroidFindBy(accessibility = "search-button")
	private MobileElement search_button;

	@AndroidFindBy(accessibility = "destination-input-field")
	@iOSFindBy(accessibility = "yet to be")
	private MobileElement search_textbox;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Bangalore\")")
	@iOSFindBy(accessibility = "yet to be")
	private MobileElement bangalore_city;

	@HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	// @AndroidFindBy(accessibility="ic-menu-open")
	@iOSFindBy(accessibility = "icon-sw-nav")
	@AndroidFindBy(accessibility = "icon-sw-nav")
	private MobileElement menu_icon;

	@AndroidFindBy(accessibility = "login-button")
	@iOSFindBy(accessibility = "login-button")
	private MobileElement login_button;

	@AndroidFindBy(accessibility = "popular-city-button")
	@iOSFindBy(accessibility = "yet to be")
	private List<MobileElement> popularCities_list;

	@AndroidFindBy(accessibility = "checkin-date-field")
	@iOSFindBy(accessibility = "checkin-date-field")
	private MobileElement checkIn;

	@AndroidFindBy(accessibility = "checkout-date-field")
	@iOSFindBy(accessibility = "checkout-date-field")
	private MobileElement checkOut;

	@AndroidFindBy(accessibility = "yet to be")
	@iOSFindBy(accessibility = "yet to be")
	private MobileElement guests;

	@AndroidFindBy(accessibility = "enter-destination-field")
	@iOSFindBy(accessibility = "enter-destination-field")
	private MobileElement destination;

	@AndroidFindBy(accessibility = "yet to be")
	@iOSFindBy(accessibility = "yet to be")
	private MobileElement ourAssurance_block;

	@AndroidFindBy(accessibility = "yet to be")
	@iOSFindBy(accessibility = "yet to be")
	private MobileElement offers_block;

	@AndroidFindBy(accessibility = "yet to be")
	@iOSFindBy(accessibility = "yet to be")
	private MobileElement rewards_block;

	@AndroidFindBy(accessibility = "yet to be")
	@iOSFindBy(accessibility = "yet to be")
	private List<MobileElement> availableDates_list;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"View All\")")
	@iOSFindBy(accessibility = "yet to be")
	private MobileElement viewAllCities;

	@AndroidFindBy(accessibility = "popular-cities-list")
	private MobileElement popularCity_scrollableBlock;

	@AndroidFindBy(accessibility = "city-btn")
	private List<MobileElement> city_block;

	@AndroidFindBy(accessibility = "room-configuration-field")
	private MobileElement roomConfig_block;

	@AndroidFindBy(accessibility = "image-carousel")
	private MobileElement offerImages_block;

	@AndroidFindBy(accessibility = "room-config-text")
	private MobileElement roomConfig_text;

	@AndroidFindBy(accessibility = "logout-button")
	private MobileElement logout;

	@AndroidFindBy(accessibility = "contact-us")
	private MobileElement contact_us;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Clear All\")")
	@iOSFindBy(accessibility = "yet to be")
	private MobileElement clearAll_link;

	// @AndroidFindBy (uiAutomator = "new
	// UiSelector().className(\"android.widget.Button\").text(\"Continue
	// Booking\")")
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\")")
	private MobileElement continueBooking;
	
	@AndroidFindBy(accessibility="t-campaign-modal-skip")
	private MobileElement skipContactSync;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Quick Search\")")
	private MobileElement quickSearch_text;

	@AndroidFindBy(accessibility = "landing-page-content-container")
	private MobileElement scrollableContent;

	// private MobileDriver<MobileElement> driver;

	public void init() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public HomePage(MobileDriver<MobileElement> driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		init();
	}

	public HomePage clickSearchWithoutDestination() {
		waitElementToBeClickable(search_button);
		clickElement(search_button, driver);
		return this;
	}

	public HomePage enterDestination(String destination) {
		waitElementToBeClickable(search_textbox);
		sendkeysElement(search_textbox, destination, driver);
		waitForSeconds(2000);
		return this;
	}
	
	public HomePage enterDestinationByCharacter(String destination) {
		waitElementToBeClickable(search_textbox);
		sendkeysElementByCharacter(search_textbox, destination, 300, driver);
		return this;
	}

	public HomePage clearDestination() {
		waitElementToBeClickable(search_textbox);
		clearElement(search_textbox, driver);
		return this;
	}

	public HomePage clickBangalore() {
		waitElementToBeClickable(bangalore_city);
		clickElement(bangalore_city, driver);
		return this;
	}

	public SRP clickSearch() {
		clickSearchWithoutDestination();
		return new SRP(driver);
	}

	public HotelDetails clickSearchHotel() {
		clickSearchWithoutDestination();
		return new HotelDetails(driver);
	}

	public HomePage clickMenu() {
		waitElementToBeClickable(menu_icon);
		clickElement(menu_icon, driver);
		return this;
	}

	public Login clickLoginButton() {
		waitElementToBeClickable(login_button);
		clickElement(login_button, driver);
		return new Login(driver);
	}

	public HomePage clickDestination(String destination) {
		MobileElement element = null;
		int i = 0;
		while (i < retryCount) {
			try {
				if (driver instanceof AndroidDriver) {
					try {
						String locator = "new UiSelector().className(\"android.widget.TextView\").text(\"" + destination
								+ "\")";
						element = driver.findElement(MobileBy.AndroidUIAutomator(locator));
					} catch (NoSuchElementException e) {
						String locator = "new UiSelector().className(\"android.widget.TextView\").textStartsWith(\""
								+ destination + "\")";
						element = driver.findElement(MobileBy.AndroidUIAutomator(locator));
					}
					waitElementToBeClickable(element);
					clickElement(element, driver);
					return this;
				} else {
					throw new UnsupportedOperationException("Yet to be implemented in ios");
				}
			} catch (NoSuchElementException ex) {
				i++;
				init();
			}
		}

		return this;
	}

	public HomePage clickLocality() {
		MobileElement element = null;
		if (driver instanceof AndroidDriver) {
			try {
				String locator = "new UiSelector().className(\"android.widget.TextView\").text(\"" + "Locality" + "\")";
				element = driver.findElement(MobileBy.AndroidUIAutomator(locator));
			} catch (NoSuchElementException e) {
				String locator = "new UiSelector().className(\"android.widget.TextView\").textStartsWith(\""
						+ "Locality" + "\")";
				element = driver.findElement(MobileBy.AndroidUIAutomator(locator));
			}

		} else {
			throw new UnsupportedOperationException("Yet to be implemented in ios");
		}

		waitElementToBeClickable(element);
		clickElement(element, driver);
		return this;
	}

	public HomePage clickLandmark() {
		MobileElement element = null;
		if (driver instanceof AndroidDriver) {
			try {
				String locator = "new UiSelector().className(\"android.widget.TextView\").text(\"" + "Landmark" + "\")";
				element = driver.findElement(MobileBy.AndroidUIAutomator(locator));
			} catch (NoSuchElementException e) {
				String locator = "new UiSelector().className(\"android.widget.TextView\").textStartsWith(\""
						+ "Landmark" + "\")";
				element = driver.findElement(MobileBy.AndroidUIAutomator(locator));
			}

		} else {
			throw new UnsupportedOperationException("Yet to be implemented in ios");
		}

		waitElementToBeClickable(element);
		clickElement(element, driver);
		return this;
	}

	public SRP clickPopularCity(int index) {
		waitElementToBeClickable(popularCities_list.get(index));
		clickElement(popularCities_list.get(index), driver);
		return new SRP(driver);
	}

	public HomePage clickDestination() {
		waitElementToBeClickable(destination);
		clickElement(destination, driver);
		return this;
	}

	public CalenderModal clickCheckIn() {
		waitElementToBeClickable(checkIn);
		clickElement(checkIn, driver);
		return new CalenderModal(driver);
	}

	public CalenderModal clickCheckOut() {
		waitElementToBeClickable(checkOut);
		clickElement(checkOut, driver);
		return new CalenderModal(driver);
	}

	public HomePage clickGuests() {
		waitElementToBeClickable(guests);
		clickElement(guests, driver);
		return this;
	}

	public HomePage assertOurAssuranceDisplayed() {
		waitElementToBeVisible(ourAssurance_block, driver);
		Assert.assertTrue(ourAssurance_block.isDisplayed(), "Our assurance is not displayed");
		return this;
	}

	public HomePage assertOffersDisplayed() {
		waitElementToBeVisible(offers_block, driver);
		Assert.assertTrue(offers_block.isDisplayed(), "Offers is not displayed");
		return this;
	}

	public HomePage assertRewardsBannerDisplayed() {
		waitElementToBeVisible(rewards_block, driver);
		Assert.assertTrue(rewards_block.isDisplayed(), "Offers is not displayed");
		return this;
	}

	public Rewards clickTreeboRewardsBanner() {
		waitElementToBeClickable(rewards_block);
		clickElement(rewards_block, driver);
		return new Rewards(driver);
	}

	public HomePage clickAvailableDates(int index) {
		waitElementToBeClickable(availableDates_list.get(index));
		clickElement(availableDates_list.get(index), driver);
		return this;
	}

	public HomePage clickViewAllCities() {
		waitElementToBeClickable(search_button);
		swipeVerticallyDownTillElementDisplayed(driver, bangalore_city, 4);
		swipeElementToLeftTillDisplayed(driver, popularCity_scrollableBlock, viewAllCities, 4);
		clickElement(viewAllCities, driver);
		return this;
	}

	@Override
	public void swipeVerticallyDown(MobileDriver<MobileElement> driver) {
		Dimension dim = driver.manage().window().getSize();
		int x = 0;
		int y_initial = 0;
		if (isElementPresent(roomConfig_block, driver)) {
			waitElementToBeVisible(scrollableContent, driver);
			Point pt = scrollableContent.getCenter();
			x = pt.getX();
			y_initial = pt.getY();
		} else {
			x = (int) ((int) (dim.width) * (0.66));
			y_initial = (int) ((int) (dim.height) * (0.75));
		}
		int y_final = (int) ((int) (dim.height) * (0.40));
		TouchAction action = new TouchAction(driver);
		//action.tap(point(x, y_initial)).waitAction(waitOptions(Duration.ofSeconds(1))).moveTo(point(x, y_final)).release().perform();
		action.press(x, y_initial).waitAction(Duration.ofSeconds(1)).moveTo(x, y_final).release().perform();
	}

	public SRP clickPopularCity(String city) {
		waitElementToBeClickable(destination);
		waitForSeconds(2000);
		swipeVerticallyDownTillElementDisplayed(driver, bangalore_city, 2);
		int scrollTime = 1;
		int maxScrollTime = 4;
		while (scrollTime < maxScrollTime) {
			int index = getPopularCityIndex(city);
			if (index > -1) {
				clickElement(popularCities_list.get(index), driver);
				break;
			} else {
				swipeElementToLeft(driver, popularCity_scrollableBlock);
			}
			scrollTime++;
		}

		return new SRP(driver);
	}

	private int getPopularCityIndex(String city) {
		try {
			city = city.trim().toLowerCase();
			int size = popularCities_list.size();
			for (int i = 0; i < size; i++) {
				MobileElement element;
				if (driver instanceof AndroidDriver) {
					element = popularCities_list.get(i).findElementByClassName("android.widget.TextView");
				} else {
					throw new UnsupportedOperationException("Yet to be implemented in ios");
				}
				String text = getTextFromElement(element, driver);
				text = text.trim().toLowerCase();
				if (text.contains(city)) {
					// report.log(false, "Returning index : " + i + " for city",
					// true);
					return i;
				}
			}
			return -1;
		} catch (NoSuchElementException e) {
			return -1;
		}
	}

	public SRP clickCityFromViewAllOtherCities(String city) {
		waitForSeconds(2000);
		waitElementToBeClickable(city_block.get(0));
		int scrollTime = 1;
		int maxScrollTime = 15;
		while (scrollTime < maxScrollTime) {
			int index = getCityIndexFromViewAll(city_block, city);
			if (index > -1) {
				clickElement(city_block.get(index), driver);
				break;
			} else {
				swipeVerticallyDown(driver);
			}
			scrollTime++;
		}
		return new SRP(driver);
	}

	public SRP clickCityFromViewAllPopularCities(String city) {
		waitElementToBeClickable(popularCities_list.get(0));
		waitForSeconds(2000);
		int scrollTime = 1;
		int maxScrollTime = 15;
		while (scrollTime < maxScrollTime) {
			int index = getCityIndexFromViewAll(popularCities_list, city);
			if (index > -1) {
				clickElement(popularCities_list.get(index), driver);
				break;
			} else {
				swipeVerticallyDown(driver);
			}
			scrollTime++;
		}
		return new SRP(driver);
	}

	private int getCityIndexFromViewAll(List<MobileElement> elements, String city) {
		try {
			city = city.trim().toLowerCase();
			int size = elements.size();
			for (int i = 0; i < size; i++) {
				MobileElement element;
				if (driver instanceof AndroidDriver) {
					element = elements.get(i).findElementByClassName("android.widget.TextView");
				} else {
					throw new UnsupportedOperationException("Yet to be implemented in ios");
				}
				String text = getTextFromElement(element, driver);
				text = text.trim().toLowerCase();
				city = city.toLowerCase();
				if (text.contains(city)) {
					return i;
				}
			}
			return -1;
		} catch (NoSuchElementException e) {
			return -1;
		}
	}

	public RoomConfig clickRoomConfig() {
		waitElementToBeClickable(roomConfig_block);
		clickElement(roomConfig_block, driver);
		return new RoomConfig(driver);
	}

	public String getRoomConfigText() {
		waitElementToBeClickable(roomConfig_block);
		MobileElement element = null;
		if (driver instanceof AndroidDriver) {
			element = roomConfig_block.findElementByXPath("//android.widget.TextView[@index='1']");
		} else {
			throw new UnsupportedOperationException();
		}
		String text = getTextFromElement(element, driver);
		return text;
	}

	public int getNumberOfAdultsInRoomConfig() {
		String text = getRoomConfigText();
		int adults = -1;
		text = text.split("Adult")[0].trim();
		adults = Integer.parseInt(text);
		return adults;
	}

	public int getNumberOfKidsInRoomConfig() {
		String text = getRoomConfigText();
		int kids = -1;
		if (text.contains("Kid")) {
			text = text.split("Kid")[0].split(",")[1].trim();
			kids = Integer.parseInt(text);
		} else {
			return 0;
		}
		return kids;
	}

	public int getNumberOfRoomsInRoomConfig() {
		String text = getRoomConfigText();
		int rooms = -1;
		text = text.split("Room")[0].trim();
		text = text.replaceAll(".* ", "");
		rooms = Integer.parseInt(text);
		return rooms;
	}

	public HomePage assertNumberOfAdults(int expected) {
		int fetched = getNumberOfAdultsInRoomConfig();
		Assert.assertTrue(expected == fetched,
				"Number of adults expected : " + expected + ". But fetched : " + fetched);
		return this;
	}

	public HomePage assertNumberOfKids(int expected) {
		int fetched = getNumberOfKidsInRoomConfig();
		Assert.assertTrue(expected == fetched, "Number of kids expected : " + expected + ". But fetched : " + fetched);
		return this;
	}

	public HomePage assertNumberOfRooms(int expected) {
		int fetched = getNumberOfRoomsInRoomConfig();
		Assert.assertTrue(expected == fetched, "Number of rooms expected : " + expected + ". But fetched : " + fetched);
		return this;
	}

	public HomePage assertLogoutButtonPresent() {
		waitElementToBeVisible(contact_us, driver);
		Assert.assertTrue(logout.isDisplayed(), "Log out button is not displayed");
		return this;
	}

	public HomePage clickClearall() {
		waitElementToBeClickable(clearAll_link);
		clickElement(clearAll_link, driver);
		return this;
	}

	public HomePage clickContinueBooking() {
		waitElementToBeClickable(skipContactSync);
		waitForSeconds(2500);
		clickElement(skipContactSync, driver);
		waitForSeconds(1000);
		return this;
	}
	

}
