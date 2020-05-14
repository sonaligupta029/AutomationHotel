package org.treebo.app.pages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import org.testng.Assert;
import org.treebo.app.global.Libraries;
import org.openqa.selenium.Alert;

public class Itinerary extends Libraries {

	@AndroidFindBy(accessibility = "add-guest-details-button")
	private MobileElement addGuestDetail_button;

	@AndroidFindBy(accessibility = "apply-remove-coupon-text")
	private MobileElement applyHereCoupons_link;

	@HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
	@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Refundable\")")
	//@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Non-Refundable\")")
	private MobileElement refundableOrNonRefundable_text;

	@AndroidFindBy(accessibility = "booking-date-clickable-container")
	private MobileElement bookingDates;

	@AndroidFindBy(accessibility = "room-config-modal")
	private MobileElement roomconfig;

	@AndroidFindBy(accessibility = "enter-name-field")
	private MobileElement guestName_textbox;

	@AndroidFindBy(accessibility = "enter-phone-field")
	private MobileElement phoneNumber_textbox;

	@AndroidFindBy(accessibility = "enter-email-address-field")
	private MobileElement email_textbox;

	//@AndroidFindBy(accessibility = "enable-gst-box-button")
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
	
	@AndroidFindBy (accessibility = "hotel-name-text")
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
	
	@AndroidFindBy(accessibility = "prepaid-payment-options-section")
	private MobileElement prepaidPayment_section;
	
	@AndroidFindBy(accessibility = "debit-credit-card-button")
	private MobileElement debitCard_button;
	
	@AndroidFindBy(accessibility = "pay-at-hotel-section")
	private MobileElement payAtHotel_section;
	
	@AndroidFindBy(accessibility = "pay-at-hotel-proceed-button")
	private MobileElement payATHotelProceed_button;
	
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


	private MobileDriver<MobileElement> driver;
	
	public void init() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public Itinerary(MobileDriver<MobileElement> driver) {
		this.driver = driver;
		init();
	}

	public Itinerary clickAddGuestDetails() {
		waitForSeconds(2000);
		waitElementToBeClickable(addGuestDetail_button);
		clickElement(addGuestDetail_button, driver);
		return this;
	}
	
	public Itinerary assertApplyRemoveCouponsButton() {
		waitElementToBeClickable(applyHereCoupons_link);
		Assert.assertTrue(applyHereCoupons_link.isDisplayed(), "Apply/Remove Coupon Button is not displayed in the Itinerary page");
		return this;
	}

	public Itinerary clickApplyHereCoupons() {
		waitForSeconds(1000);
		waitElementToBeClickable(applyHereCoupons_link);
		clickElement(applyHereCoupons_link, driver);
		return this;
	}

	public String getPlanType() {
		waitElementToBeVisible(refundableOrNonRefundable_text, driver);
		String text = getTextFromElement(refundableOrNonRefundable_text, driver);
		return text;
	}

	public Itinerary assertBookingDatesDisplayed() {
		waitElementToBeVisible(bookingDates, driver);
		Assert.assertTrue(bookingDates.isDisplayed(), "Booking Dates are displayed in the Itinerary page");
		return this;
	}

	public Itinerary clickBookingDates() {
		waitElementToBeClickable(bookingDates);
		clickElement(bookingDates, driver);
		return this;
	}

	public Itinerary assertRoomConfigDisplayed() {
		waitElementToBeVisible(roomconfig, driver);
		Assert.assertTrue(roomconfig.isDisplayed(), "Room Config is displayed in the Itinerary page");
		return this;
	}

	public Itinerary clickRoomConfig() {
		waitElementToBeClickable(roomconfig);
		clickElement(roomconfig, driver);
		return this;
	}

	public Itinerary enterName(String name) {
		waitElementToBeVisible(guestName_textbox, driver);
		sendkeysElement(guestName_textbox, name, driver);
		return this;
	}

	public Itinerary enterPhoneNumber(String phonenumber) {
		waitElementToBeVisible(phoneNumber_textbox, driver);
		sendkeysElement(phoneNumber_textbox, phonenumber, driver);
		return this;
	}
	
	public Itinerary clickContactNumber() {
		waitElementToBeClickable(phoneNumber_textbox);
		clickElement(phoneNumber_textbox, driver);
		return this;
	}

	public Itinerary enterEmail(String email) {
		waitElementToBeVisible(email_textbox, driver);
		sendkeysElement(email_textbox, email, driver);
		return this;
	}
	
	public Itinerary clickEmailIdTextBox() {
		waitElementToBeClickable(email_textbox);
		clickElement(email_textbox, driver);
		return this;
	}

	public Itinerary assertGstCheckboxDisplayed() {
		waitElementToBeVisible(gst_checkbox, driver);
		Assert.assertTrue(gst_checkbox.isDisplayed(), "Gst Checkbox is not displayed in the Itinerary page");
		return this;
	}

	public Itinerary clickGstCheckbox() {
		waitElementToBeClickable(gst_checkbox);
		clickElement(gst_checkbox, driver);
		return this;
	}

	public Itinerary assertBackFromGuestDetailsIconDisplayed() {
		waitElementToBeVisible(backFromGuestDetails_icon, driver);
		Assert.assertTrue(backFromGuestDetails_icon.isDisplayed(),
				"Back button is not displayed in the Guest Details Screen");
		return this;
	}

	public Itinerary clickBackIconGuestDetails() {
		waitElementToBeClickable(backFromGuestDetails_icon);
		clickElement(backFromGuestDetails_icon, driver);
		return this;
	}

	public Itinerary assertViewBookingDetailsDivDisplayed() {
		waitElementToBeVisible(backFromGuestDetails_icon, driver);
		Assert.assertTrue(viewBookingDetails_div.isDisplayed(),
				"View Details Div is not dispalyed in the Guest Details screen");
		return this;
	}

	public Itinerary clickViewBookingDetails() {
		waitElementToBeClickable(backFromGuestDetails_icon);
		clickElement(backFromGuestDetails_icon, driver);
		return this;
	}

	public Itinerary assertGSTCompanyNameDisplayed() {
		waitElementToBeVisible(gstCompanyName_textbox, driver);
		Assert.assertTrue(gstCompanyName_textbox.isDisplayed(),
				"GST Company Name field is not displayed in the Guest Details Screen");
		return this;
	}

	public Itinerary enterGSTCompanyName(String companyname) {
		waitElementToBeVisible(gstCompanyName_textbox, driver);
		sendkeysElement(gstCompanyName_textbox, companyname, driver);
		return this;
	}

	public Itinerary assertGSTIdentificationNumberDisplayed() {
		waitElementToBeVisible(gstIdentificationNumber_textbox, driver);
		Assert.assertTrue(gstIdentificationNumber_textbox.isDisplayed(),
				"GST Identification Number field is not displayed in the Guest Details Screen");
		return this;
	}

	public Itinerary enterGSTIdentificationNumber(String identificationnumber) {
		waitElementToBeVisible(gstIdentificationNumber_textbox, driver);
		sendkeysElement(gstIdentificationNumber_textbox, identificationnumber, driver);
		return this;
	}

	public Itinerary assertGSTCompanyAddressDisplayed() {
		swipeVerticallyDownTillElementDisplayed(driver, gstCompanyAddress_textbox, 4);
		waitElementToBeVisible(gstCompanyAddress_textbox, driver);
		Assert.assertTrue(gstCompanyAddress_textbox.isDisplayed(),
				"GST Company Address field is not displayed in the Guest Details Screen");
		return this;
	}

	public Itinerary enterGSTCompanyAddress(String companyaddress) {
		waitElementToBeVisible(gstCompanyAddress_textbox, driver);
		sendkeysElement(gstCompanyAddress_textbox, companyaddress, driver);
		return this;
	}

	public Itinerary isContinueToCheckoutButtonDisplayed() {
		waitElementToBeVisible(continueToCheckout_button, driver);
		Assert.assertTrue(continueToCheckout_button.isDisplayed(),
				"Continue To Checkout button is not displayed in the Guest Details Screen");
		return this;
	}

	public Itinerary clickContinueToCheckoutButton() {
		waitElementToBeClickable(continueToCheckout_button);
		clickElement(continueToCheckout_button, driver);
		return this;
	}

	
	public String getHotelName(){
		waitElementToBeVisible(hotelName_text, driver);
		String name = getTextFromElement(hotelName_text, driver);
		return name;
	}

	public Itinerary clickCrossButtonIfCouponsAreNotThereElseClickCoupon() {
		waitElementToBeVisible(enterCouponCode_textbox, driver);
		waitForSeconds(1000);
		if (isElementPresent(availableCoupons_list, driver)) {
			int couponList = getAvailableCouponsListSize();
			int randomIndex = getRandomNumberInRange(0, couponList - 1);
			clickElement(availableCoupons_list.get(randomIndex), driver);
		} else {
			clickElement(closeScreen_button, driver);
		}
		return this;
	}
	
	public int getAvailableCouponsListSize() {
		waitElementToBeVisible(enterCouponCode_textbox, driver);
		int availableCoupons = availableCoupons_list.size();
		return availableCoupons;
		
	}

	public Itinerary enterCouponCode(String couponcode) {
		waitElementToBeVisible(enterCouponCode_textbox, driver);
		waitForSeconds(2000);
		sendkeysElement(enterCouponCode_textbox, couponcode, driver);
		return this;
	}

	public Itinerary clickApplyCouponButton() {
		waitElementToBeClickable(applyCoupon_button);
		clickElement(applyCoupon_button, driver);
		return this;
	}

	public Itinerary assertInvalidCouponCodeTextDisplayed() {
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

	public Itinerary assertPaymentDetails() {
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
	
	public Itinerary assertGuestNameErrorMessageDisplayed() {
		waitElementToBeVisible(guestNameErrorMessage, driver);
		Assert.assertTrue(guestNameErrorMessage.isDisplayed(), "Guest Name Error Message is not displayed even if user forgot to enter Guest Name");
		return this;
	}
	
	public Itinerary assertContactDetailsErrorMessageDisplayed() {
		waitElementToBeVisible(contactNumberErrorMessage, driver);
		Assert.assertTrue(contactNumberErrorMessage.isDisplayed(), "Contact Number Error Message is not displayed even if user forgot to enter Contact Number");
		return this;
	}
	
	public Itinerary assertPrepaidPaymentSectionDisplayed() {
		waitElementToBeVisible(prepaidPayment_section, driver);
		Assert.assertTrue(prepaidPayment_section.isDisplayed(), "Prepeaid Payment Section is not displayed in Itinerary Step 3");
		return this;
	}
	
	public Itinerary assertPayAtHotelSectionDisplayed() {
		waitElementToBeVisible(payAtHotel_section, driver);
		Assert.assertTrue(payAtHotel_section.isDisplayed(), "Pay at Hotel Section is not displayed in Itinerary Step 3");
		return this;
	}
	
	public Itinerary clickPayAtHotelSection() {
		waitElementToBeVisible(payAtHotel_section, driver);
		clickElement(payAtHotel_section, driver);
		return this;
	}
	
	public Itinerary clickPayAtHotelProceedButton() {
		swipeVerticallyDownTillElementDisplayed(driver, payATHotelProceed_button, 3);
		waitElementToBeVisible(payATHotelProceed_button, driver);
		clickElement(payATHotelProceed_button, driver);
		return this;
	}
	
	public Confirmation clickPayAtHotelProceedButtonWithoutOtp() {
		clickPayAtHotelProceedButton();
		return new Confirmation(driver);
	}
	
	
	public Itinerary assertOtpModalDisplayed() {
		waitElementToBeVisible(otp_modal, driver);
		Assert.assertTrue(otp_modal.isDisplayed(), "Otp modal is not displayed even if number is not verified");
		return this;
	}
	
	public Itinerary enterOTP(String otp) {
		waitElementToBeClickable(enterOtp_textbox);
		sendkeysElement(enterOtp_textbox, otp, driver);
		return this;
	}
	
	public Itinerary clickVerifyOTPButton() {
		waitElementToBeClickable(verifyOTP_nutton);
		clickElement(verifyOTP_nutton, driver);
		return this;
	}
	
	public Itinerary assertOtpErrorMessageDisplayed() {
		waitElementToBeVisible(otpErrorMessage, driver);
		Assert.assertTrue(otpErrorMessage.isDisplayed(), "Otp Not Verified Error Message is not displayed even if user entered wrong Otp");
		return this;
	}
	
	public Itinerary clickResendOTPButton() {
		waitElementToBeClickable(resendOTP_button);
		clickElement(resendOTP_button, driver);
		return this;
	}
	
	public Itinerary clickeditPhoneNumberButton() {
		waitElementToBeClickable(editPhoneNumber_Button);
		clickElement(editPhoneNumber_Button, driver);
		return this;
	}
	
	public Itinerary clearPhoneNumberInOtpModal() {
		waitElementToBeVisible(enterMobileNumber_OtpModal, driver);
		clearElement(enterMobileNumber_OtpModal, driver);
		return this;
	}
	
	public Itinerary enterPhoneNumberInOTPModal(String phonenumber) {
		waitElementToBeVisible(enterMobileNumber_OtpModal, driver);
		sendkeysElement(enterMobileNumber_OtpModal, phonenumber, driver);
		return this;
	}
	
	public Itinerary clickCloseOtpModalIcon() {
		waitElementToBeClickable(closeScreen_button);
		clickElement(closeScreen_button, driver);
		return this;
	}
	
	public Itinerary assertPaymentDetailsHeaderInPaymentScreen() {
		waitElementToBeVisible(paymentScreen_header, driver);
		MobileElement payment = paymentScreen_header.findElementByClassName("android.widget.TextView");
		String paymentHeader = payment.getText();
		Assert.assertTrue(paymentHeader.equalsIgnoreCase("Payment Details"), "Expected text is Payment Details but found :" + paymentHeader );
		return this;
	}
	
	
}
