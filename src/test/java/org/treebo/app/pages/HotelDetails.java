package org.treebo.app.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.treebo.app.global.Libraries;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import org.treebo.app.pages.Itinerary;

public class HotelDetails extends Libraries {

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"SOLD OUT\")")
	private MobileElement soldout_text;

	@AndroidFindBy(accessibility = "book-button")
	private MobileElement bookNow_button;

	@AndroidFindBy(accessibility = "book-button-container")
	private MobileElement bookButtonContainer;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textStartsWith(\"View Other Room\")")
	private MobileElement viewOtherRooms_button;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Assured Essentials\")")
	private MobileElement assuredEssentials_text;

	@AndroidFindBy(accessibility = "header-title")
	private MobileElement hotelName_header;

	@AndroidFindBy(accessibility = "icon-header-left")
	private MobileElement back_arrow;

	@AndroidFindBy(accessibility = "price-text")
	private MobileElement priceText_HD;

	@AndroidFindBy(accessibility = "special-deal-banner")
	private MobileElement specialDeal_banner;

	@AndroidFindBy(accessibility = "login-button")
	private MobileElement login_button;

	@AndroidFindBy(accessibility = "assured-amenity-name-text")
	private List<MobileElement> assuredAmenities_namelist;

	@AndroidFindBy(accessibility = "booking-date-clickable-container")
	private MobileElement bookingDates;

	@AndroidFindBy(accessibility = "hotel-reviews-section")
	private MobileElement tripAdvisorReviews_section;

	@AndroidFindBy(accessibility = "hotel-address-text")
	private MobileElement hotelLocaationMap_section;

	@AndroidFindBy(accessibility = "about-hotel-button")
	private MobileElement aboutHotel_button;

	@AndroidFindBy(accessibility = "about-hotel-modal")
	private MobileElement aboutHotal_modal;

	@AndroidFindBy(accessibility = "hotel-amenities-section-text")
	private MobileElement amenities_AboutHotelModal;

	@AndroidFindBy(accessibility = "icon-header-left")
	private MobileElement close_icon;

	@AndroidFindBy(accessibility = "hotel-policies-button")
	private MobileElement hotelPolicies_button;

	@AndroidFindBy(accessibility = "hotel-policies-modal")
	private MobileElement policies_modal;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Treebos Nearby\")")
	private MobileElement treebosNearby;

	@AndroidFindBy(accessibility = "quick-book-button")
	private MobileElement treebosNearby_QuickBook;

	@AndroidFindBy(accessibility = "search-result-item")
	private MobileElement searchResultItem_TreebosNearby;

	@AndroidFindBy(accessibility = "hotel-name-text")
	private MobileElement hotelName_TreebosNearby;

	@AndroidFindBy(accessibility = "header-title")
	private MobileElement hotelName_HotelDetailsHeader;

	@AndroidFindBy(accessibility = "icon-header-left")
	private MobileElement back_icon;

	@AndroidFindBy(accessibility = "header-subtitle")
	private MobileElement cityName_HDHeader;

	@AndroidFindBy(accessibility = "add-guest-details-button")
	private MobileElement addGuestDetail_button;

	@AndroidFindBy(accessibility = "apply-remove-coupon-text")
	private MobileElement applyHereCoupons_link;

	@HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Refundable\")")
	// @AndroidFindBy(uiAutomator = "new
	// UiSelector().className(\"android.widget.TextView\").text(\"Non-Refundable\")")
	private MobileElement refundableOrNonRefundable_text;

	@AndroidFindBy(accessibility = "room-config-modal")
	private MobileElement roomconfig;

	@AndroidFindBy(accessibility = "enter-name-field")
	private MobileElement guestName_textbox;

	@AndroidFindBy(accessibility = "enter-phone-field")
	private MobileElement phoneNumber_textbox;

	@AndroidFindBy(accessibility = "enter-email-address-field")
	private MobileElement email_textbox;

	// @AndroidFindBy(accessibility = "enable-gst-box-button")
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Use GSTIN for this booking (Optional)\")")
	private MobileElement gst_checkbox;

	@AndroidFindBy(accessibility = "icon-header-left")
	private MobileElement backFromGuestDetails_icon;

	@AndroidFindBy(accessibility = "toggle-component")
	private MobileElement viewBookingDetails_div;

	@AndroidFindBy(accessibility = "enter-gst-company-name-field")
	private MobileElement gstCompanyName_textbox;

	@AndroidFindBy(accessibility = "enter-gst-identification-number-field")
	private MobileElement gstIdentificationNumber_textbox;

	@AndroidFindBy(accessibility = "enter-gst-company-address-field")
	private MobileElement gstCompanyAddress_textbox;

	@AndroidFindBy(accessibility = "proceed-button")
	private MobileElement continueToCheckout_button;

	@AndroidFindBy(accessibility = "hotel-name-text")
	private MobileElement hotelName_text;

	@AndroidFindBy(accessibility = "enter-coupon-code-field")
	private MobileElement enterCouponCode_textbox;

	@AndroidFindBy(accessibility = "coupon-button")
	private List<MobileElement> availableCoupons_list;

	@AndroidFindBy(accessibility = "icon-header-left")
	private MobileElement closeScreen_button;

	@AndroidFindBy(accessibility = "apply-coupon-button")
	private MobileElement applyCoupon_button;

	@AndroidFindBy(accessibility = "input-field-error-text")
	private MobileElement invalidCouponErrorText;

	@AndroidFindBy(accessibility = "coupon-amount-text")
	private List<MobileElement> couponAmount_text;

	@AndroidFindBy(accessibility = "total-payable-amount-text")
	private MobileElement totalPayablePrice;

	@AndroidFindBy(accessibility = "coupon-discount-amount-text")
	private MobileElement couponDiscountPrice;

	@AndroidFindBy(accessibility = "room-tarrif-amount-text")
	private MobileElement roomTariffPrice;

	@AndroidFindBy(accessibility = "taxes-amount-text")
	private MobileElement TaxesPrice;

	@AndroidFindBy(accessibility = "member-discount-amount-text")
	private MobileElement memberDiscountPrice;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Please enter a valid name\")")
	private MobileElement guestNameErrorMessage;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Please enter a valid Contact number\")")
	private MobileElement contactNumberErrorMessage;

	@AndroidFindBy(accessibility = "otp-modal")
	private MobileElement otp_modal;

	@AndroidFindBy(accessibility = "enter-otp-verify-field")
	private MobileElement enterOtp_textbox;

	@AndroidFindBy(accessibility = "verify-button")
	private MobileElement verifyOTP_nutton;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"OTP not verified\")")
	private MobileElement otpErrorMessage;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Edit\")")
	private MobileElement editPhoneNumber_Button;

	@AndroidFindBy(accessibility = "resend-button")
	private MobileElement resendOTP_button;

	@AndroidFindBy(accessibility = "enter-mobile-number-field")
	private MobileElement enterMobileNumber_OtpModal;

	@AndroidFindBy(accessibility = "header-middle-view")
	private MobileElement paymentScreen_header;

	@AndroidFindBy(accessibility = "rate-plan-tag")
	private MobileElement rate_plan_tag;

	@AndroidFindBy(accessibility = "view-other-rooms-text")
	private MobileElement view_bigger_room;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textStartsWith(\"BOOK NOW FOR ₹\")")
	private MobileElement bookButton_text;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textStartsWith(\"BOOK FOR ₹\")")
	private MobileElement partPayBookButton_text;

	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textStartsWith(\"CHECK AVAILABLE DATES\")")
	private MobileElement checkAvailableDates_text;

	@AndroidFindBy(accessibility = "error-message")
	private List<MobileElement> errorMessage_text;

	@AndroidFindBy(accessibility = "t-traveller-info-card")
	private MobileElement loggedInUserInfo_card;

	@AndroidFindBy(accessibility = "t-edit-button")
	private MobileElement editLoggedInUserInfo_button;

	@AndroidFindBy(accessibility = "t-username-text")
	private MobileElement usernameInUserInfo_text;

	private MobileDriver<MobileElement> driver;

	public void init() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public HotelDetails(MobileDriver<MobileElement> driver) {
		this.driver = driver;
		init();
	}

	public HotelDetails assertSoldOutDisplayed() {
		waitElementToBeVisible(soldout_text, driver);
		Assert.assertTrue(soldout_text.isDisplayed(), "Sold out text is not displayed");
		return this;
	}

	public HotelDetails assertBookNowDisplayed() {
		waitElementToBeClickable(bookNow_button);
		Assert.assertTrue(bookNow_button.isDisplayed(), "Book Now Button is not displayed in HD page");
		return this;
	}

	public Payment clickBookNowButton() {
		waitElementToBeClickable(bookNow_button);
		clickElement(bookNow_button, driver);
		return new Payment(driver);
	}

	public HotelDetails clickBookNowButtonError() {
		waitElementToBeClickable(bookNow_button);
		clickElement(bookNow_button, driver);
		return new HotelDetails(driver);
	}

	public HotelDetails assertViewOtherRoomsDisplayed() {
		try {
			waitElementToBeVisible(bookButton_text, driver);
		} catch (WebDriverException e) {
			waitElementToBeVisible(partPayBookButton_text, driver);
		}

		swipeVerticallyDownTillElementDisplayed(driver, priceText_HD, 3);
		swipeVerticallyDownTillElementDisplayed(driver, viewOtherRooms_button, 2);
		waitElementToBeClickable(viewOtherRooms_button);
		Assert.assertTrue(viewOtherRooms_button.isDisplayed(), "View Other Rooms Button is not displayed in HD page");
		return this;
	}

	public BiggerRooms clickViewOtherRoom() {
		try {
			waitElementToBeVisible(bookButton_text, driver);
		} catch (WebDriverException e) {
			waitElementToBeVisible(partPayBookButton_text, driver);
		}
		// waitElementToBeVisible(bookButton_text, driver);
		swipeVerticallyDownTillElementDisplayed(driver, priceText_HD, 3);
		swipeVerticallyDownTillElementDisplayed(driver, viewOtherRooms_button, 2);
		swipeVerticallyDownTillElementDisplayed(driver, applyHereCoupons_link, 2);
		waitElementToBeClickable(viewOtherRooms_button);
		waitForSeconds(2000);
		clickElement(viewOtherRooms_button, driver);
		waitForSeconds(500);
		init();
		return new BiggerRooms(driver);
	}

	public HotelDetails assertAssuredEssentialsDisplayed() {
		swipeVerticallyDownTillElementDisplayed(driver, assuredEssentials_text, 4);
		waitElementToBeVisible(assuredEssentials_text, driver);
		Assert.assertTrue(assuredEssentials_text.isDisplayed(), "Assured Essentials text is not displayed");
		return this;
	}

	public SRP clickBackArrow() {
		waitElementToBeClickable(back_arrow);
		clickElement(back_arrow, driver);
		return new SRP(driver);
	}

	public HotelDetails assertHotelName(String expectedName) {
		String fetched = getHotelName();
		Assert.assertTrue(fetched.toLowerCase().equals(expectedName.toLowerCase()),
				"Expected hotel name : " + expectedName + ". But fetched : " + fetched);
		return this;
	}

	public HotelDetails assertPricesDisplayed() {
		try {
			waitElementToBeVisible(bookButton_text, driver);
		} catch (WebDriverException e) {
			waitElementToBeVisible(partPayBookButton_text, driver);
		}
		swipeVerticallyDownTillElementDisplayed(driver, rate_plan_tag, 4);
		waitElementToBeVisible(priceText_HD, driver);
		Assert.assertTrue(priceText_HD.isDisplayed(), "Prices are not coming in HotelDetails page");
		return this;
	}

	public HotelDetails assertSpecialDealsBannerDisplayed() {
		swipeVerticallyDownTillElementDisplayed(driver, specialDeal_banner, 3);
		Assert.assertTrue(specialDeal_banner.isDisplayed(),
				"Special Deal Banner is not displayed in the Hotel Details page");
		return this;
	}

	public Login clickLoginButton() {
		waitElementToBeClickable(login_button);
		clickElement(login_button, driver);
		return new Login(driver);
	}

	public HotelDetails assertAssuredAmenitiesNameListDisplayed() {
		swipeVerticallyDownTillElementDisplayed(driver, bookingDates, 10);
		int totalAmenities = assuredAmenities_namelist.size();
		int i = 0;
		String[] FreeAmenities = new String[totalAmenities];
		for (MobileElement element : assuredAmenities_namelist) {
			FreeAmenities[i] = element.getText();
			i++;
		}
		return this;
	}

	public HotelDetails assertAssuredAmenitiesNameSizeGreaterThenZero() {
		swipeVerticallyDownTillElementDisplayed(driver, bookingDates, 10);
		int totalAmenities = assuredAmenities_namelist.size();
		Assert.assertTrue(totalAmenities > 1,
				"Total Amenitites Name list is less then 0,which should not happen.The Amenities size displayed in the HotelDetails page is :"
						+ totalAmenities);
		return this;
	}

	public HotelDetails assertTripAdvisorReviewsSectionDisplayed() {
		swipeVerticallyDownTillElementDisplayed(driver, tripAdvisorReviews_section, 10);
		Assert.assertTrue(tripAdvisorReviews_section.isDisplayed(),
				"Trip Advisor Reviews Section is not present for the selected hotel");
		return this;
	}

	public HotelDetails assertHotelLocationMapSectionDisplayed() {
		int i = 0;
		while (i < retryCount) {
			try {
				waitElementToBeClickable(hotelName_text);
			} catch (TimeoutException e) {
				if (i < retryCount) {
					i++;
					waitForSeconds(1000);
					init();
					continue;
				} else {
					throw e;
				}
			}
			waitForSeconds(3000);
			swipeVerticallyDownTillElementDisplayed(driver, hotelLocaationMap_section, 2);
			Assert.assertTrue(isElementPresent(hotelLocaationMap_section, driver),
					"Hotel Location Map Section is not present for the selected hotel");
			return this;
		}
		return null;
	}

	public HotelDetails assertAboutHotelDisplayed() {
		swipeVerticallyDownTillElementDisplayed(driver, aboutHotel_button, 5);
		Assert.assertTrue(isElementPresent(aboutHotel_button, driver),
				"About Hotel is not displayed in the HotelDetails page for the selected hotel");
		return this;
	}

	public HotelDetails clickAboutHotel() {
		swipeVerticallyDownTillElementDisplayed(driver, aboutHotel_button, 5);
		clickElement(aboutHotel_button, driver);
		return this;
	}

	public HotelDetails assertAboutHotelModalDisplayed() {
		swipeVerticallyDownTillElementDisplayed(driver, aboutHotal_modal, 3);
		waitElementToBeVisible(aboutHotal_modal, driver);
		Assert.assertTrue(isElementPresent(aboutHotal_modal, driver),
				"About Hotel Modal is not displayed even if user clicked on About Hotel Button in HotelDetails page");
		return this;
	}

	public HotelDetails assertAmenititesSectionDisplayedInAboutHotelModal() {
		swipeVerticallyDownTillElementDisplayed(driver, amenities_AboutHotelModal, 4);
		Assert.assertTrue(isElementPresent(amenities_AboutHotelModal, driver),
				"Amenities Section is  not displayed in the About Hotel Modal");
		return this;
	}

	public HotelDetails clickCloseIcon() {
		waitElementToBeVisible(close_icon, driver);
		clickElement(close_icon, driver);
		return this;
	}

	public HotelDetails assertPoliciesSectionDisplayed() {
		swipeVerticallyDownTillElementDisplayed(driver, hotelPolicies_button, 5);
		Assert.assertTrue(isElementPresent(hotelPolicies_button, driver),
				"Hotel Policies Section is not displayed in the Hotel Details page");
		return this;
	}

	public HotelDetails clickPoliciesSection() {
		waitElementToBeClickable(hotelPolicies_button);
		clickElement(hotelPolicies_button, driver);
		return this;
	}

	public HotelDetails assertPoliciesModalDisplayed() {
		waitElementToBeVisible(policies_modal, driver);
		Assert.assertTrue(isElementPresent(policies_modal, driver),
				"Policies Modal is not displayed even user clicked on Policies Section");
		return this;
	}

	public HotelDetails assertTreebosNearByDisplayed() {
		swipeVerticallyDownTillElementDisplayed(driver, treebosNearby, 10);
		waitElementToBeVisible(treebosNearby, driver);
		Assert.assertTrue(isElementPresent(treebosNearby, driver),
				"Treebos Nearby is not displayed in the Hotel Details page");
		return this;
	}

	public String getHotelNameFromTreebosNearby() {
		swipeVerticallyDownTillElementDisplayed(driver, hotelName_TreebosNearby, 5);
		String hotelName = getTextFromElement(hotelName_TreebosNearby, driver);
		return hotelName;
	}

	public HotelDetails assertHotelNameInHotelDetailsHeader(String hotelName) {
		waitForSeconds(1000);
		waitElementToBeVisible(hotelName_HotelDetailsHeader, driver);
		String hotelNameInHeader = getHotelNameInHotelDetailsHeader();
		Assert.assertTrue(hotelNameInHeader.equals(hotelName.toLowerCase()),
				"Expected HotelName is :" + hotelName + "But displaying Hotel Name is :" + hotelNameInHeader);
		return this;
	}

	public HotelDetails clickTreebosNearby() {
		swipeVerticallyDownTillElementDisplayed(driver, searchResultItem_TreebosNearby, 5);
		clickElement(searchResultItem_TreebosNearby, driver);
		return this;
	}

	public String getHotelNameInHotelDetailsHeader() {
		waitForSeconds(1000);
		String hotelName = getTextFromElement(hotelName_HotelDetailsHeader, driver).trim().toLowerCase();
		// String hotelName =
		// hotelName_HotelDetailsHeader.getText().trim().toLowerCase();
		return hotelName;
	}

	public HotelDetails clickBackIcon() {
		waitElementToBeVisible(back_icon, driver);
		clickElement(back_icon, driver);
		return this;
	}

	public SRP clickBackFromHD() {
		clickBackIcon();
		return new SRP(driver);
	}

	public HotelDetails assertHotelNamePrevious(String PreviousHotelName) {
		waitForSeconds(2000);
		waitElementToBeVisible(hotelName_HotelDetailsHeader, driver);
		String hotelNameInHeader = getTextFromElement(hotelName_HotelDetailsHeader, driver).trim().toLowerCase();
		// String HotelNameInHeader =
		// hotelName_HotelDetailsHeader.getText().trim().toLowerCase();
		Assert.assertTrue(hotelNameInHeader.equals(PreviousHotelName.toLowerCase()),
				"Expected HotelName is :" + PreviousHotelName + "But displaying Hotel Name is :" + hotelNameInHeader);
		return this;
	}

	public String getCityNameInHotelDetailsHeader() {
		waitForSeconds(1000);
		waitElementToBeVisible(cityName_HDHeader, driver);
		String cityName = getTextFromElement(cityName_HDHeader, driver).trim().toLowerCase();
		// String cityName = cityName_HDHeader.getText().trim().toLowerCase();
		return cityName;
	}

	public HotelDetails clickAddGuestDetails() {
		waitForSeconds(2000);
		waitElementToBeClickable(addGuestDetail_button);
		clickElement(addGuestDetail_button, driver);
		return this;
	}

	public HotelDetails assertApplyRemoveCouponsButton() {
		waitElementToBeClickable(applyHereCoupons_link);
		Assert.assertTrue(applyHereCoupons_link.isDisplayed(),
				"Apply/Remove Coupon Button is not displayed in the Itinerary page");
		return this;
	}

	public HotelDetails clickApplyRemoveCoupons() {
		waitForSeconds(1000);
		swipeVerticallyDownTillElementDisplayed(driver, applyHereCoupons_link, 5);
		waitElementToBeClickable(applyHereCoupons_link);
		clickElement(applyHereCoupons_link, driver);
		System.out.println("Clicked apply remove coupon");
		return this;
	}

	public String getPlanType() {
		waitElementToBeVisible(refundableOrNonRefundable_text, driver);
		String text = getTextFromElement(refundableOrNonRefundable_text, driver);
		return text;
	}

	public HotelDetails assertBookingDatesDisplayed() {
		waitElementToBeVisible(bookingDates, driver);
		Assert.assertTrue(isElementPresent(bookingDates, driver), "Booking Dates are displayed in the Itinerary page");
		return this;
	}

	public HotelDetails clickBookingDates() {
		waitElementToBeClickable(bookingDates);
		clickElement(bookingDates, driver);
		return this;
	}

	public HotelDetails assertRoomConfigDisplayed() {
		waitElementToBeVisible(roomconfig, driver);
		Assert.assertTrue(isElementPresent(roomconfig, driver), "Room Config is displayed in the Itinerary page");
		return this;
	}

	public RoomConfig clickRoomConfig() {
		swipeVerticallyDownTillElementDisplayed(driver, roomconfig, 5);
		waitElementToBeClickable(roomconfig);
		clickElement(roomconfig, driver);
		return new RoomConfig(driver);
	}

	public HotelDetails clearName() {
		swipeVerticallyDownTillElementDisplayed(driver, guestName_textbox, 5);
		waitElementToBeVisible(guestName_textbox, driver);
		clearElement(guestName_textbox, driver);
		return this;
	}

	public HotelDetails enterName(String name) {
		try {
			waitElementToBeVisible(bookButton_text, driver);
		} catch (WebDriverException e) {
			waitElementToBeVisible(partPayBookButton_text, driver);
		}
		swipeVerticallyDownTillElementDisplayed(driver, guestName_textbox, 5);
		waitElementToBeVisible(guestName_textbox, driver);
		sendkeysElement(guestName_textbox, name, driver);
		return this;
	}

	public HotelDetails clearPhoneNumber() {
		swipeVerticallyDownTillElementDisplayed(driver, phoneNumber_textbox, 5);
		waitElementToBeVisible(phoneNumber_textbox, driver);
		clearElement(phoneNumber_textbox, driver);
		return this;
	}

	public HotelDetails enterPhoneNumber(String phonenumber) {
		swipeVerticallyDownTillElementDisplayed(driver, phoneNumber_textbox, 5);
		waitElementToBeVisible(phoneNumber_textbox, driver);
		sendkeysElement(phoneNumber_textbox, phonenumber, driver);
		return this;
	}

	public HotelDetails clickContactNumber() {
		swipeVerticallyDownTillElementDisplayed(driver, phoneNumber_textbox, 5);
		waitElementToBeClickable(phoneNumber_textbox);
		clickElement(phoneNumber_textbox, driver);
		return this;
	}

	public HotelDetails clearEmail() {
		swipeVerticallyDownTillElementDisplayed(driver, email_textbox, 5);
		waitElementToBeVisible(email_textbox, driver);
		clearElement(email_textbox, driver);
		return this;
	}

	public HotelDetails enterEmail(String email) {
		swipeVerticallyDownTillElementDisplayed(driver, email_textbox, 5);
		waitElementToBeVisible(email_textbox, driver);
		sendkeysElement(email_textbox, email, driver);
		return this;
	}

	public HotelDetails clickEmailIdTextBox() {
		waitElementToBeClickable(email_textbox);
		clickElement(email_textbox, driver);
		return this;
	}

	public HotelDetails assertGstCheckboxDisplayed() {
		waitElementToBeVisible(gst_checkbox, driver);
		Assert.assertTrue(gst_checkbox.isDisplayed(), "Gst Checkbox is not displayed in the Itinerary page");
		return this;
	}

	public HotelDetails clickGstCheckbox() {
		swipeVerticallyDownTillElementDisplayed(driver, gst_checkbox, 5);
		waitElementToBeClickable(gst_checkbox);
		clickElement(gst_checkbox, driver);
		return this;
	}

	public HotelDetails assertBackFromGuestDetailsIconDisplayed() {
		waitElementToBeVisible(backFromGuestDetails_icon, driver);
		Assert.assertTrue(backFromGuestDetails_icon.isDisplayed(),
				"Back button is not displayed in the Guest Details Screen");
		return this;
	}

	public HotelDetails clickBackIconGuestDetails() {
		waitElementToBeClickable(backFromGuestDetails_icon);
		clickElement(backFromGuestDetails_icon, driver);
		return this;
	}

	public HotelDetails assertViewBookingDetailsDivDisplayed() {
		waitElementToBeVisible(backFromGuestDetails_icon, driver);
		Assert.assertTrue(viewBookingDetails_div.isDisplayed(),
				"View Details Div is not dispalyed in the Guest Details screen");
		return this;
	}

	public HotelDetails clickViewBookingDetails() {
		waitElementToBeClickable(backFromGuestDetails_icon);
		clickElement(backFromGuestDetails_icon, driver);
		return this;
	}

	public HotelDetails assertGSTCompanyNameDisplayed() {
		waitElementToBeVisible(gstCompanyName_textbox, driver);
		Assert.assertTrue(gstCompanyName_textbox.isDisplayed(),
				"GST Company Name field is not displayed in the Guest Details Screen");
		return this;
	}

	public HotelDetails enterGSTCompanyName(String companyname) {
		swipeVerticallyDownTillElementDisplayed(driver, gstCompanyName_textbox, 4);
		waitElementToBeVisible(gstCompanyName_textbox, driver);
		sendkeysElement(gstCompanyName_textbox, companyname, driver);
		return this;
	}

	public HotelDetails assertGSTIdentificationNumberDisplayed() {
		swipeVerticallyDownTillElementDisplayed(driver, gstIdentificationNumber_textbox, 4);
		waitElementToBeVisible(gstIdentificationNumber_textbox, driver);
		Assert.assertTrue(gstIdentificationNumber_textbox.isDisplayed(),
				"GST Identification Number field is not displayed in the Guest Details Screen");
		return this;
	}

	public HotelDetails enterGSTIdentificationNumber(String identificationnumber) {
		swipeVerticallyDownTillElementDisplayed(driver, gstIdentificationNumber_textbox, 4);
		waitElementToBeVisible(gstIdentificationNumber_textbox, driver);
		sendkeysElement(gstIdentificationNumber_textbox, identificationnumber, driver);
		return this;
	}

	public HotelDetails assertGSTCompanyAddressDisplayed() {
		swipeVerticallyDownTillElementDisplayed(driver, gstCompanyAddress_textbox, 4);
		waitElementToBeVisible(gstCompanyAddress_textbox, driver);
		Assert.assertTrue(gstCompanyAddress_textbox.isDisplayed(),
				"GST Company Address field is not displayed in the Guest Details Screen");
		return this;
	}

	public HotelDetails enterGSTCompanyAddress(String companyaddress) {
		swipeVerticallyDownTillElementDisplayed(driver, gstCompanyAddress_textbox, 4);
		waitElementToBeVisible(gstCompanyAddress_textbox, driver);
		sendkeysElement(gstCompanyAddress_textbox, companyaddress, driver);
		return this;
	}

	public HotelDetails isContinueToCheckoutButtonDisplayed() {
		waitElementToBeVisible(continueToCheckout_button, driver);
		Assert.assertTrue(continueToCheckout_button.isDisplayed(),
				"Continue To Checkout button is not displayed in the Guest Details Screen");
		return this;
	}

	public Payment clickContinueToCheckoutButton() {
		waitElementToBeClickable(continueToCheckout_button);
		clickElement(continueToCheckout_button, driver);
		return new Payment(driver);
	}

	public String getHotelName() {
		int i = 0;
		while (true) {
			try {
				waitElementToBeVisible(hotelName_text, driver);
				String name = getTextFromElement(hotelName_text, driver);
				return name;
			} catch (WebDriverException e) {
				if (i < retryCount) {
					waitForSeconds(1000);
					init();
					i++;
					continue;
				} else {
					throw e;
				}
			}
		}
	}

	public HotelDetails clickCrossButtonIfCouponsAreNotThereElseClickCoupon() {
		waitElementToBeVisible(enterCouponCode_textbox, driver);
		System.out.println("Passed the visibility condition");
		waitForSeconds(1000);
		try {
			waitElementToBeVisible(availableCoupons_list.get(0), driver);
			int couponList = getAvailableCouponsListSize();
			int randomIndex = getRandomNumberInRange(0, couponList - 1);
			clickElement(availableCoupons_list.get(randomIndex), driver);
		} catch (NoSuchElementException | IndexOutOfBoundsException e) {
			clickElement(closeScreen_button, driver);
		}
		return this;
	}

	public int getAvailableCouponsListSize() {
		waitElementToBeVisible(enterCouponCode_textbox, driver);
		int availableCoupons = availableCoupons_list.size();
		return availableCoupons;

	}

	public HotelDetails enterCouponCode(String couponcode) {
		waitElementToBeVisible(enterCouponCode_textbox, driver);
		waitForSeconds(2000);
		sendkeysElement(enterCouponCode_textbox, couponcode, driver);
		return this;
	}

	public HotelDetails clickApplyCouponButton() {
		waitElementToBeClickable(applyCoupon_button);
		clickElement(applyCoupon_button, driver);
		return this;
	}

	public HotelDetails assertInvalidCouponCodeTextDisplayed() {
		waitElementToBeVisible(invalidCouponErrorText, driver);
		Assert.assertTrue(invalidCouponErrorText.isDisplayed(),
				"Invalid Coupon Code Error Message is not displayed if user enter wrong coupon code");
		return this;
	}

	public float getTotalPayablePrice() {
		swipeVerticallyDownTillElementDisplayed(driver, totalPayablePrice, 5);
		String totalpayable = totalPayablePrice.getText().replace("₹", "");
		float total = Float.parseFloat(totalpayable);
		return total;
	}

	public HotelDetails assertPaymentDetails() {
		swipeVerticallyDownTillElementDisplayed(driver, totalPayablePrice, 5);
		float TotalPayable = getTotalPayablePrice();
		float roomTariffPrice = getRoomTariffPrice();
		float taxesPrice = getTaxesPrice();
		float min, max;
		if (!isElementPresent(couponDiscountPrice, driver) & !isElementPresent(memberDiscountPrice, driver)) {
			min = (roomTariffPrice + taxesPrice - 1);
			max = (roomTariffPrice + taxesPrice + 1);

		} else if (!isElementPresent(couponDiscountPrice, driver) & isElementPresent(memberDiscountPrice, driver)) {
			float memberDiscountPrice = getMemberDiscountPrice();
			min = (roomTariffPrice + taxesPrice - 1) - memberDiscountPrice;
			max = (roomTariffPrice + taxesPrice + 1) - memberDiscountPrice;
		} else {
			float discountPrice = getCouponDiscountPrice();
			max = (roomTariffPrice + taxesPrice + 1) - discountPrice;
			min = (roomTariffPrice + taxesPrice - 1) - discountPrice;
		}
		Assert.assertTrue(isNumberBetweenSpecifiedRange(TotalPayable, max, min),
				"Total Payable Price is not Between specific range" + "max range" + max + "min range" + min);
		return this;
	}

	public float getRoomTariffPrice() {
		swipeVerticallyDownTillElementDisplayed(driver, roomTariffPrice, 4);
		String roomTariff = roomTariffPrice.getText().replace("₹", "");
		float roomTariffPrice = Float.parseFloat(roomTariff);
		return roomTariffPrice;
	}

	public Float getTaxesPrice() {
		swipeVerticallyDownTillElementDisplayed(driver, TaxesPrice, 4);
		String taxes = TaxesPrice.getText().replace("₹", "");
		Float taxesPrice = Float.parseFloat(taxes);
		return taxesPrice;
	}

	public Float getCouponDiscountPrice() {
		swipeVerticallyDownTillElementDisplayed(driver, couponDiscountPrice, 4);
		String couponDiscount = couponDiscountPrice.getText().replace("- ₹", "");
		Float couponDiscountPrice = Float.parseFloat(couponDiscount);
		return couponDiscountPrice;
	}

	public Float getMemberDiscountPrice() {
		swipeVerticallyDownTillElementDisplayed(driver, memberDiscountPrice, 4);
		String memberDiscount = memberDiscountPrice.getText().replace("- ₹", "");
		Float memberDiscountPrice = Float.parseFloat(memberDiscount);
		return memberDiscountPrice;
	}

	public HotelDetails assertOtpModalDisplayed() {
		waitElementToBeVisible(otp_modal, driver);
		Assert.assertTrue(otp_modal.isDisplayed(), "Otp modal is not displayed even if number is not verified");
		return this;
	}

	public HotelDetails enterOTP(String otp) {
		waitElementToBeClickable(enterOtp_textbox);
		sendkeysElement(enterOtp_textbox, otp, driver);
		return this;
	}

	public HotelDetails clickVerifyOTPButton() {
		waitElementToBeClickable(verifyOTP_nutton);
		clickElement(verifyOTP_nutton, driver);
		return this;
	}

	public HotelDetails assertOtpErrorMessageDisplayed() {
		waitElementToBeVisible(otpErrorMessage, driver);
		Assert.assertTrue(otpErrorMessage.isDisplayed(),
				"Otp Not Verified Error Message is not displayed even if user entered wrong Otp");
		return this;
	}

	public HotelDetails clickResendOTPButton() {
		waitElementToBeClickable(resendOTP_button);
		clickElement(resendOTP_button, driver);
		return this;
	}

	public HotelDetails clickeditPhoneNumberButton() {
		waitElementToBeClickable(editPhoneNumber_Button);
		clickElement(editPhoneNumber_Button, driver);
		return this;
	}

	public HotelDetails clearPhoneNumberInOtpModal() {
		waitElementToBeVisible(enterMobileNumber_OtpModal, driver);
		clearElement(enterMobileNumber_OtpModal, driver);
		return this;
	}

	public HotelDetails enterPhoneNumberInOTPModal(String phonenumber) {
		waitElementToBeVisible(enterMobileNumber_OtpModal, driver);
		sendkeysElement(enterMobileNumber_OtpModal, phonenumber, driver);
		return this;
	}

	public HotelDetails clickCloseOtpModalIcon() {
		waitElementToBeClickable(closeScreen_button);
		clickElement(closeScreen_button, driver);
		return this;
	}

	public HotelDetails assertPaymentDetailsHeaderInPaymentScreen() {
		waitElementToBeVisible(paymentScreen_header, driver);
		MobileElement payment = paymentScreen_header.findElementByClassName("android.widget.TextView");
		String paymentHeader = payment.getText();
		Assert.assertTrue(paymentHeader.equalsIgnoreCase("Payment Details"),
				"Expected text is Payment Details but found :" + paymentHeader);
		return this;
	}

	@Override
	public void swipeVerticallyDownTillElementDisplayed(MobileDriver<MobileElement> driver, MobileElement element,
			int maxScrollTime) {
		try {
			System.out.println("Name of element : " + element.toString());
			if (isElementPresent(element, driver)) {
				System.out.println("Element is present at 1st go");
				if (isOverlappingWithBookButton(element)) {
					System.out.println("The element is overlapping");
					swipeVerticallyDown(driver);
				} else {
					System.out.println("The eleemnt is not overlapping");
				}
				return;
			}
		} catch (NoSuchElementException e) {
		}

		int scrollTime = 1;
		while (maxScrollTime > scrollTime) {
			scrollTime++;
			System.out.println("Swipping down");
			swipeVerticallyDown(driver);
			waitForSeconds(500);
			try {
				if (isElementPresent(element, driver)) {
					System.out.println("Element is present");
					if (isOverlappingWithBookButton(element)) {
						System.out.println("Element is overlapping");
						swipeVerticallyDown(driver);
					} else {
						System.out.println("Element is not overlapping");
					}
					return;
				}
			} catch (NoSuchElementException e) {
			}
		}
		throw new NoSuchElementException(
				"Element could not be found even after scrolling for : " + scrollTime + " times.");
	}

	private boolean isOverlappingWithBookButton(MobileElement element) {
		System.out.println("Overlapping check");
		if (isElementPresent(element, driver)) {
			System.out.println("Overlapping check, elemet present");
			Point ptBookButton = getLocationOfElement(bookButtonContainer, driver);
			Dimension dimBookButton = getSizeOfElement(bookButtonContainer, driver);
			int heightOfBookButon = dimBookButton.getHeight();
			int upperHeightOfBookButton = ptBookButton.getY();
			int lowerHeightOfBookButton = upperHeightOfBookButton - heightOfBookButon;
			Point ptElement = getLocationOfElement(element, driver);
			int yCordinateElement = ptElement.getY();
			System.out.println("Height of book button : " + heightOfBookButon);
			System.out.println("y upper of book button : " + upperHeightOfBookButton);
			System.out.println("y lower of book button : " + lowerHeightOfBookButton);
			System.out.println("y for element : " + yCordinateElement);
			if ((upperHeightOfBookButton * 1.1) > yCordinateElement) {
				if (lowerHeightOfBookButton < yCordinateElement) {
					System.out.println("Yes book button is overlapping");
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void swipeVerticallyDown(MobileDriver<MobileElement> driver) {
		Dimension dim = driver.manage().window().getSize();
		int x_intial = (int) ((int) (dim.width) * (0.66));
		int y_initial = (int) ((int) (dim.height) * (0.70));
		int y_final = (int) ((int) (dim.height) * (0.25));
		TouchAction action = new TouchAction(driver);
		// action.tap(point(x_intial,y_initial)).waitAction(waitOptions(Duration.ofSeconds(1))).moveTo(point(x_intial,y_final)).release().perform();
		action.press(x_intial, y_initial).waitAction(Duration.ofSeconds(1)).moveTo(x_intial, y_final).release()
				.perform();
		init();
	}

	public double getPriceFromBottomBar() {
		String price = "";
		try {
			waitElementToBeVisible(bookButton_text, driver);
			price = getTextFromElement(bookButton_text, driver);
		} catch (WebDriverException e) {
			waitElementToBeVisible(partPayBookButton_text, driver);
			price = getTextFromElement(partPayBookButton_text, driver);
		}

		price = price.split("₹")[1];
		double price_dbl = Double.parseDouble(price);
		return price_dbl;
	}

	public HotelDetails waitTillPriceLoaded() {
		try {
			waitElementToBeVisible(bookButton_text, driver);
		} catch (WebDriverException e) {
			waitElementToBeVisible(partPayBookButton_text, driver);
		}
		return new HotelDetails(driver);
	}

	public HotelDetails assertCheckAvailableDatesDisplayed() {
		waitForSeconds(2000);
		waitElementToBeVisible(checkAvailableDates_text, driver);
		Assert.assertTrue(checkAvailableDates_text.isDisplayed(), "Check available dates is not displayed");
		return new HotelDetails(driver);
	}

	public HotelDetails assertNameErrorMessageDisplayed() {
		waitElementToBeVisible(errorMessage_text.get(0), driver);
		String expectedWhenGuestNameIsBlank = "Guest name is required";
		String expectedWhenGuestNameisInvalid = "Please enter a valid name";
		System.out.println("Error MEssage is not displayed in this case");
		for (int i = 0; i < errorMessage_text.size(); i++) {
			String fetched = getTextFromElement(errorMessage_text.get(i), driver);
			System.out.println("Fetched Text is " + fetched);
			if (fetched.equals(expectedWhenGuestNameIsBlank)) {
				return new HotelDetails(driver);
			} else if (fetched.equals(expectedWhenGuestNameisInvalid)) {
				return new HotelDetails(driver);
			}
		}
		Assert.assertTrue(false, "Error message for guest name is not displayed");
		return this;
	}

	public HotelDetails assertMobileNumberErrorMessageDisplayed() {
		waitElementToBeVisible(errorMessage_text.get(0), driver);
		String expected = "Mobile Number is required";
		for (int i = 0; i < errorMessage_text.size(); i++) {
			String fetched = getTextFromElement(errorMessage_text.get(i), driver);
			if (fetched.equals(expected)) {
				return new HotelDetails(driver);
			}
		}
		Assert.assertTrue(false, "Error message for mobile number is not displayed");
		return this;
	}

	public HotelDetails assertValidMobileNumberErrorMessageDisplayed() {
		waitElementToBeVisible(errorMessage_text.get(0), driver);
		String expected = "Please enter a valid contact number";
		for (int i = 0; i < errorMessage_text.size(); i++) {
			String fetched = getTextFromElement(errorMessage_text.get(i), driver);
			if (fetched.equals(expected)) {
				return new HotelDetails(driver);
			}
		}
		Assert.assertTrue(false, "Error message for mobile number no valid is not displayed");
		return this;
	}

	public HotelDetails assertEmailErrorMessageDisplayed() {
		waitElementToBeVisible(errorMessage_text.get(0), driver);
		String expected = "Email is required";
		for (int i = 0; i < errorMessage_text.size(); i++) {
			String fetched = getTextFromElement(errorMessage_text.get(i), driver);
			if (fetched.equals(expected)) {
				return new HotelDetails(driver);
			}
		}
		Assert.assertTrue(false, "Error message for email is not displayed");
		return this;
	}

	public HotelDetails assertValidEmailErrorMessageDisplayed() {
		waitElementToBeVisible(errorMessage_text.get(0), driver);
		String expected = "Please enter a valid email address";
		for (int i = 0; i < errorMessage_text.size(); i++) {
			String fetched = getTextFromElement(errorMessage_text.get(i), driver);
			if (fetched.equals(expected)) {
				return new HotelDetails(driver);
			}
		}
		Assert.assertTrue(false, "Error message for valid email is not displayed");
		return this;
	}

	public HotelDetails assertGstinErrorMessageDisplayed() {
		waitElementToBeVisible(errorMessage_text.get(0), driver);
		String expected = "Please enter a valid GSTIN";
		for (int i = 0; i < errorMessage_text.size(); i++) {
			String fetched = getTextFromElement(errorMessage_text.get(i), driver);
			if (fetched.equals(expected)) {
				return new HotelDetails(driver);
			}
		}
		Assert.assertTrue(false, "Error message for gstin is not displayed");
		return this;
	}

	public HotelDetails assertCompanyNameErrorMessageDisplayed() {
		waitElementToBeVisible(errorMessage_text.get(0), driver);
		String expected = "Company name is required";
		for (int i = 0; i < errorMessage_text.size(); i++) {
			String fetched = getTextFromElement(errorMessage_text.get(i), driver);
			if (fetched.equals(expected)) {
				return new HotelDetails(driver);
			}
		}
		Assert.assertTrue(false, "Error message for company name is not displayed");
		return this;
	}

	public HotelDetails assertCompanyAddressErrorMessageDisplayed() {
		waitElementToBeVisible(errorMessage_text.get(0), driver);
		String expected = "Company address is required";
		for (int i = 0; i < errorMessage_text.size(); i++) {
			String fetched = getTextFromElement(errorMessage_text.get(i), driver);
			if (fetched.equals(expected)) {
				return new HotelDetails(driver);
			}
		}
		Assert.assertTrue(false, "Error message for company address is not displayed");
		return this;
	}

	public HotelDetails enterGuestDetailIfExistInHDPage(String guestName, String mobile, String email) {
		swipeVerticallyDownTillElementDisplayed(driver, hotelPolicies_button, 4);
		try {
			enterName(guestName);
			enterPhoneNumber(mobile);
			enterEmail(email);
		} catch (NoSuchElementException e) {
			System.out.println("Single Page Hd Page is not there Hence clicking on Book Now Button");
			clickBookNowButton();
			enterName(guestName);
			enterPhoneNumber(mobile);
			enterEmail(email);
		}
		return this;
	}

	public HotelDetails assertLoggedInUserInfoCardPresent() {
		swipeVerticallyDownTillElementDisplayed(driver, loggedInUserInfo_card, 4);
		Assert.assertTrue(loggedInUserInfo_card.isDisplayed(),
				"Logged In User Info Card is not presnet in the Hotel Details page");
		return this;
	}

	public HotelDetails assertEditLoggedInUserButtonPresent() {
		waitElementToBeClickable(editLoggedInUserInfo_button);
		Assert.assertTrue(editLoggedInUserInfo_button.isDisplayed(),
				"Edit Button is not present in Logged In User Info Card in Hotel Details page");
		return this;
	}

	public HotelDetails clickEditLoggedInUserButton() {
		swipeVerticallyDownTillElementDisplayed(driver, editLoggedInUserInfo_button, 5);
		clickElement(editLoggedInUserInfo_button, driver);
		return this;
	}

	public HotelDetails assertUsernameInUserInfoCardPresent() {
		waitElementToBeVisible(usernameInUserInfo_text, driver);
		Assert.assertTrue(usernameInUserInfo_text.isDisplayed(),
				"User Name is not presnet in Logged In User Inof Card in Hotel Details");
		return this;
	}

	public HotelDetails clickEditTravellerInfoButtonIfExist() {
		try {
			clickEditLoggedInUserButton();
		} catch (NoSuchElementException e) {
			System.out.println(
					"Logged In User Card is not present.Older Primary Traveller Info Card is present hence no need to click on the Edit Logged In User Button ");
		}
		return this;
	}

}
