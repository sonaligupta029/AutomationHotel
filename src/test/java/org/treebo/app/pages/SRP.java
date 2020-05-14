package org.treebo.app.pages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.treebo.app.global.Libraries;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class SRP extends Libraries {

	@AndroidFindBy(accessibility = "book-button")
	private MobileElement quickBook_button;

	@AndroidFindBy(accessibility = "sold-out-text")
	private MobileElement soldOut_text;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"LOGIN\")")
	private MobileElement login_button;

	@AndroidFindBy(accessibility = "search-result-item")
	private MobileElement clickAvailableTreebo_button;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"\")")
	private MobileElement backFromSRP_button;

	@AndroidFindBy(accessibility = "filter-button")
	private MobileElement filter_button;

	@AndroidFindBy(accessibility = "search-page-header")
	private MobileElement searchpage_header;

	@AndroidFindBy(accessibility = "icon-sw-nav")
	private MobileElement back_arrow;

	@AndroidFindBy(accessibility = "hotel-name-text")
	private List<MobileElement> hotelNames_list;

	@AndroidFindBy(accessibility = "destination-text")
	private MobileElement locationHeader_text;

	@AndroidFindBy(accessibility = "sort-button")
	private MobileElement sort_button;

	@AndroidFindBy(accessibility = "enter-destination-field")
	@iOSFindBy(accessibility = "enter-destination-field")
	private MobileElement destination;

	@AndroidFindBy(accessibility = "destination-input-field")
	@iOSFindBy(accessibility = "yet to be")
	private MobileElement search_textbox;

	@HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	@iOSFindBy(accessibility = "search-button")
	// @AndroidFindBy(accessibility = "search-btn")
	@AndroidFindBy(accessibility = "search-button")
	private MobileElement search_button;

	@AndroidFindBy(accessibility = "title-Price")
	private MobileElement price_title;

	@AndroidFindBy(accessibility = "title-Locality")
	private MobileElement locality_title;

	@AndroidFindBy(accessibility = "apply-filter-button")
	private MobileElement applyFilter_button;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc,'item')]")
	private List<MobileElement> filters_list;

	@AndroidFindBy(accessibility = "hotel-price-text")
	private List<MobileElement> hotelPrices_list;

	@AndroidFindBy(accessibility = "icon-header-right")
	private MobileElement clearFilter_link;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Price - Low to High\")")
	private MobileElement price_low_to_high;

	@AndroidFindBy(accessibility = "homestay-properties-filter")
	private MobileElement homeStay_filter;

	@AndroidFindBy(accessibility = "hotel-properties-filter")
	private MobileElement hotel_filter;

	@AndroidFindBy(accessibility = "all-properties-filter")
	private MobileElement allPropertiesFilter;

	@AndroidFindBy(accessibility = "property-type-tag")
	private List<MobileElement> propertyType_tag;

	@AndroidFindBy(accessibility = "couple-friendly-tag")
	private List<MobileElement> coupleFriendly_tag;

	private MobileDriver<MobileElement> driver;

	public void init() {
		// PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public SRP(MobileDriver<MobileElement> driver) {
		this.driver = driver;
		init();
	}

	public HotelDetails clickQuickBook() {
		waitElementToBeClickable(quickBook_button);
		clickElement(quickBook_button, driver);
		// driver.findElement(MobileBy.AndroidUIAutomator(""));
		return new HotelDetails(driver);
	}

	public HotelDetails clickSoldOutHotel() {
		waitElementToBeClickable(hotelNames_list.get(0));
		// waitForSeconds(3000);
		swipeVerticallyDownTillElementDisplayed(driver, soldOut_text, 40);
		waitElementToBeClickable(soldOut_text);
		clickElement(soldOut_text, driver);
		return new HotelDetails(driver);
	}

	public Login clickLoginButton() {
		waitElementToBeClickable(login_button);
		clickElement(login_button, driver);
		return new Login(driver);
	}

	public HotelDetails clickAvailableTreebo() {
		waitElementToBeClickable(clickAvailableTreebo_button);
		waitTillQuickbookDisplayed();
		clickElement(clickAvailableTreebo_button, driver);

		return new HotelDetails(driver);
	}

	public SRP assertBackFromSRPButtonDisplayed() {
		waitElementToBeClickable(backFromSRP_button);
		Assert.assertTrue(backFromSRP_button.isDisplayed(), "Back button is not displayed in the SRP page's header");
		return this;
	}

	public SRP clickBackFromSRPButton() {
		waitElementToBeClickable(backFromSRP_button);
		clickElement(backFromSRP_button, driver);
		return this;
	}

	public SRP assertFilterButtonDisplayed() {
		waitElementToBeClickable(filter_button);
		Assert.assertTrue(filter_button.isDisplayed(), "Fiter button is not present in the SRP page");
		return this;
	}

	public SRP clickFilterButton() {
		waitElementToBeClickable(filter_button);
		// This wait is so that auto apply toast message disappears
		waitForSeconds(7000);
		clickElement(filter_button, driver);
		return this;
	}

	public HomePage clickBackArrow() {
		waitElementToBeClickable(back_arrow);
		clickElement(back_arrow, driver);
		return new HomePage(driver);
	}

	public String getHotelNameWithIndex(int index) {
		waitElementToBeClickable(hotelNames_list.get(index));
		String name = getTextFromElement(hotelNames_list.get(index), driver);
		System.out.println("Available hotel name : " + name);
		return name;
	}

	public String getHotelNameWithIndexForSoldOut(int index) {
		int i = 0;
		while (i < retryCount) {
			try {
				waitElementToBeVisible(hotelNames_list.get(index), driver);
				String name = getTextFromElement(hotelNames_list.get(index), driver);
				System.out.println("Available hotel name : " + name);
				return name;
			} catch (StaleElementReferenceException e) {
				if (i < retryCount) {
					waitForSeconds(1000);
					init();
					i++;
					continue;
				} else {
					throw e;
				}
			} catch (TimeoutException ex) {
				if (i < retryCount) {
					waitForSeconds(1000);
					init();
					i++;
					continue;
				} else {
					throw ex;
				}
			}
		}
		return null;
	}

	public SRP assertHotelNameWithIndex(int index, String expectedHotelName) {
		String fetched = getHotelNameWithIndex(index);
		Assert.assertTrue(fetched.toLowerCase().trim().equals(expectedHotelName.trim().toLowerCase()),
				"Fetched hotel name is : " + fetched + ". But expected " + expectedHotelName);
		return this;
	}

	public String getLocationFromHeader() {
		int i = 0;
		String location = null;
		while (true) {
			try {
				waitElementToBeClickable(locationHeader_text);
				location = getTextFromElement(locationHeader_text, driver).trim();
				break;
			} catch (WebDriverException e) {
				if (i < retryCount) {
					i++;
					waitForSeconds(1000);
					continue;
				} else {
					throw e;
				}
			}
		}
		return location;
	}

	public SRP assertLocationFromHeader(String expectedLocation) {
		expectedLocation = expectedLocation.trim().toLowerCase();
		String fetched = getLocationFromHeader().trim().toLowerCase();
		Assert.assertTrue(fetched.contains(expectedLocation),
				"Fetched location : " + fetched + ". But expected : " + expectedLocation);
		return this;
	}

	public SRP clickSortButton() {
		waitElementToBeClickable(sort_button);
		waitElementToBeClickable(quickBook_button);
		// This wait is so that auto apply toast message disappears.
		waitForSeconds(7000);
		clickElement(sort_button, driver);
		System.out.println("Sort button is clicked");
		return this;
	}

	public SRP clickPriceLowToHigh() {
		waitElementToBeClickable(price_low_to_high);
		clickElement(price_low_to_high, driver);
		return this;
	}

	public SRP clickLocationHeader() {
		waitElementToBeClickable(locationHeader_text);
		clickElement(locationHeader_text, driver);
		return this;
	}

	public SRP clickDestination() {
		waitElementToBeClickable(destination);
		clickElement(destination, driver);
		return this;
	}

	public SRP enterDestination(String destination) {
		waitElementToBeClickable(search_textbox);
		sendkeysElement(search_textbox, destination, driver);
		return this;
	}

	public SRP clearDestination() {
		waitElementToBeClickable(search_textbox);
		clearElement(search_textbox, driver);
		return this;
	}

	public SRP clickDestination(String destination) {
		MobileElement element = null;
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

		} else {
			throw new UnsupportedOperationException("Yet to be implemented in ios");
		}

		waitElementToBeClickable(element);
		clickElement(element, driver);
		return this;
	}

	public SRP clickSearch() {
		waitElementToBeClickable(search_button);
		clickElement(search_button, driver);
		return this;
	}

	public SRP clickFilterWithIndex(int index) {
		waitElementToBeClickable(filters_list.get(index));
		clickElement(filters_list.get(index), driver);
		return this;
	}

	public SRP clickApplyFilter() {
		waitElementToBeClickable(applyFilter_button);
		clickElement(applyFilter_button, driver);
		return this;
	}

	public SRP clickClearFilter() {
		waitElementToBeClickable(clearFilter_link);
		clickElement(clearFilter_link, driver);
		return this;
	}

	public String getFilterText(int index) {
		System.out.println("Filter index : " + index);
		waitElementToBeVisible(filters_list.get(index), driver);
		MobileElement element = null;
		if (driver instanceof AndroidDriver) {
			element = filters_list.get(index).findElementByClassName("android.widget.TextView");
		} else {
			throw new UnsupportedOperationException();
		}
		String text = getTextFromElement(element, driver);
		return text;
	}

	public int getMaximumRangeOfFilter(int index) {
		String text = getFilterText(index);
		int max = Integer.parseInt(text.split("-")[1].trim().split("₹")[1].trim());
		System.out.println("Maximum : " + max);
		return max;
	}

	public int getMinimumRangeOfFilter(int index) {
		String text = getFilterText(index);
		System.out.println("Text: " + text);
		int min = Integer.parseInt(text.split("-")[0].trim().split("₹")[1].trim());
		System.out.println("Minimum : " + min);
		return min;
	}

	public int getHotelPrice(int index) throws Exception {
		int i = 0;
		while (true) {
			try {
				waitElementToBeVisible(hotelPrices_list.get(index), driver);
				waitElementToBeClickable(quickBook_button);
				String text = getTextFromElement(hotelPrices_list.get(index), driver);
				int price = Integer.parseInt(text.split("₹")[1].trim());
				return price;
			} catch (WebDriverException e) {
				if (i < retryCount) {
					waitForSeconds(1000);
					init();
					i++;
					System.out.println("c");
					continue;
				} else {
					throw e;
				}
			}
		}
	}

	public SRP assertPriceFilters() throws Exception {
		for (int i = 1; i < 4; i++) {
			clickFilterButton();
			int min = getMinimumRangeOfFilter(i);
			int max = getMaximumRangeOfFilter(i);
			clickClearFilter();
			clickFilterWithIndex(i);
			clickApplyFilter();
			try {
				waitElementToBeVisible(hotelPrices_list.get(0), driver);
			} catch (IndexOutOfBoundsException e) {
				continue;
			}

			int numberOfHotels = hotelPrices_list.size();
			int maxSwipeNumber = 5;
			for (int swipe = 0; swipe <= maxSwipeNumber; swipe++) {
				for (int j = 0; j < numberOfHotels; j++) {
					int price = getHotelPrice(j);
					Assert.assertTrue(isNumberBetweenSpecifiedRange(price, max, min),
							"Max filter : " + max + ". Minimum filter : " + min + ". But hotel price : " + price);
				}
				swipeVerticallyDown(driver);
			}
		}
		return this;
	}

	public SRP assertHotelSortedByPrice() throws Exception {
		// int maxSwipeNumber = 35;
		waitElementToBeClickable(quickBook_button);
		int previousPrice = 0;
		do {
			int numberOfHotels = hotelPrices_list.size();
			if (numberOfHotels == 0) {
				break;
			}
			int presentPrice;
			for (int i = 0; i < numberOfHotels; i++) {
				presentPrice = getHotelPrice(i);
				Assert.assertTrue(presentPrice >= previousPrice, presentPrice + " is coming after : " + previousPrice);
				previousPrice = presentPrice;
			}
			// swipeVerticallyDown(driver);
		} while (!isSwippedTillBottom());
		return this;
	}

	public SRP assertSRPPageDisplayed() {
		waitElementToBeVisible(searchpage_header, driver);
		Assert.assertTrue(searchpage_header.isDisplayed(), "Search pae is not displayed");
		return this;
	}

	public SRP assertCityNameWithHotelDetailsCityName(String cityname) {
		waitElementToBeVisible(locationHeader_text, driver);
		String cityName = getTextFromElement(locationHeader_text, driver).trim().toLowerCase();
		// String CityName = destination_text.getText().trim().toLowerCase();
		Assert.assertTrue(cityName.equals(cityname.toLowerCase()),
				"Expected HotelName is :" + cityname + "But displaying Hotel Name is :" + cityName);
		return this;
	}

	public SRP assertSoldOutAtBottom() {
		waitElementToBeClickable(quickBook_button);
		try {
			swipeFastVerticallyDownTillElementDisplayed(driver, soldOut_text, 40);
		} catch (NoSuchElementException e) {
			return this;
		}
		while (!isSwippedTillBottom()) {
			try {
				Assert.assertFalse(quickBook_button.isDisplayed(),
						"Quick book button is displayed after sold out hotel");
			} catch (NoSuchElementException e) {
			}
		}
		return this;
	}

	private boolean isSwippedTillBottom() {
		int i = 0;
		int j = 0;
		while (true) {
			try {
				waitElementToBeClickable(hotelNames_list.get(0));
				Point p_intial = getCenterOfElement(hotelNames_list.get(0), driver);
				String name_initial = getHotelNameWithIndexForSoldOut(0);
				swipeVerticallyDown(driver);
				waitForSeconds(600);
				Point p_final = null;
				try {
					p_final = getCenterOfElement(hotelNames_list.get(0), driver);
				} catch (NullPointerException | IndexOutOfBoundsException | WebDriverException ex) {
					if (j < 2) {
						waitForSeconds(500);
						j++;
						continue;
					} else {
						throw ex;
					}
				}
				j = 0;
				p_final = getCenterOfElement(hotelNames_list.get(0), driver);
				String name_final = getHotelNameWithIndexForSoldOut(0);
				if (p_intial.equals(p_final) && name_initial.equals(name_final)) {
					return true;
				} else {
					return false;
				}
			} catch (WebDriverException e) {
				if (i < retryCount) {
					waitForSeconds(1000);
					init();
					i++;
					System.out.println("Stale element exception while cheking swipped till bottom");
					continue;
				} else {
					throw e;
				}
			}
		}
	}

	public SRP waitTillQuickbookDisplayed() {
		waitElementToBeClickable(quickBook_button);
		return this;
	}

	public SRP waitTillSoldoutDisplayed() {
		waitElementToBeClickable(soldOut_text);
		return this;
	}

	public SRP clickHomestayFilter() {
		waitElementToBeClickable(quickBook_button);
		waitElementToBeClickable(homeStay_filter);
		clickElement(homeStay_filter, driver);
		waitForSeconds(2000);
		waitElementToBeClickable(hotel_filter);
		return new SRP(driver);
	}

	public SRP clickHotelFilter() {
		waitElementToBeClickable(quickBook_button);
		waitElementToBeClickable(hotel_filter);
		clickElement(hotel_filter, driver);
		waitForSeconds(2000);
		waitElementToBeClickable(homeStay_filter);
		return new SRP(driver);
	}

	public SRP assertHomeStaysDisplayed() {
		do {
			int numberOfHotels = propertyType_tag.size();
			if (numberOfHotels == 0) {
				break;
			}
			checkWithinPage: for (int i = 0; i < numberOfHotels; i++) {
				int j = 0;
				retry: while (j < 2) {
					try {
						String expectedText = "HOMESTAY";
						String fetched = getTextFromElement(
								propertyType_tag.get(i).findElementByClassName("android.widget.TextView"), driver);
						Assert.assertTrue(expectedText.equals(fetched),
								"Expected tag is : " + expectedText + " But fetched is : " + fetched);
						j = 0;
						break checkWithinPage;
					} catch (WebDriverException e) {
						if (j < 2) {
							waitForSeconds(1000);
							init();
							j++;
							continue retry;
						} else {
							throw e;
						}
					}
				}
			}
		} while (!isSwippedTillBottom());
		return this;
	}

	public SRP assertHotelDisplayed() {
		do {
			int numberOfHotels = 0;
			int k = 0;
			while (numberOfHotels == 0) {
				try {
					numberOfHotels = propertyType_tag.size();
				} catch (WebDriverException e) {
					if (k < 2) {
						waitForSeconds(1000);
						init();
						k++;
					} else {
						throw e;
					}
				}
			}
			if (numberOfHotels == 0) {
				break;
			}
			checkWithinPage: for (int i = 0; i < numberOfHotels; i++) {
				int j = 0;
				retry: while (j < 2) {
					try {
						String expectedTextHotel = "HOTEL";
						String expectedTextResort = "RESORT";
						String expectedTextApartMent = "SERVICE APARTMENT";
						String fetched = getTextFromElement(
								propertyType_tag.get(i).findElementByClassName("android.widget.TextView"), driver);
						Assert.assertTrue(
								expectedTextHotel.equals(fetched) || expectedTextResort.equals(fetched)
										|| expectedTextApartMent.equals(fetched),
								"Expected tag is : " + expectedTextHotel + " or " + expectedTextResort + " or "
										+ expectedTextApartMent + " But fetched is : " + fetched);
						j = 0;
						break checkWithinPage;
					} catch (WebDriverException e) {
						if (j < 2) {
							waitForSeconds(1000);
							init();
							j++;
							continue retry;
						} else {
							throw e;
						}
					}
				}
			}
		} while (!isSwippedTillBottom());
		return this;
	}

}
